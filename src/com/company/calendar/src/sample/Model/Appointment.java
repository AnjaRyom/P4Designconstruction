package sample.Model;

/**
 * <h1> Appointment </h1>
 * This class describes the appointment
 * It implements Comparable (which is an interface) because we need to sort the appointments
 */


public class Appointment implements Comparable<Appointment> {

    int hour;
    int minute;
    int durationInMinutes;
    int phoneNumber;
    int weekNumber;
    Week.Day appointmentDay;
    Employee employee;
    String customer;
    Service service;
    int IDforDatabase = 1;
    public static int IDCounter = 1;


    //Constructor for appointment
    public Appointment(int hour, int minute, int durationInMinutes, int phoneNumber, Week.Day day, Employee employee, String customer, int weekNumber, int IDforDatabase, Service service) {
        this.hour = hour;
        this.minute = minute;
        this.durationInMinutes = durationInMinutes;
        this.phoneNumber = phoneNumber;
        this.customer = customer;
        this.employee = employee;
        this.appointmentDay = day;
        this.weekNumber = weekNumber;
        this.service = service;

        //When loading from the database the ID != 0
        //When creating appointments the id = 0, it depends on the IDCounter
        if(IDforDatabase == 0){
            this.IDforDatabase = IDCounter;
        }else{
            this.IDforDatabase = IDforDatabase;
            IDCounter = this.IDforDatabase;
        }
        IDCounter++;
    }

    //Getters for appointment
    public int getHour() { return hour; }
    public int getMinute() { return minute; }
    public int getDurationInMinutes() { return durationInMinutes; }
    public int getPhoneNumber() { return phoneNumber; }
    public Week.Day getAppointmentDay() { return appointmentDay; }
    public Employee getEmployee() { return employee; }
    public String getCustomer() { return customer; }
    public int getWeekNumber() { return weekNumber; }
    public int getIDforDatabase() { return IDforDatabase; }
    public Service getService() { return service; }


    //Setters for appointment
    public void setHour(int hour) { this.hour = hour; }
    public void setMinute(int minute) { this.minute = minute; }
    public void setDurationInMinutes(int durationInMinutes) { this.durationInMinutes = durationInMinutes; }
    public void setPhoneNumber(int phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setWeekNumber(int weekNumber) { this.weekNumber = weekNumber; }
    public void setAppointmentDay(Week.Day appointmentDay) { this.appointmentDay = appointmentDay; }
    public void setEmployee(Employee employee) { this.employee = employee; }
    public void setCustomer(String customer) { this.customer = customer; }
    public void setService(Service service) { this.service = service; }

    /**
     * This method returns the minute at which the
     * appointment begins where hour 8 is equal to 0 minutes
     * @return int - returns the starting point of an appointment
     */
    public int MinuteOfStartingPoint(){
        if(hour == 8){
            return minute * 2;
        }
        else return ((hour-8)*60 + minute)*2;
    }

    /**
     * This method compare 2 appointments with each other to sort them according to time
     * @param another Appointment - the appointment which this is compared to
     * @return int - returns -1 if this is before another,
     * returns 0 if this is at the same time as another, returns 1 if another is before this
     */
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
