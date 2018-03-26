package com.company;

/*
* This class specifies the service, that is given to a specifik customer.
*/
public class Service extends Product{
    private String serviceCategory; //Skal der laves en separat klasse for kategori, da det kan indeholde flere variable?
    private double retailPrice;
    private int time; //The time it takes to accomplish a service.

    //Contructors
    public Service(String serviceCategory, double retailPrice, int time) {
        this.serviceCategory = serviceCategory;
        this.retailPrice = retailPrice;
        this.time = time;
    }

    //Getters and setters
    public String getServiceCategory() {
        return serviceCategory;
    }

    public void setServiceCategory(String serviceCategory) {
        this.serviceCategory = serviceCategory;
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
}