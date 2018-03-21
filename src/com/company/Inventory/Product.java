package com.company;


/* Product contains info about the single productList
 * and is a subclass of Inventory and a super class of productOrder.
 * As it is an abstract class, it inherits all the the attributes from it's superclass. */

public abstract class Product extends Inventory {
        String brand;
        String category;
        String name;
        String partNo;
        int shelfPlace;
        int numberInStock;
        double purchasePrice;
        double retailPrice;

//Constructor
    public Product(String productList,
                   int listPlacement,
                   boolean lowStock,
                   boolean isOrdered,
                   String brand,
                   String category,
                   String name,
                   String partNo,
                   int shelfPlace,
                   int numberInStock,
                   double purchasePrice,
                   double retailPrice) {
                        super(productList, listPlacement, lowStock, isOrdered);
                        this.brand = brand;
                        this.category = category;
                        this.name = name;
                        this.partNo = partNo;
                        this.shelfPlace = shelfPlace;
                        this.numberInStock = numberInStock;
                        this.purchasePrice = purchasePrice;
                        this.retailPrice = retailPrice;
    }

    //Getters and setters
    public String getBrand() {
        return brand;
    }

    public String getCategry() {
        return category;
    }

    public void setCategry(String categry) {
        this.category = categry;
    }

    public String getName() {
        return name;
    }

    public String getPartNo() {
        return partNo;
    }

    public int getShelfPlace() {
        return shelfPlace;
    }

    public int setShelfPlace() {
        this.shelfPlace = shelfPlace;
    }

    public int getNumberInStock() {
        return numberInStock;
    }

    public void setNumberInStock(int numberInStock) {
        this.numberInStock = numberInStock;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }
}
