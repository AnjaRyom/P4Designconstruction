package sample.Controller;

import javafx.scene.Scene;
import sample.Model.Appointment;
import sample.Main;
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

    public Scene getCurrentScene() {
        return currentScene;
    }

    public void setCurrentScene(Scene currentScene) {
        this.currentScene = currentScene;
    }


    public Controller() {
        MakeWeeks();
        StartingWeek();
    }

    public Week getCurrentWeek() {
        return currentWeek;
    }

    private void StartingWeek(){
        int localWeek = Calendar.getInstance().get(Calendar.WEEK_OF_YEAR);
        currentWeek = weeks.get(localWeek-1);

    }

    private void MakeWeeks(){
        //Makes 52 weeks, and adds them to the list weeks
        for (int i = 0; i < 52; i++) {
            weeks.add(new Week(i+1));
        }

    }

    public void ShowNewAppointmentView(){
        NewAppointmentView newAppointment = new NewAppointmentView(this);
        newAppointment.display("New appointment");
    }

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

    public void ChangeToDayView(DayView dayView){
        if(currentScene instanceof CalendarView){
            CalendarView calendarView = (CalendarView)currentScene;
            calendarView.setCenterMenu(dayView.ExpandView());
            dayView.UpdateCenterMenu(currentWeek);
        }
    }

    public void NextWeek(){
        currentWeek = weeks.get(weeks.indexOf(currentWeek)+1);
        if(currentScene instanceof CalendarView){
            CalendarView calendarView = (CalendarView)currentScene;
            calendarView.getCenterMenu().UpdateCenterMenu(currentWeek);
        }
    }

    public void PreviousWeek(){
        currentWeek = weeks.get(weeks.indexOf(currentWeek)-1);
        if(currentScene instanceof CalendarView){
            CalendarView calendarView = (CalendarView)currentScene;
            calendarView.getCenterMenu().UpdateCenterMenu(currentWeek);
        }
    }

}
