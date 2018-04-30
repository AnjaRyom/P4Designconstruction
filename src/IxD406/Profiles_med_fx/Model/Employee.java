package IxD406.Profiles_med_fx.Model;

public class Employee extends Person {

    private double basePrice;
    private int experienceYears;
    private int experienceMonths;
    private String description;
    private String recommendations;
    private int holidayDaysAmount;
    private int sicknessDaysAmount;
    private boolean present;
    private boolean bonus;
    private String identificationColor;
    //List<Appointment> appointmentsForEmployee = new ArrayList<>();

    public Employee(String firstName, String lastName, String address, int phoneNumber, int dateOfBirth, String sex,
                    double basePrice, int experienceYears, int experienceMonths, String description,
                    String recommendations, int holidayDaysAmount, int sicknessDaysAmount, boolean present, boolean bonus, String identificationColor) {
        super(firstName, lastName, address, phoneNumber, dateOfBirth, sex);
        this.basePrice = basePrice;
        this.experienceYears = experienceYears;
        this.experienceMonths = experienceMonths;
        this.description = description;
        this.recommendations = recommendations;
        this.holidayDaysAmount = holidayDaysAmount;
        this.sicknessDaysAmount = sicknessDaysAmount;
        this.present = present;
        this.bonus = bonus;
        this.identificationColor = identificationColor;
    }


    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public int getExperienceMonths() {
        return experienceMonths;
    }

    public void setExperienceMonths(int experienceMonths) {
        this.experienceMonths = experienceMonths;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(String recommendations) {
        this.recommendations = recommendations;
    }

    public int getHolidayDaysAmount() {
        return holidayDaysAmount;
    }

    public void setHolidayDaysAmount(int holidayDaysAmount) {
        this.holidayDaysAmount = holidayDaysAmount;
    }

    public int getSicknessDaysAmount() {
        return sicknessDaysAmount;
    }

    public void setSicknessDaysAmount(int sicknessDaysAmount) {
        this.sicknessDaysAmount = sicknessDaysAmount;
    }

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }

    public boolean isBonus() {
        return bonus;
    }

    public void setBonus(boolean bonus) {
        this.bonus = bonus;
    }

    public String getIdentificationColor() {
        return identificationColor;
    }

    public void setIdentificationColor(String identificationColor) {
        this.identificationColor = identificationColor;
    }
}
