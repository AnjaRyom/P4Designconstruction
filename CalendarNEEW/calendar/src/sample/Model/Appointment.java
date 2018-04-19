package sample.Model;

import sample.Main;

/*
* This class describes the appointment
* It implements Comparable (which is an interface) because we need to sort the appointments
*/

public class Appointment implements Comparable<Appointment> {

    int hour;
    int minute;
    int durationInMinutes;
    Week.Day appointmentDay;
    Main.Employee employee;
    String customer;

    int IDforDatabase = 0;
    public static int IDCounter = 0;


    //Constructor for appointment
    public Appointment(int hour, int minute, int durationInMinutes, Week.Day day, Main.Employee employee, String customer) {
        this.hour = hour;
        this.minute = minute;
        this.durationInMinutes = durationInMinutes;
        this.customer = customer;
        this.employee = employee;
        this.appointmentDay = day;
        IDforDatabase = IDCounter;
        IDCounter++;
    }

    //Getters for appointment
    public int getHour() {
        return hour;
    }
    public int getMinute() {
        return minute;
    }
    public int getDurationInMinutes() {
        return durationInMinutes;
    }
    public Week.Day getAppointmentDay() {
        return appointmentDay;
    }
    public Main.Employee getEmployee() {
        return employee;
    }
    public String getCustomer() {
        return customer;
    }
    public int getIDforDatabase() {
        return IDforDatabase;
    }


    //This method returns the minute at which the
    //appointment begins where hour 8 is equal to 0 minutes
    public int MinuteOfStartingPoint(){
        if(hour == 8){
            return minute;
        }
        else return (hour-8)*60 + minute;
    }

    //This method compare 2 appointments with each other to sort them according to time
    @Override
    public int compareTo(Appointment another) {
        if (this.getHour()<another.getHour()){
            return -1;
        }else if(this.getHour() > another.getHour()){
            return 1;
        }
        else if(this.getMinute() < another.getMinute()){
            return -1;
        }
        else if(this.getMinute() > another.getMinute()){
            return 1;
        }
        else return 0;
    }
}
