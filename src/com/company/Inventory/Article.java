package com.company;


/* The Article class contains info about the single product
 * it can be edited by using the constructor but only location
 * and retailPrice can be edited when it already exist (by setters).
 */

public class Article extends Product {
    private int contentInMl;
    private int usedMl;
    private String brand; //field.
    private String partNo;
    private Location location;
    private int purchasePrice; //This field is an int, because we calculate it in cents.
    private int retailPrice;
    private Date expirationDate; //Date is a type for representing dates.

    //Constructor
    public Article(int contentInMl,
                   String brand,
                   String category,
                   String name,
                   String partNo,
                   int location,
                   int purchasePrice,
                   int retailPrice,
                   Date expirationDate) {
        super(category, name); //Call the constructor of this super-class.
        this.brand = brand;
        this.partNo = partNo;
        this.location = location;
        this.purchasePrice = purchasePrice;
        this.retailPrice = retailPrice;
        this.expirationDate = expirationDate;
        this.usedMl = 0;
    }

    //Getters
    public int getContentInMl() {return contentInMl; }

    public String getBrand() {
        return brand;
    }

    public String getPartNo() {
        return partNo;
    }

    public int getLocation() {
        return location;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public int getRetailPrice() {
        return retailPrice;
    }

    public Date getExpirationDate() { return expirationDate; }

    //Setters - those without setter cannot be edited by other than the object itself

    /**
     * Change or set article location
     * @param location New article location
     */
    public void setLocation(int location) {
        this.location = location;
    }

    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }

    /**
     * Check if product has expired.
     * @param currentDate
     * @return if the product has expired "true", otherwise "false".
     */
    public boolean isExpired(Date currentDate) {
        return currentDate > this.expirationDate;
    }

    public boolean isInUse() {
        return this.usedMl != 0;
    }

    /**
     * Check how much left in ml.
     * @return the amount left in ml.
     */
    public int amountLeftInMl() {
        return this.contentInMl-this.usedMl;
    }

    /**
     * Check if enough left for a service.
     * @param service
     * @return There is enough left for the service.
     */
    public boolean enoughLeftFor(Service service) {
        Map<String, int> products = service.getRequiredProducts();
        int requiredAmount =  products.get(this.getName());
        return requiredAmount <= this.amountLeftInMl();
    }

    /**
     * Product usage in ml. Checks if there is enough left in the bottle and if not, it calculates how much more is left.
     * @param ml
     */
    public int use(int ml){

        if (amountLeftInMl() < ml){
            this.usedMl += amountLeftInMl();
            return ml - amountLeftInMl();
        }

        this.usedMl += ml;
        return 0;
    }



}



