package com.company;

//This class is a super-class for; Service, ArticleInUse and Article.
public abstract class Product{
    //private String category;
    private String name;
    //private double purchasePrice;

    //Constructors
    public Product(String category, String name, double purchasePrice) {
        this.category = category;
        this.name = name;
        //this.purchasePrice = purchasePrice;
    }

    //Getters
    /*public String getCategory() {
        return category;
    }*/

    public String getName() {
        return name;
    }

    /* public double getPurchasePrice() {
        return purchasePrice;
    }

    //Setters
    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    } */
}



