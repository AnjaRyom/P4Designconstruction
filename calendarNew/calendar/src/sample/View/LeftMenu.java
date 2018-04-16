package sample.View;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import sample.Controller.Controller;

import java.io.File;

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

        File file = new File("/Users/gryegelundpetersen/desktop/kalender1.png");
        String localURL = file.toURI().toString();
        Image calendarIcon = new Image (localURL);
        calendar.setGraphic(new ImageView(calendarIcon));
        calendar.setStyle("-fx-font: 22 arial; -fx-base: #dbb6e7;");

        File file1 = new File("/Users/gryegelundpetersen/desktop/inventory1.png");
        String localURL1 = file1.toURI().toString();
        Image inventoryIcon = new Image (localURL1);
        inventory.setGraphic(new ImageView(inventoryIcon));
        inventory.setStyle("-fx-font: 22 arial; -fx-base: #dbb6e7;");

        File file2 = new File("/Users/gryegelundpetersen/desktop/cashout1.png");
        String localURL2 = file2.toURI().toString();
        Image cashOutIcon = new Image (localURL2);
        cashOut.setGraphic(new ImageView(cashOutIcon));
        cashOut.setStyle("-fx-font: 22 arial; -fx-base: #dbb6e7;");

        File file3 = new File("/Users/gryegelundpetersen/desktop/profiles1.png");
        String localURL3 = file3.toURI().toString();
        Image profilesIcon = new Image (localURL3);
        profiles.setGraphic(new ImageView(profilesIcon));
        profiles.setStyle("-fx-font: 22 arial; -fx-base: #dbb6e7;");


        calendar.setPrefSize(200,200);
        inventory.setPrefSize(200,200);
        cashOut.setPrefSize(200,200);
        profiles.setPrefSize(200,200);

        this.controller = controller;
        this.getChildren().addAll(calendar, inventory, cashOut, profiles);
        this.setMinWidth(200); //Sets min. width for leftmenu
        this.setMaxWidth(200);
    }

}
