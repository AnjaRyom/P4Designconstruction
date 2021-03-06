package sample.Model;

import sample.Model.Employee;

public class Apprentices extends Employee {

    private boolean scholarship;

    public Apprentices(String firstName, String lastName, String address, int phoneNumber, int dateOfBirth,
                       String sex, double basePrice, int experienceYears, int experienceMonths, String description, String recommendations,
                       int holidayDaysAmount, int sicknessDaysAmount, boolean present, boolean bonus, String identificationColor, boolean scholarship)
    {
        super(firstName, lastName, address, phoneNumber, dateOfBirth, sex, basePrice, experienceYears, experienceMonths, description, recommendations, holidayDaysAmount, sicknessDaysAmount, present, bonus, identificationColor);
        this.scholarship = scholarship;
    }

    public boolean isScholarship() {
        return scholarship;
    }

    public void setScholarship(boolean scholarship) {
        this.scholarship = scholarship;
    }
}
