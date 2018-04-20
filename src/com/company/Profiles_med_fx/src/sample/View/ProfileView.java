package sample.View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import sample.Model.Employee;

/* This class describes the Profileview which is a scene*/

public class ProfileView extends Scene{

// Initializing the layout of the scene and the top, left and center menu

    BorderPane layout = new BorderPane();
    CenterMenu centerMenu = new CenterMenu();
    LeftMenu leftMenu = new LeftMenu();
    TopMenu topMenu = new TopMenu();


// Constructer of class, which currently makes buttons and inserts them the right places

    public ProfileView(Parent root, double width, double height) {
        super(root, width, height);



// We're placing our menus on specific places in BorderPane

        layout.setCenter(centerMenu);
        layout.setLeft(leftMenu);
        layout.setTop(topMenu);


// We add buttons ect. to the layout (For adding more, use addAll instead of add)



// Since Profileview is a Scene, it is supposed to have an origin/root.
// Here we define the root, which can be seen earlier in the constructor input which is at that point empty.
        super.setRoot(layout);

        TabPane tabPane = new TabPane();
        Tab employeeTab = new Tab();
        Tab customerTab = new Tab();
        employeeTab.setText("Medarbejdere");
        customerTab.setText("Kunder");
        tabPane.getTabs().add(employeeTab);
        tabPane.getTabs().add(customerTab);
        tabPane.setTabMinWidth(330);
        tabPane.setPadding(new Insets(0,0,0,200));
        topMenu.getChildren().addAll(tabPane);


        GridPane employeegrid = new GridPane();
        Button xx = new Button("HEEEEEJ MEEED DIIIG");
        employeegrid.getChildren().addAll(xx);
        employeegrid.setStyle("-fx-background-color: #5433c4;");
        employeeTab.setContent(employeegrid);


        GridPane customergrid = new GridPane();
        Button yy = new Button("DETTE ER FOR NICE");
        customergrid.getChildren().addAll(yy);
        customergrid.setStyle("-fx-background-color: black;");
        customerTab.setContent(customergrid);



    }





}
