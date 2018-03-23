package com.company;


/* The Product class contains info about the single product
 * it can be edited by using the constructor but only location
 * and retailPrice can be edited when it already exist (by setters).
 */

public class Product {
    private String brand;
    private String category;
    private String name;
    private String partNo;
    private Location location;
    //private int numberInStock;   flyttet til inventory
    private double purchasePrice;
    private double retailPrice;

    //Constructor
    public Product(String brand,
                   String category,
                   String name,
                   String partNo,
                   int location,
                   //int numberInStock,
                   double purchasePrice,
                   double retailPrice) {
        this.brand = brand;
        this.category = category;
        this.name = name;
        this.partNo = partNo;
        this.location = location;
        //this.numberInStock = numberInStock;
        this.purchasePrice = purchasePrice;
        this.retailPrice = retailPrice;
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

    //Setters - dem der ikke har en setter, kan ikke ændres af andet end objektet selv

    /**
     * Change product location
     * @param location New item location
     */
    public void setLocation(int location) {
        this.location = location;
    }

    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }
}



