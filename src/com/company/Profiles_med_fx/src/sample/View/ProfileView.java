package sample.View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Window;
import sample.Model.Employee;
import sample.Main;

import java.util.ArrayList;
import java.util.List;

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
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        employeeTab.setText("Medarbejdere");
        employeeTab.setStyle("-fx-font: 15 arial");
        customerTab.setText("Kunder");
        customerTab.setStyle("-fx-font: 15 arial-");
        tabPane.getTabs().add(employeeTab);
        tabPane.getTabs().add(customerTab);
        tabPane.setTabMinWidth(330);
        tabPane.setPadding(new Insets(0,0,0,0));
        centerMenu.getChildren().addAll(tabPane);


        GridPane employeegrid = new GridPane();
        Button xx = new Button("HEEEEEJ MEEED DIIIG");
        // employeegrid.setStyle("-fx-background-color: #EFEFEF;");
        employeeTab.setContent(employeegrid);
        VBox employeeOne = new VBox();

        VBox employeeTwo = new VBox();
        VBox employeeThree = new VBox();
        VBox employeeFour = new VBox();
        VBox paddingBox = new VBox();


        paddingBox.setPrefSize(1,60);
        employeeOne.setPrefSize(150,200);
        employeeTwo.setPrefSize(150,200);
        employeeThree.setPrefSize(150,200);
        employeeFour.setPrefSize(150,200);

        GridPane.setConstraints(paddingBox, 0,1);
        GridPane.setConstraints(employeeOne, 2, 2);
        GridPane.setConstraints(employeeTwo, 3, 2);
        GridPane.setConstraints(employeeThree, 4, 2);
        GridPane.setConstraints(employeeFour, 5, 2);

        employeegrid.setHgap(20);
        employeegrid.setPadding(new Insets(60));

        Button ebOne = new Button("Detaljer");
        ebOne.setStyle("-fx-base: #9A6262;");
        ebOne.setTextFill(Color.web("#ffffff"));

        Button ebTwo = new Button("Detaljer");
        ebTwo.setStyle("-fx-base: #9A6262;");
        ebTwo.setTextFill(Color.web("#ffffff"));

        Button ebThree = new Button("Detaljer");
        ebThree.setStyle("-fx-base: #9A6262;");
        ebThree.setTextFill(Color.web("#ffffff"));

        Button ebFour = new Button("Detaljer");
        ebFour.setStyle("-fx-base: #9A6262;");
        ebFour.setTextFill(Color.web("#ffffff"));

        employeeOne.setAlignment(Pos.BOTTOM_CENTER);
        employeeTwo.setAlignment(Pos.BOTTOM_CENTER);
        employeeThree.setAlignment(Pos.BOTTOM_CENTER);
        employeeFour.setAlignment(Pos.BOTTOM_CENTER);



        employeeOne.getChildren().add(ebOne);
        employeeTwo.getChildren().add(ebTwo);
        employeeThree.getChildren().add(ebThree);
        employeeFour.getChildren().add(ebFour);

        employeeOne.setStyle("-fx-background-color: #D1D1D1;");
        employeeTwo.setStyle("-fx-background-color: #D1D1D1;");
        employeeThree.setStyle("-fx-background-color: #D1D1D1;");
        employeeFour.setStyle("-fx-background-color: #D1D1D1;");
        paddingBox.setStyle("-fx-background-color: pink;");
        employeegrid.getChildren().addAll(employeeOne, employeeTwo, employeeThree, employeeFour, paddingBox);

        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(5);
        dropShadow.setColor(Color.GREY);
        employeeOne.setEffect(dropShadow);
        employeeTwo.setEffect(dropShadow);
        employeeThree.setEffect(dropShadow);
        employeeFour.setEffect(dropShadow);

        Label firstName = new Label();
        String firstNameOfEmployee = Main.employees.get(0).getFirstName();
        firstName.setText(firstNameOfEmployee);
        System.out.println(firstName);

        employeeOne.getChildren().addAll(firstName);
        



        GridPane customergrid = new GridPane();
        Button yy = new Button("DETTE ER FOR NICE");
        customergrid.getChildren().addAll(yy);
        customergrid.setStyle("-fx-background-color: black;");
        customerTab.setContent(customergrid);





    }





}
