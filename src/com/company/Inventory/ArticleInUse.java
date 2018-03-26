package com.company;

/*
* This class specifies articles that are in use by hairdressers.
* The amount of specific articles can be changed.
*/
public class ArticleInUse extends Product{
    private String brand;
    private String category;
    private String partNo;
    private int expirationDate;
    private double startAmountInMl;
    private double amountUsedInMl;
    private double amountLeftInMl;

    //Constructors
    public ArticleInUse(String brand,
                        String category,
                        String partNo,
                        int expirationDate,
                        double startAmountInMl,
                        double amountUsedInMl,
                        double amountLeftInMl) {
        this.brand = brand;
        this.category = category;
        this.partNo = partNo;
        this.expirationDate = expirationDate;
        this.startAmountInMl = startAmountInMl;
        this.amountUsedInMl = amountUsedInMl;
        this.amountLeftInMl = amountLeftInMl;
    }

    //Getters and setters
    public String getBrand() {
        return brand;
    }

    public String getCategory() {
        return category;
    }

    public String getPartNo() {
        return partNo;
    }

    public int getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(int expirationDate) {
        this.expirationDate = expirationDate;
    }

    public double getStartAmountInMl() {
        return startAmountInMl;
    }

    public double getAmountUsedInMl() {
        return amountUsedInMl;
    }

    public void setAmountUsedInMl(double amountUsedInMl) {
        this.amountUsedInMl = amountUsedInMl;
    }

    public double getAmountLeftInMl() {
        return amountLeftInMl;
    }
}