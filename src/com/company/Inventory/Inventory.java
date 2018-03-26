package com.company;
import java.util.Dictionary;

/** Inventory aggregates the class article and keeps track of the inventory.
 * It tells whether the stock is low.
 * if the stock is too low, it tells if the article has been ordered or not.
 * This class DOES NOT order new parts. */

public class Inventory {

    /* Map is a type that takes key, K and value, V as parameters.
     * In this case the key is the article (which is both a type and a class we created ourselves),
     * and the value is the number of articles in stock. */
    private Map<Article, int> numberInStock; // this represents the number of a certain article in stock
    private Map<Article, int> lowStock; // this represents the case where the stock is too low - because we will keep track of when an article is low in stock

    // This is the start if there is already an existing stock.
    public Inventory(Map<Article, int> numberInStock, Map<Article, int> lowStock) {
        this.numberInStock = numberInStock;
        this.lowStock = lowStock;
    }

    // If there is no existing stock, this is the start and the first lists will be created.
    public Inventory() {
        this.lowStock = new HashMap();
        this.numberInStock = new HashMap();
    }


    /* NEXT STEPS:
    - Adding indicect accessors: addArticle and removeArticle
     (like getters and setters, for the purpose of adding and removing articles to the inventory)
    - clearStockAlert value - for removing automatic ordering from an article that is already added
    - setStockAlertValue - for specifying when (the hairdresser/us) decides that an article is low in stock
    - Do something that makes it possible to notify stakeholders when a change in the inventory has happened.
    - Read notes (observer pattern page 272)
     */



    /* method overloading = two functions can have the same name
     * - in the cases below (addArticle and removeArticle) , if we call both parameter article and parameter number
     * the first function will be called, if we only have a parameter, article the second method will be used. */

    // method signature - fill out functionality
    /**
     * This adds a number of articles to the inventory
     * @param a Article
     * @param count How many articles are added
     */
    public void addArticle(Article a, int count){
    }

    /**
     * Finished - adds one article
     * @param a Article
     */
    public void addArticle(Article a){
        this.addArticle(a, 1);
    }

    //Fill out functionality
    /**
     * This removes a number of articles from the inventory
     * @param a Article
     * @param count How many articles are removed
     */
    public void removeArticle(Article a, int count){

    }

    /**
     * Finished - removes one article
     * @param p Article
     */
    public void removeArticle(Article a){
        this.removeArticle(p,1);
    }

    //Fill out functionality
    /**
     * This method sets the number of when an article is low in stock - perhaps it should be renamed
     * @param a Article
     * @param count Minimum number
     */
    public void SetStockAlertValue (Article a, int count){
    }

}
