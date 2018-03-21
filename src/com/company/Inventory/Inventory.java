package com.company;
import java.util.Dictionary;

/** Inventory aggregates the class products and keeps track of the inventory.
 * It tells whether the stock is low.
 * if the stock is too low, it tells if the article has been ordered or not. */

public class Inventory {

    /* Dictionary is a type that takes key, K and value, V as parameters.
     * In this case the key is the product (which is both a type and a class we created ourselves),
     * and the value is the number of products in stock.
     * See description here. https://docs.oracle.com/javase/7/docs/api/java/util/Dictionary.html */
    private Dictionary<Product, int> numberInStock; // this represents the number of a certain product in stock
    private Dictionary<Product, int> lowStock; // this represents the case where the stock is too low

    // This is the start if there is already an existing stock.
    public Inventory(Dictionary<Product, int> numberInStock, Dictionary<Product, int> lowStock) {
        this.numberInStock = numberInStock;
        this.lowStock = lowStock;
    }

    // Her laves de første lister af lageret hvis der ikke eksisterer noget i forvejen.
    public Inventory() {
        this.lowStock = new Dictionary();
        this.numberInStock = new Dictionary();
    }

    
}