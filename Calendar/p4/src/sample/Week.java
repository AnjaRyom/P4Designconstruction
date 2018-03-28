package sample;

import java.util.ArrayList;
import java.util.List;

public class Week {

    int weekNumber;
    List<Appointment> appointments = new ArrayList<>();

    public enum Day {
        MANDAG, TIRSDAG, ONSDAG, TORSDAG, FREDAG
    }


    public Week(int weekNumber) {
        this.weekNumber = weekNumber;
    }


    public List<Appointment> getAppointments() {
        return appointments;
    }



}
