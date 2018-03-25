package com.company;
import java.util.Dictionary;

/** Inventory aggregates the class products and keeps track of the inventory.
 * It tells whether the stock is low.
 * if the stock is too low, it tells if the article has been ordered or not.
 * This class DOES NOT order new parts. */

public class Inventory {

    /* Map is a type that takes key, K and value, V as parameters.
     * In this case the key is the product (which is both a type and a class we created ourselves),
     * and the value is the number of products in stock. */
    private Map<Product, int> numberInStock; // this represents the number of a certain product in stock
    private Map<Product, int> lowStock; // this represents the case where the stock is too low - because we will keep track of when a product is low in stock

    // This is the start if there is already an existing stock.
    public Inventory(Map<Product, int> numberInStock, Map<Product, int> lowStock) {
        this.numberInStock = numberInStock;
        this.lowStock = lowStock;
    }

    // If there is no existing stock, this is the start and the first lists will be created.
    public Inventory() {
        this.lowStock = new HashMap();
        this.numberInStock = new HashMap();
    }


    /* NEXT STEPS:
    - Adding indicect accessors: addProduct and removeProduct
     (like getters and setters, for the purpose of adding and removing products to the inventory)
    - clearStockAlert value - for removing automatic ordering from a product that is already added
    - setStockAlertValue - for specifying when (the hairdresser/us) decides that a product is low in stock
    - Do something that makes it possible to notify stakeholders when a change in the inventory has happened.
    - Read notes (observer pattern page 272)
     */



    /* method overloading = two functions can have the same name
     * - in the cases below (addProduct and removeProduct) , if we call both parameter product and parameter number
     * the first function will be called, if we only have a parameter, product the second method will be used. */

    // method signature - fill out functionality
    /**
     * This adds a number of product to the inventory
     * @param p Product
     * @param count How many products are added
     */
    public void addProduct(Product p, int count){
    }

    /**
     * Finished - adds one product
     * @param p Product
     */
    public void addProduct(Product p){
        this.addProduct(p, 1);
    }

    //Fill out functionality
    /**
     * This removes a number of products from the inventory
     * @param p Product
     * @param count How many products are removed
     */
    public void removeProduct(Product p, int count){

    }

    /**
     * Finished - removes one product
     * @param p Product
     */
    public void removeProduct (Product p){
        this.removeProduct(p,1);
    }

    //Fill out functionality
    /**
     * This method sets the number of when a product is low in stock - perhaps it should be renamed
     * @param p Product
     * @param count Minimum number
     */
    public void SetStockAlertValue (Product p, int count){
    }

}
