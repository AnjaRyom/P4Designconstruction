package sample.View;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import sample.Controller.Controller;


/*
 * This class describes the inventory view
 * It extends from the scene class of javafx,
 * since it is considered as entire scene itself
 * It consist of leftmenu, topmenu and centermenu
 * The calendar view is a borderpane
 */

public class InventoryView extends Scene {

    Controller controller;

    private double width;
    private double height;

    private BorderPane border =  new BorderPane();
    LeftMenu leftMenu;
    TopMenu topMenu;
    CenterMenu centerMenu; //Not sure if this is needed, or why

    public InventoryView (Parent root, double width, double height, Controller controller) {
        super(root,width,height);
        this.controller = controller;
        this.width = width;
        this.height = height;

        this.leftMenu = new LeftMenu(this.controller);
        this.topMenu = new TopMenu(this.controller);


        topMenu.setStyle("-fx-background-color: lightblue;");
        centerMenu.setStyle("-fx-background-color: lightgrey;");
        leftMenu.setStyle("-fx-background-color: grey;");
        border.setLeft(leftMenu);
        border.setTop(topMenu);
        border.setCenter(centerMenu);

        super.setRoot(border);

    }


    //Getters for inventory view
    public  LeftMenu getLeftMenu() {return leftMenu;}
    public TopMenu getTopMenu() {
        return topMenu;
    }

    public CenterMenu getCenterMenu() {
        return centerMenu;
    }

    public void setCenterMenu(CenterMenu centerMenu) {
        this.centerMenu = centerMenu;
        border.setCenter(centerMenu);


    }

    public BorderPane getBorder() {
        return border;
    }

}
