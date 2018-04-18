package sample.View;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import sample.Controller.Controller;


import java.beans.PropertyChangeEvent;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.List;

/*
 * This class describes the topmenu for the inventory view
 * The menu is a gridpane and extends from GridPane
 * The topmenu consist of....
 */

public class TopMenu extends GridPane{

    Controller controller;

    //constructor for the topmenu
    public TopMenu(Controller controller){
        this.controller = controller;


        //The buttons/names representing the different categories in the inventory
        Button produkt = new Button("Produkt");
        GridPane.setConstraints(produkt, 10, 0);
        Button produktNr = new Button("Produkt No.");
        GridPane.setConstraints(produktNr, 12, 0);
        Button påLager = new Button("På lager");
        GridPane.setConstraints(påLager, 14, 0);
        Button varePrisPrStk = new Button("Varepris pr stk");
        GridPane.setConstraints(varePrisPrStk, 16, 0);
        Button bestil = new Button("Bestil");
        GridPane.setConstraints(bestil, 18, 0);


    }


}