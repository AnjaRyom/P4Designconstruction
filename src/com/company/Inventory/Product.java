package com.company;

//This class is a super-class for; Service, ArticleInUse and Article.
public abstract class Product{
    private String category;
    private String name;


    //Constructors
    public Product(String category, String name) {
        this.category = category;
        this.name = name;
    }

    //Getters
    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }
}



