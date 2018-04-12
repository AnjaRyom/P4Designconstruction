package sample.Model;

public class Hairdresser extends Employee {

    private String preferences;

    public Hairdresser(String firstName, String lastName, String address, int phoneNumber, int dateOfBirth, String sex, double basePrice, int experienceYears, int experienceMonths, String description, String recommendations,
                       int holidayDaysAmount, int sicknessDaysAmount, boolean present, boolean bonus, String identificationColor, String preferences) {
        super(firstName, lastName, address, phoneNumber, dateOfBirth, sex, basePrice, experienceYears, experienceMonths, description, recommendations,
                holidayDaysAmount, sicknessDaysAmount, present, bonus, identificationColor);
        this.preferences = preferences;
    }

    public String getPreferences() {
        return preferences;
    }

    public void setPreferences(String preferences) {
        this.preferences = preferences;
    }



}

