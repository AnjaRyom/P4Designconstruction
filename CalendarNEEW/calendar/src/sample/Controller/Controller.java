package sample.Controller;

import javafx.scene.Scene;
import sample.Model.Appointment;
import sample.Main;
import sample.Model.DatabaseConnecter;
import sample.View.*;
import sample.Model.Week;

import java.sql.ResultSet;
import java.sql.SQLException;
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
    DayView lastDayView;


    WeekView weekView;


    CalendarView calendarViewScene;
    //Stock (instanser af disse indsættes)
    //Kassen (instanser af disse indsættes)
    //Profil (instanser af disse indsættes)


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
    public CalendarView getCalendarViewScene() {
        return calendarViewScene;
    }
    public void setCalendarViewScene(CalendarView calendarViewScene) {
        this.calendarViewScene = calendarViewScene;
    }

    public WeekView getWeekView() {
        return weekView;
    }

    public void setWeekView(WeekView weekView) {
        this.weekView = weekView;
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
        int convertedHour,convertedMinute,convertedDuration,convertedWeekNumber;
        convertedHour = Integer.parseInt(hour);
        convertedMinute = Integer.parseInt(minute);
        convertedDuration = Integer.parseInt(duration);
        convertedWeekNumber = Integer.parseInt(weekNumber);

        Appointment appointment = new Appointment(convertedHour, convertedMinute, convertedDuration,day,employee,customer);
        Week week = weeks.get(convertedWeekNumber-1);
        week.getAppointments().add(appointment);

        //Database stuff
        try {
            DatabaseConnecter.SendSQLStatement("INSERT INTO Appointments VALUES (" + convertedHour + "," + convertedMinute + "," + convertedDuration + "," +
                    convertedWeekNumber + ",\"" + day.toString() + "\",\"" + employee + "\",\"" + customer + "\"," + appointment.getIDforDatabase() + ");");
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }




        if(currentScene instanceof CalendarView){
            CalendarView calendarView = (CalendarView)currentScene;
            calendarView.getCenterMenu().UpdateCenterMenu(currentWeek);
        }
    }


    //This method sets the centermenu to an expanded dayview
    public void ChangeToDayView(DayView dayView){
        if(currentScene instanceof CalendarView){
            lastDayView = dayView;
            CalendarView calendarView = (CalendarView)currentScene;
            calendarView.setCenterMenu(dayView.ExpandView());
            dayView.UpdateCenterMenu(currentWeek);
        }
    }

    public void changeToWeekView(WeekView weekView){

        calendarViewScene.setCenterMenu(weekView);
        weekView.getChildren().add(lastDayView);
        weekView.UpdateCenterMenu(currentWeek);
        currentScene = calendarViewScene;
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


    public void LoadFromDatabase(){
        LoadAppointments();
        if(currentScene instanceof CalendarView){
            CalendarView calendarView = (CalendarView)currentScene;
            calendarView.getCenterMenu().UpdateCenterMenu(currentWeek);
        }
    }


    private void LoadInventory(){

    }

    private void LoadAppointments(){
        try {
            ResultSet tempResult = DatabaseConnecter.SendSQLStatement("SELECT * FROM Appointments;");
            int hour, minutes, duration, weekNumber;
            Main.Employee employee;
            String customer;
            Week.Day day;
            while(tempResult.next()){
                hour = tempResult.getInt("Hour");
                minutes = tempResult.getInt("Minute");
                duration = tempResult.getInt("Duration");
                weekNumber = tempResult.getInt("WeekNumber");
                employee = Main.Employee.valueOf(tempResult.getString("EmployeeName"));
                customer = tempResult.getString("CustomerName");
                day = Week.Day.valueOf(tempResult.getString("DayOfWeek"));

                Appointment newAppointment = new Appointment(hour,minutes,duration,day,employee,customer);

                weeks.get(weekNumber-1).getAppointments().add(newAppointment);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }

    private void LoadCustomer(){

    }

}
