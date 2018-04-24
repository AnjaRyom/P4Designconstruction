package IxD406.calendar.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/**
 * <h1> Week </h1>
 * This class describes a week
 * Every week has a list of appointments
 */

public class Week {

    int weekNumber;
    List<Appointment> appointments = new ArrayList<Appointment>();
    public enum Day {
        Mandag, Tirsdag, Onsdag, Torsdag, Fredag
    }


    //Constructor for week
    public Week(int weekNumber) {
        this.weekNumber = weekNumber;
    }


    //Getter for week
    public int getWeekNumber() { return weekNumber; }


    /**
     * This method returns the list of appointments
     * @return Appointments - returns the list of appointments
     */
    public List<Appointment> getAppointments() {
        Collections.sort(appointments);
        return appointments;
    }

}
