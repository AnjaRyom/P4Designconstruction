package sample;

import javafx.scene.Scene;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    List<Week> weeks = new ArrayList<>();
    Scene currentScene;

    public Scene getCurrentScene() {
        return currentScene;
    }

    public void setCurrentScene(Scene currentScene) {
        this.currentScene = currentScene;
    }


    public Controller() {
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
        Week week = weeks.get(Integer.parseInt(weekNumber));
        week.getAppointments().add(appointment);

        if(currentScene instanceof CalendarView){
            CalendarView calendarView = (CalendarView)currentScene;
            calendarView.getCenterMenu().AddButtonForAppointment(appointment);

        }
    }
}
