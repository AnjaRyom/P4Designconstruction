package sample.View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import sample.Controller.Controller;


import java.util.ArrayList;
import java.util.List;


/*
 * This class describes the centermenu for inventory view
 * The menu is gridpane extends from GridPane
 * ...Not sure why this one is abstract, I stole this code from Gry/Jess
 */

public abstract class CenterMenu extends GridPane {

    Controller controller;

    public CenterMenu(Controller controller) {
        this.controller=controller;



    }


}
