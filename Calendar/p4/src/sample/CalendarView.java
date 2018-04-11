package sample;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class CalendarView extends Scene{

    Controller controller;

    private double width;
    private double height;
    private BorderPane border = new BorderPane();
    LeftMenu leftMenu;
    TopMenu topMenu;
    CenterMenu centerMenu;


    public CalendarView(Parent root, double width, double height,Controller controller) {
        super(root,width,height);
        this.controller = controller;
        this.width = width;
        this.height = height;

        this.leftMenu = new LeftMenu(this.controller);
        this.topMenu = new TopMenu(this.controller);
        this.centerMenu = new CenterMenu(this.controller);

        topMenu.setStyle("-fx-background-color: lightblue;");
        centerMenu.setStyle("-fx-background-color: lightgrey;");
        leftMenu.setStyle("-fx-background-color: grey;");

        border.setLeft(leftMenu);
        border.setTop(topMenu);
        border.setCenter(centerMenu);

        super.setRoot(border);

    }

    public LeftMenu getLeftMenu() {
        return leftMenu;
    }

    public TopMenu getTopMenu() {
        return topMenu;
    }

    public CenterMenu getCenterMenu() {
        return centerMenu;
    }

}
