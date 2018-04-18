package sample.View;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import sample.Controller.Controller;

/*
 * This class describes the leftmenu for the whole application
 * The menu is a VBox and extends from VBox
 * The leftmenu consist of four buttons
 */

public class LeftMenu extends VBox{

    Controller controller;

    Button calendar = new Button("Kalender");
    Button inventory = new Button("Lager");
    Button cashOut = new Button("Kasse");
    Button profiles = new Button("Profiler");

    //Constructor for leftmenu
    public LeftMenu(Controller controller) {
        this.controller = controller;
        this.getChildren().addAll(calendar, inventory, cashOut, profiles);
        this.setMinWidth(200); //Sets min. width for leftmenu
        this.setMaxWidth(200);
    }


}
