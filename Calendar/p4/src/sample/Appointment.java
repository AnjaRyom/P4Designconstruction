package sample;

public class Appointment {

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
}
