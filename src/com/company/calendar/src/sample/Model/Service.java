package sample.Model;

//Denne kommer fra inventory gruppen så derfor ingen konkrete kommentarer


import java.util.ArrayList;
import java.util.List;

public class Service {
    String nameOfService;
    int price;

    public Service(String nameOfService, int price) {
        this.nameOfService = nameOfService;
        this.price = price;
    }

    public String getNameOfService() {
        return nameOfService;
    }

    public void setNameOfService(String nameOfService) {
        this.nameOfService = nameOfService;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String toString(){
        return this.nameOfService;

    }
}
