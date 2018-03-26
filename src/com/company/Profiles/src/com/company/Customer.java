package com.company;

public class Customer {

    private String hairtype;
    private String hairColor;
    private String hairLength;
    private String purchasedProducts;
    private int ranking;
    private string notes;

    public Customer(String hairtype, String hairColor, String hairLength, String purchasedProducts, int ranking, string notes) {
        this.hairtype = hairtype;
        this.hairColor = hairColor;
        this.hairLength = hairLength;
        this.purchasedProducts = purchasedProducts;
        this.ranking = ranking;
        this.notes = notes;
    }

    public String getHairtype() {
        return hairtype;
    }

    public void setHairtype(String hairtype) {
        this.hairtype = hairtype;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getHairLength() {
        return hairLength;
    }

    public void setHairLength(String hairLength) {
        this.hairLength = hairLength;
    }

    public String getPurchasedProducts() {
        return purchasedProducts;
    }

    public void setPurchasedProducts(String purchasedProducts) {
        this.purchasedProducts = purchasedProducts;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public string getNotes() {
        return notes;
    }

    public void setNotes(string notes) {
        this.notes = notes;
    }
}
