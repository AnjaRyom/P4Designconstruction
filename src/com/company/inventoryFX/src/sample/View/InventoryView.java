package sample.View;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class InventoryView extends Scene {

    //Initialized layout of scene, with top, left, and center menu
    BorderPane layout = new BorderPane();
    CenterMenu centerMenu = new CenterMenu();
    LeftMenu leftMenu = new LeftMenu();
    TopMenu topMenu = new TopMenu();

    //Constructor of class, makes buttons and inserts them correctly

    public InventoryView (Parent root, double width, double height){
        super (root, width, height);

        layout.setCenter(centerMenu);
        layout.setLeft(leftMenu);
        layout.setTop(topMenu);

        super.setRoot(layout);

    }


}
