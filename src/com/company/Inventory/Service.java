package com.company;

/*
* This class specifies the service, that is given to a specific customer.
*/
public class Service extends Product {
    private Treatment treatment; //enum
    private double retailPrice;
    private int time; //The time it takes to accomplish a service.
    private Map<String, int> requiredProducts; //products (eg. shampoo) and the amount of them that should be used.

    public Service(Treatment treatment, double retailPrice, int time) {
        this.treatment = treatment;
        this.retailPrice = retailPrice;
        this.time = time;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }

    public double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Map<String, int> getRequiredProducts() { return requiredProducts; }


}