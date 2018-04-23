package sample.View;
import javafx.scene.control.Button;

public class InventoryAttributes {

    private String name;
    private int productNr;
    private double price;
    private int quantity;
    private Button orderButton;
    //private boolean ordered;


//Base value of the columns
    public InventoryAttributes() {
        this.name = "";
        this.productNr = 0;
        this.price = 0;
        this.quantity = 0;
        this.orderButton.setText("Bestil");
        //this.ordered = false;
    }

    public InventoryAttributes (String name, int productNr, double price, int quantity, Button orderButton){
        this.name = name;
        this.productNr = productNr;
        this.price = price;
        this.quantity = quantity;
        this.orderButton = orderButton;
        //this.ordered = ordered;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getProductNr() {
        return productNr;
    }
    public void setProductNr(int productNr) {
        this.productNr = productNr;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Button getOrderButton() {
        return orderButton;
    }
    public void setOrderButton(Button orderButton) {
        this.orderButton = orderButton;
    }

    /*
    public Boolean getOrdered() {
        return ordered;
    }
    public void setOrdered(Boolean ordered) {
        this.ordered = ordered;
    }
    */
}
