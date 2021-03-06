package com.company;

/*  ************ OBSOLETE OBSOLETE OBSOLETE OBSOLETE OBSOLETE OBSOLETE **********
 * The functionality of this class has been moved to Article.
 *
 * This class specifies articles that are in use by hairdressers.
 * The amount of specific articles can be changed.
 */

public class ArticleInUse extends Article{
    private int amountUsedInMl;

    //Constructors
    public ArticleInUse(Article article, int amountUsedInMl) {
        this.brand = article.getBrand();
        this.category = article.getCategory();
        this.partNo = article.getPartNo();
        this.expirationDate = article.getExpirationDate();
        this.startAmountInMl = article.getContentInMl();
        this.amountUsedInMl = article.getAmountUsedInMl();
        this.amountLeftInMl = article.getAmountLeftInMl();
    }

    //Getters and setters

    public double getAmountLeftInMl() {
        return amountLeftInMl;
    }
}