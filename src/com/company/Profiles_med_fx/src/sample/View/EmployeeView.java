package sample.View;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class EmployeeView extends ProfileView {

// Initializing the layout of the scene and the top, left and center menu

        BorderPane layout = new BorderPane();
        CenterMenu centerMenu = new CenterMenu();
        LeftMenu leftMenu = new LeftMenu();
        TopMenu topMenu = new TopMenu();

    public EmployeeView(Parent root, double width, double height) {
        super(root, width, height);


    }
}
