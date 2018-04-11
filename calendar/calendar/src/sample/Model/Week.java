package sample.Model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;

/*
* This class describes a week
* Every week has a list of appointments
*/

public class Week {

    int weekNumber;
    List<Appointment> appointments = new ArrayList<Appointment>();

    public enum Day {
        MANDAG, TIRSDAG, ONSDAG, TORSDAG, FREDAG
    }


    //Constructor for week
    public Week(int weekNumber) {
        this.weekNumber = weekNumber;
    }


    //Getters for week
    public int getWeekNumber() {
        return weekNumber;
    }

    //This method returns the list of appoinments
    public List<Appointment> getAppointments() {
        Collections.sort(appointments);
        return appointments;
    }

}
