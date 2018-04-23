package sample.Controller;

import javafx.scene.Scene;
import sample.Main;
import sample.Model.*;
import sample.View.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


/**
 * <h1>Controller</h1>
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
    public Week getCurrentWeek() { return currentWeek; }
    public CalendarView getCalendarViewScene() { return calendarViewScene; }
    public void setCalendarViewScene(CalendarView calendarViewScene) { this.calendarViewScene = calendarViewScene; }
    public WeekView getWeekView() { return weekView; }
    public void setWeekView(WeekView weekView) { this.weekView = weekView; }

    //Constructor for controller
    public Controller() {
        MakeWeeks();
        StartingWeek();
    }


    /**
     * This method finds the current week
     * -1 because of index 0 in list (weeks are in a list)
     */
    private void StartingWeek(){
        int localWeek = Calendar.getInstance().get(Calendar.WEEK_OF_YEAR);
        currentWeek = weeks.get(localWeek-1);

    }

    /**
     * This method makes the 52 weeks and adds them to the list of weeks
     */
    private void MakeWeeks(){
        for (int i = 0; i < 52; i++) {
            weeks.add(new Week(i+1));
        }

    }

    /**
     * This method creates a new instance of the
     * NewAppointmentView and shows it
     */
    public void ShowNewAppointmentView(){
        NewAppointmentView newAppointment = new NewAppointmentView(this);
    }

    /**
     * This methods shows the information about an appointment
     * @param appointment Appointment - specifies the appointment which is shown
     */
    public void ShowExistingAppointmentView(Appointment appointment){
        AppointmentInformationView informationView = new AppointmentInformationView(this,appointment, "Appointment for "+appointment.getCustomer());

    }


    /**
     * This method creates a new instance of appointment and adds it to the list of appointments for the corresponding week
     * Finally it updates the view
     * @param hour String - the hour information for an appointment
     * @param minute String - the minute information for an appointment
     * @param weekNumber String - the weeknumber information for an appointment
     * @param day Week.Day - the day of week for an appointment
     * @param duration String - the duration in minutes for an appointment
     * @param employee Employee - the employee for an appointment
     * @param customer String - the customer for an appointment
     * @param phoneNumber - String - the phonenumber of an customer for an appointment
     */
    public void CreateAndSaveAppointment(String hour, String minute, String weekNumber,
                                         Week.Day day, String duration, Employee employee, String customer, String phoneNumber, Service service){

        int convertedHour,convertedMinute,convertedDuration,convertedWeekNumber, convertedPhoneNumber;
        String convertedService;

        //Converting variables to fit the database types
        convertedHour = Integer.parseInt(hour);
        convertedMinute = Integer.parseInt(minute);
        convertedDuration = Integer.parseInt(duration);
        convertedWeekNumber = Integer.parseInt(weekNumber);
        convertedPhoneNumber = Integer.parseInt(phoneNumber);


        Appointment appointment = new Appointment(convertedHour, convertedMinute, convertedDuration, convertedPhoneNumber, day,employee,customer, convertedWeekNumber,0, service);
        Week week = weeks.get(convertedWeekNumber-1);
        week.getAppointments().add(appointment);
        employee.getAppointmentsForEmployee().add(appointment);

        String serviceToDatabase = service.getNameOfService();

        //This try catch sends a SQL statement, which saves the appointment to the database
        try {
            DatabaseConnecter.SendSQLStatement("INSERT INTO Appointments VALUES (" + convertedHour + "," + convertedMinute + "," + convertedDuration + "," +
                    convertedWeekNumber + ",\"" + day.toString() + "\",\"" + employee.getName() + "\",\"" + customer + "\"," + appointment.getIDforDatabase() + ","
                    + convertedPhoneNumber + ",\"" + serviceToDatabase + "\");");
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

        //This if statement updates the centermenu
        if(currentScene instanceof CalendarView){
            CalendarView calendarView = (CalendarView)currentScene;
            calendarView.getCenterMenu().UpdateCenterMenu(currentWeek);
        }
    }


    /**
     * This method sets the centermenu to an expanded dayview
     * lastDayView is created because when setting the centermenu to a dayview,
     * the dayview is removed from the children of the weekview
     * and therefore must be reinserted as child
     * Furthermore it sets the topmenu's Hbox to the fitting Hbox
     * @param dayView DayView - the dayview which is to be set as centermenu
     */
    public void ChangeToDayView(DayView dayView){
        if(currentScene instanceof CalendarView){
            lastDayView = dayView;
            CalendarView calendarView = (CalendarView)currentScene;
            calendarView.setCenterMenu(dayView.ExpandView());
            if(!calendarView.getTopMenu().isHboxForDayCreated()){
                calendarView.getTopMenu().createHBoxForDay();
            }
            calendarView.getTopMenu().ChangeHBoxToDay();
            dayView.UpdateCenterMenu(currentWeek);
        }
    }

    /**
     * This method sets the centermenu to a weekview
     * @param weekView WeekView - the weekview which is to be set as centermenu
     * */
    public void changeToWeekView(WeekView weekView){
        calendarViewScene.setCenterMenu(weekView);
        weekView.getChildren().add(lastDayView);
        weekView.UpdateCenterMenu(currentWeek);
        calendarViewScene.getTopMenu().ChangeHBoxToWeek();
        currentScene = calendarViewScene;
    }

    /**
     * This method sets the currentweek to the next week in the week list
     * If the next week is week 53, the current week is set to 0 (week 1)
     */
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


    /**
     * This method sets the currentweek to the previous week in the week list
     * If the previous week is week -1, the current week is set to 51 (week 52)
     */
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

    /**
     * This method sets the centermenu to the following dayview
     * If it is friday when setting the following dayview, the dayview monday is chosen
     * and the NextWeek method is called
     */
    public void NextDay(){
        DayView currentDayView = (DayView)((CalendarView)currentScene).getCenterMenu();
        Week.Day currentDay = ((DayView)((CalendarView)currentScene).getCenterMenu()).getDay();
        int indexOfCurrentDayView = weekView.getDayViews().indexOf(currentDayView);
        DayView nextDayView;
        if(currentDay.equals(Week.Day.Fredag)){
            NextWeek();
            nextDayView = weekView.getDayViews().get(0);
        }
        else nextDayView = weekView.getDayViews().get(indexOfCurrentDayView+1);

        ChangeToDayView(nextDayView);
    }

    /**
     * This methods sets the centermenu to the previous dayview
     * If it is monday when setting the previous dayview, the dayview friday is chosen
     * and the PreviousWeek method is called
     */
    public void PreviousDay(){
        DayView currentDayView = (DayView)((CalendarView)currentScene).getCenterMenu();
        Week.Day currentDay = ((DayView)((CalendarView)currentScene).getCenterMenu()).getDay();
        int indexOfCurrentDayView = weekView.getDayViews().indexOf(currentDayView);
        DayView nextDayView;
        if(currentDay.equals(Week.Day.Mandag)){
            PreviousWeek();
            nextDayView = weekView.getDayViews().get(4);
        }
        else nextDayView = weekView.getDayViews().get(indexOfCurrentDayView-1);

        ChangeToDayView(nextDayView);
    }

    /**
     * This method loads all relevant data from the database
     */
    public void LoadFromDatabase(){
        LoadAppointments();
        if(currentScene instanceof CalendarView){
            CalendarView calendarView = (CalendarView)currentScene;
            calendarView.getCenterMenu().UpdateCenterMenu(currentWeek);
        }
    }

    /**
     * This method loads all data from the table Inventory in our database
     */
    private void LoadInventory(){

    }

    /**
     * This method loads all data from the table Appoinments in our database
     */
    private void LoadAppointments(){
        //This try catch sends a SQL statement, which loads data from the table Appointments
        //Furthermore the appointments is created
        try {
            ResultSet tempResult = DatabaseConnecter.SendSQLStatement("SELECT * FROM Appointments;");
            int hour, minutes, duration, weekNumber, phoneNumber,ID;
            String service;
            Employee employee;
            String customer;
            Week.Day day;
            
            while(tempResult.next()){
                hour = tempResult.getInt("Hour");
                minutes = tempResult.getInt("Minute");
                duration = tempResult.getInt("Duration");
                weekNumber = tempResult.getInt("WeekNumber");
                String employeeName = tempResult.getString("EmployeeName");
                employee = Employee.getEmployeeByName(employeeName);
                customer = tempResult.getString("CustomerName");
                day = Week.Day.valueOf(tempResult.getString("DayOfWeek"));
                phoneNumber  = tempResult.getInt("PhoneNumber");
                ID = tempResult.getInt("ID");
                service = tempResult.getString("Service");

                Appointment newAppointment = new Appointment(hour,minutes,duration, phoneNumber, day,employee,customer, weekNumber,ID, FindService(service));

                weeks.get(weekNumber-1).getAppointments().add(newAppointment);
                employee.getAppointmentsForEmployee().add(newAppointment);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }

    /**
     * This method finds the service that fit the service as a string
     * @param serviceAsString String - used to find the right service that fits the string
     * @return Service - returns the service that fits the string
     */
    public Service FindService(String serviceAsString){
        for (Service service : Main.listOfServices) {
            if(service.getNameOfService().equals(serviceAsString))
                return service;
        } return null;
    }

    /**
     * This method loads all data from the table Customer in our database
     */
    private void LoadCustomer(){

    }

    /**
     * This method removes an apoointment from the lists of appointments (list for week, list for employee)
     * and removes it from the database
     * @param appointment Appointment - specifies the appointment which is about to be deleted
     */
    public void DeleteAppointment(Appointment appointment){
        weeks.get(appointment.getWeekNumber()-1).getAppointments().remove(appointment);
        appointment.getEmployee().getAppointmentsForEmployee().remove(appointment);

        //This try catch sends a SQL statement, which delete an appointment's data from the table Appointments
        try{
            DatabaseConnecter.SendSQLStatement(DeleteAppointmentFromDatabase(appointment));

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        if(currentScene instanceof CalendarView){
            CalendarView calendarView = (CalendarView)currentScene;
            calendarView.getCenterMenu().UpdateCenterMenu(currentWeek);
        }
    }

    /**
     * This methods returns the SQL statement for removing an appointment from the database
     * @param appointment Appointment - specifies the appointment which is about to be deleted
     * @return String - return the SQL statement, for the DeleteAppointment method
     */
    private String DeleteAppointmentFromDatabase(Appointment appointment){
        return "DELETE FROM Appointments WHERE ID = " + appointment.getIDforDatabase() + ";";
    }


    /**
     * This method overwrites an existing appointment(edit functionality)
     * @param appointment Appointment - specifies the appointment which is about to be overwritten
     * @param hour String - the hour information for an appointment
     * @param minute String - the minute information for an appointment
     * @param weekNumber String - the weeknumber information for an appointment
     * @param day Week.Day - the day of week for an appointment
     * @param duration String - the duration in minutes for an appointment
     * @param employee Employee - the employee for an appointment
     * @param customer String - the customer for an appointment
     * @param phoneNumber - String - the phonenumber of an customer for an appointment
     */
    public void OverWriteAppointment(Appointment appointment, String hour, String minute, String weekNumber,
                                         Week.Day day, String duration, Employee employee, String customer, String phoneNumber, Service service){

        int convertedHour,convertedMinute,convertedDuration,convertedWeekNumber, convertedPhoneNumber;

        convertedHour = Integer.parseInt(hour);
        convertedMinute = Integer.parseInt(minute);
        convertedDuration = Integer.parseInt(duration);
        convertedWeekNumber = Integer.parseInt(weekNumber);
        convertedPhoneNumber = Integer.parseInt(phoneNumber);

        appointment.setHour(convertedHour);
        appointment.setMinute(convertedMinute);
        appointment.setWeekNumber(convertedWeekNumber);
        appointment.setAppointmentDay(day);
        appointment.setDurationInMinutes(convertedDuration);
        appointment.setPhoneNumber(convertedPhoneNumber);
        appointment.setEmployee(employee);
        appointment.setCustomer(customer);
        appointment.setService(service);

        SaveOverWrittenAppointmentInDatabase(appointment);


        if(currentScene instanceof CalendarView){
            CalendarView calendarView = (CalendarView) currentScene;
            calendarView.getCenterMenu().UpdateCenterMenu(currentWeek);
        }
    }

    /**
     * This method saves the overwritten appointment in the database
     * @param appointment Appointment - specifies the appointment which is about to be overwritten in the database
     */
    private void SaveOverWrittenAppointmentInDatabase(Appointment appointment){
        try {
            DatabaseConnecter.SendSQLStatement(OverWriteAppointmentInDatabase(appointment));

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * This methods returns the SQL statement for editing an appointment in the database
     * @param appointment Appointments - specifies the appointment which is about to be overwritten in the database
     * @return String - return the SQL statement, for the SaveOverWrittenAppointmentInDatabase methhod
     */
    private String OverWriteAppointmentInDatabase(Appointment appointment){
        String serviceAsString = appointment.getService().getNameOfService();
        return "UPDATE Appointments SET Hour = " + appointment.getHour() + ", Minute = "
                + appointment.getMinute() + ", Duration = " + appointment.getDurationInMinutes() + ", WeekNumber = " +
                appointment.getWeekNumber() + ", DayOfWeek = \"" + appointment.getAppointmentDay() + "\", EmployeeName = \"" +
                appointment.getEmployee().getName() + "\", CustomerName = \"" + appointment.getCustomer() + "\", PhoneNumber = " + appointment.getPhoneNumber() +
                " WHERE ID = " + appointment.getIDforDatabase() + ", Service = " + serviceAsString + ";";


    }
}
