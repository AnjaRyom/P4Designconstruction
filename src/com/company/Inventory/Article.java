package com.company;


/* The Article class contains info about the single product
 * it can be edited by using the constructor but only location
 * and retailPrice can be edited when it already exist (by setters).
 */

public class Article extends Product {
    private String brand;
    private String category;
    private String name;
    private String partNo;
    private Location location;
    private double purchasePrice;
    private double retailPrice;
    private int expirationDate;

    //Constructor
    public Article(String brand,
                   String category,
                   String name,
                   String partNo,
                   int location,
                   double purchasePrice,
                   double retailPrice) {
        this.brand = brand;
        this.category = category;
        this.name = name;
        this.partNo = partNo;
        this.location = location;
        this.purchasePrice = purchasePrice;
        this.retailPrice = retailPrice;
        this.expirationDate = expirationDate;
    }

    //Getters

    public String getBrand() {
        return brand;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public String getPartNo() {
        return partNo;
    }

    public int getLocation() {
        return location;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public double getRetailPrice() {
        return retailPrice;
    }

    public int getExpirationDate() { return expirationDate; }

    //Setters - those without setter cannot be edited by other than the object itself

    /**
     * Change article location
     * @param location New article location
     */
    public void setLocation(int location) {
        this.location = location;
    }

    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }
}



