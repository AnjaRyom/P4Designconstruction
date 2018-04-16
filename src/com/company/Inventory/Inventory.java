package com.company;
import java.util.Dictionary;

/** Inventory aggregates the class article and keeps track of the inventory.
 * It tells whether the stock is low.
 * if the stock is too low, it tells if the article has been ordered or not.
 * This class DOES NOT order new parts. */

public class Inventory {

    private List<Article> stock; // this represents a list of a certain article in stock
    /* Map is a type that takes key, K and value, V as parameters.
     * In this case the key is the article (which is both a type and a class we created ourselves),
     * and the value is the number of articles in stock. */
    private Map<String, int> lowStock; // this represents the case where the stock is too low
    private List<LowStockListener> lowStockListenerList;

    // This is the start if there is already an existing stock.
    public Inventory(Map<Article, int> numberInStock, Map<Article, int> lowStock) {
        this.numberInStock = numberInStock;
        this.lowStock = lowStock;
        this.lowStockListenerList = new ArrayList();
    }

    // If there is no existing stock, this is the start and the first map will be created.
    public Inventory() {
        this.lowStock = new HashMap();
        this.stock = new ArrayList();
        this.lowStockListenerList = new ArrayList();
    }

    /**
     * Adds an instance of an article to the stock
     * @param a Article
     */
    public void add(Article a){
        this.stock.add(a);
    }

    /**
     * List that implements the interface LowStockListener (add)
     * @param l
     */
    public void addLowStockListener(LowStockListener l){
        this.lowStockListenerList.add(a);
    }
    /**
     * Finished - removes one article.
     * Each class that implements the interface: LowStockListener
     * can be noticed (if registered) when the stock of one Article is too low -
     * this function will be called on this object if this is the case.
     * @param p Article
     */
    public void remove(Article a){
        this.stock.remove(a);
        int count = this.articleCount(a.getName());
        if (this.lowStock.get(a.getName) >= count)
            for (LowStockListener l : this.lowStockListenerList)
                l.lowStock (a.getName(), count);
    }

    /**
     * List that implements the interface LowStockListener (remove)
     * @param l
     */
    public void removeLowStockListener(LowStockListener l){
        this.lowStockListenerList.remove(a);
    }

    /**
     * This method sets the number of when an article is low in stock - perhaps it should be renamed
     * @param a Article
     * @param count Minimum number
     */
    public void SetStockAlertValue (String articleName , int count){
        lowStock.put(articleName, count);
    }

    /**
     * Clears the stock alert value for a product that has already such a value
     * @param a Article
     */
    public void clearStockAlertValue (String articleName){
        lowStock.removve(articleName);

    }

    /**
     * Return a list of expired articles.
     * @return
     */
    public List<Article> expiredArticles (Date currentDate){
        List<Article> expired = new ArrayList<Article>();
        for (Article item : this.stock) {
            if (item.isExpired(currentDate))
                expired.add(item);

        }
        return expired;
    }
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

