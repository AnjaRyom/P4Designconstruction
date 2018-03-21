package com.company;


/* Inventory is superclass of productList and productOrder.
 * Here is kept track of products, their listPlacement and whether the stock is low.
 * if the stock is too low, it tells if the article has been ordered or not. */

public class Inventory {
        String productList;
        int listPlacement;
        boolean lowStock;
        boolean isOrdered;

//Constructor
    public Inventory(String productList, int listPlacement, boolean lowStock, boolean isOrdered) {
        this.productList = productList;
        this.listPlacement = listPlacement;
        this.lowStock = lowStock;
        this.isOrdered = isOrdered;
    }

//Getters and setters for the whole class
    public String getProductList() {
        return productList;
    }

    public int getListPlacement() {
        return listPlacement;
    }

    public boolean isLowStock() {
        return lowStock;
    }

    public void setLowStock(boolean lowStock) {
        this.lowStock = lowStock;
    }

    public boolean isOrdered() {
        return isOrdered;
    }

    public void setOrdered(boolean ordered) {
        isOrdered = ordered;
    }

}
