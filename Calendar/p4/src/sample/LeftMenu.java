package sample;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class LeftMenu extends VBox{

    Controller controller;

    Button calendar = new Button("Kalender");
    Button inventory = new Button("Lager");
    Button cashOut = new Button("Kasse");
    Button profiles = new Button("Profiler");

    public LeftMenu(Controller controller) {
        this.controller = controller;
        this.getChildren().addAll(calendar, inventory, cashOut, profiles);
        this.setMinWidth(200); //Sætter min. vidde for leftmenu
    }


}
