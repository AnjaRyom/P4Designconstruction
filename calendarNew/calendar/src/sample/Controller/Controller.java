package sample.Controller;

import javafx.scene.Scene;
import sample.Model.Appointment;
import sample.Main;
import sample.View.AppointmentInformationView;
import sample.View.CalendarView;
import sample.View.DayView;
import sample.View.NewAppointmentView;
import sample.Model.Week;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/*
 * The controller class is responsible for linking model and view
 * The class contains methods for altering and retrieving data from the model
 * Furthermore it contains methods for controlling view segments
 */
public class Controller {

    List<Week> weeks = new ArrayList<>();
    Week currentWeek;
    Scene currentScene;

    //Getters and setters
    public Scene getCurrentScene() {
        return currentScene;
    }
    public void setCurrentScene(Scene currentScene) {
        this.currentScene = currentScene;
    }
    public Week getCurrentWeek() {
        return currentWeek;
    }


    //Constructor for controller
    public Controller() {
        MakeWeeks();
        StartingWeek();
    }


    //This method find the current week
    private void StartingWeek(){
        int localWeek = Calendar.getInstance().get(Calendar.WEEK_OF_YEAR);
        currentWeek = weeks.get(localWeek-1);

    }

    //This method makes the 52 weeks and adds them to the list of weeks
    private void MakeWeeks(){
        //Makes 52 weeks, and adds them to the list weeks
        for (int i = 0; i < 52; i++) {
            weeks.add(new Week(i+1));
        }

    }

    //This method creates a new instance of the NewAppointmentView and shows it
    public void ShowNewAppointmentView(){
        NewAppointmentView newAppointment = new NewAppointmentView(this);
        newAppointment.display("New appointment");
    }

    //This methods shows the information about an appointment
    public void ShowExistingAppointmentView(Appointment appointment){
        AppointmentInformationView informationView = new AppointmentInformationView("Appointment for "+appointment.getCustomer(),this,appointment);

    }


    //This method creates a new instance of appointment and adds it to the list of appointments for the corresponding week
    //Finally it updates the view
    public void CreateAndSaveAppointment(String hour, String minute, String weekNumber,
                                         Week.Day day, String duration, Main.Employee employee, String customer){

        Appointment appointment = new Appointment(Integer.parseInt(hour), Integer.parseInt(minute), Integer.parseInt(duration),day,employee,customer);
        Week week = weeks.get(Integer.parseInt(weekNumber)-1);
        week.getAppointments().add(appointment);

        if(currentScene instanceof CalendarView){
            CalendarView calendarView = (CalendarView)currentScene;
            calendarView.getCenterMenu().UpdateCenterMenu(currentWeek);
        }
    }


    //This method sets the centermenu to an expanded dayview
    public void ChangeToDayView(DayView dayView){
        if(currentScene instanceof CalendarView){
            CalendarView calendarView = (CalendarView)currentScene;
            calendarView.setCenterMenu(dayView.ExpandView());
            dayView.UpdateCenterMenu(currentWeek);
        }
    }

    //This method sets the currentweek to the next week in the week list
    //If the next week is week 53, the current week is set to 0 (week 1)
    public void NextWeek(){
        if(weeks.indexOf(currentWeek)+1 == 52){
            currentWeek = weeks.get(0);
        }
        else currentWeek = weeks.get(weeks.indexOf(currentWeek)+1);
        if(currentScene instanceof CalendarView){
            CalendarView calendarView = (CalendarView)currentScene;
            calendarView.getCenterMenu().UpdateCenterMenu(currentWeek);
        }
    }

    //This method sets the currentweek to the previous week in the week list
    //If the previous week is week -1, the current week is set to 51 (week 52)
    public void PreviousWeek(){
        if(weeks.indexOf(currentWeek)-1 < 0){
            currentWeek = weeks.get(51);
        }
        else currentWeek = weeks.get(weeks.indexOf(currentWeek)-1);
        if(currentScene instanceof CalendarView){
            CalendarView calendarView = (CalendarView)currentScene;
            calendarView.getCenterMenu().UpdateCenterMenu(currentWeek);
        }
    }

}
