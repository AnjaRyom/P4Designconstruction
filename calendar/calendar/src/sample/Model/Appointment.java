package sample.Model;

import sample.Main;

/*
* This class describes the appointment
*
*/

public class Appointment implements Comparable<Appointment> {

    int hour;
    int minute;
    int durationInMinutes;
    Week.Day appointmentDay;
    Main.Employee employee;
    String customer;



    public Appointment(int hour, int minute, int durationInMinutes, Week.Day day, Main.Employee employee, String customer) {
        this.hour = hour;
        this.minute = minute;
        this.durationInMinutes = durationInMinutes;
        this.customer = customer;
        this.employee = employee;
        this.appointmentDay = day;
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


    public int MinuteOfStartingPoint(){
        if(hour == 8){
            return minute;
        }
        else return (hour-8)*60 + minute;
    }

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
