package IxD406.Profiles_med_fx.View;

import IxD406.Profiles_med_fx.Model.Customer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import IxD406.Profiles_med_fx.Main;

import javax.swing.*;
import java.io.File;

/* This class describes the Profileview which is a scene*/

public class ProfileView extends Scene{

// Initializing the layout of the scene and the top, left and center menu

    BorderPane layout = new BorderPane();
    IxD406.Profiles_med_fx.View.CenterMenu centerMenu = new IxD406.Profiles_med_fx.View.CenterMenu();
    IxD406.Profiles_med_fx.View.LeftMenu leftMenu = new IxD406.Profiles_med_fx.View.LeftMenu();
    IxD406.Profiles_med_fx.View.TopMenu topMenu = new IxD406.Profiles_med_fx.View.TopMenu();


// Constructer of class, which currently makes buttons and inserts them the right places

    public ProfileView(Parent root, double width, double height) {
        super(root, width, height);



// We're placing our menus on specific places in BorderPane

        layout.setCenter(centerMenu);
        layout.setLeft(leftMenu);
        layout.setTop(topMenu);


// We add buttons ect. to the layout (For adding more, use addAll instead of add)



/** Since Profileview is a Scene, it is supposed to have an origin/root.
 Here we define the root, which can be seen earlier in the constructor input which is at that point empty.

 We also define the TabPane Layout with two different buttons containing different setups.
 **/
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

/** Here we define the Employee setup and elements such as grids, boxes and buttons*/

//Gridpane

        GridPane employeeGrid = new GridPane();
        employeeTab.setContent(employeeGrid);

//VBoxes containing 4 different hairdressers and 1 paddingbox
        VBox employeeOne = new VBox();
        VBox employeeTwo = new VBox();
        VBox employeeThree = new VBox();
        VBox employeeFour = new VBox();
        VBox paddingBox = new VBox();


        paddingBox.setPrefSize(0,60);
        employeeOne.setPrefSize(150,200);
        employeeTwo.setPrefSize(150,200);
        employeeThree.setPrefSize(150,200);
        employeeFour.setPrefSize(150,200);

        GridPane.setConstraints(paddingBox, 0,1);
        GridPane.setConstraints(employeeOne, 2, 2);
        GridPane.setConstraints(employeeTwo, 3, 2);
        GridPane.setConstraints(employeeThree, 4, 2);
        GridPane.setConstraints(employeeFour, 5, 2);

        employeeGrid.setHgap(20);
        employeeGrid.setPadding(new Insets(60));

        employeeOne.setStyle("-fx-background-color: #D1D1D1;");
        employeeTwo.setStyle("-fx-background-color: #D1D1D1;");
        employeeThree.setStyle("-fx-background-color: #D1D1D1;");
        employeeFour.setStyle("-fx-background-color: #D1D1D1;");
        paddingBox.setStyle("-fx-background-color: pink;");

        employeeGrid.getChildren().addAll(employeeOne, employeeTwo, employeeThree, employeeFour, paddingBox);

        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(5);
        dropShadow.setColor(Color.GREY);
        employeeOne.setEffect(dropShadow);
        employeeTwo.setEffect(dropShadow);
        employeeThree.setEffect(dropShadow);
        employeeFour.setEffect(dropShadow);


// BUTTONS

        Button ebOne = new Button("Detaljer");
        ebOne.setStyle("-fx-base: #9A6262;");
        ebOne.setTextFill(Color.web("#ffffff"));
        ebOne.setOnAction(e ->{
            EmployeeView.display();
        });

        Button ebTwo = new Button("Detaljer");
        ebTwo.setStyle("-fx-base: #9A6262;");
        ebTwo.setTextFill(Color.web("#ffffff"));
        ebTwo.setOnAction(e ->{
            IxD406.Profiles_med_fx.View.EmployeeViewOne.displayOne();

        });

        Button ebThree = new Button("Detaljer");
        ebThree.setStyle("-fx-base: #9A6262;");
        ebThree.setTextFill(Color.web("#ffffff"));
        ebThree.setOnAction(e ->{
            IxD406.Profiles_med_fx.View.EmployeeViewTwo.displayTwo();
        });

        Button ebFour = new Button("Detaljer");
        ebFour.setStyle("-fx-base: #9A6262;");
        ebFour.setTextFill(Color.web("#ffffff"));
        ebFour.setOnAction(e ->{
            IxD406.Profiles_med_fx.View.EmployeeViewThree.displayThree();
        });

        employeeOne.setAlignment(Pos.BOTTOM_CENTER);
        employeeTwo.setAlignment(Pos.BOTTOM_CENTER);
        employeeThree.setAlignment(Pos.BOTTOM_CENTER);
        employeeFour.setAlignment(Pos.BOTTOM_CENTER);

// Labels which indicates first and lastname on first hairdresser
        Label firstNameOne = new Label();
        String firstNameOfEmployee = Main.employees.get(0).getFirstName();
        firstNameOne.setText(firstNameOfEmployee);
        firstNameOne.setStyle("-fx-font: 17 arial");

        Label lastNameOne = new Label();
        String lastNameOfEmployee = Main.employees.get(0).getLastName();
        lastNameOne.setText(lastNameOfEmployee);

// Second hairdresser labels
        Label firstNameTwo = new Label();
        String firstNameOfEmployeeTwo = Main.employees.get(1).getFirstName();
        firstNameTwo.setText(firstNameOfEmployeeTwo);
        firstNameTwo.setStyle("-fx-font: 17 arial");

        Label lastNameTwo = new Label();
        String lastNameOfEmployeeTwo = Main.employees.get(1).getLastName();
        lastNameTwo.setText(lastNameOfEmployeeTwo);

// Third hairdresser labels
        Label firstNameThree = new Label();
        String firstNameOfEmployeeThree = Main.employees.get(2).getFirstName();
        firstNameThree.setText(firstNameOfEmployeeThree);
        firstNameThree.setStyle("-fx-font: 17 arial");

        Label lastNameThree = new Label();
        String lastNameOfEmployeeThree = Main.employees.get(2).getLastName();
        lastNameThree.setText(lastNameOfEmployeeThree);

// Fourth hairdresser labels
        Label firstNameFour = new Label();
        String firstNameOfEmployeeFour = Main.employees.get(3).getFirstName();
        firstNameFour.setText(firstNameOfEmployeeFour);
        firstNameFour.setStyle("-fx-font: 17 arial");

        Label lastNameFour = new Label();
        String lastNameOfEmployeeFour = Main.employees.get(3).getLastName();
        lastNameFour.setText(lastNameOfEmployeeFour);

/** Elements are inserted in the different VBox'es containing Hairdressers.
 * First name, last name, pictures and a personal detail button*/


        employeeOne.getChildren().addAll(firstNameOne, lastNameOne, CreateVBoxWithImage("C:\\Users\\Anja\\Desktop\\Billeder\\Tommy.png"), ebOne);
        employeeTwo.getChildren().addAll(firstNameTwo, lastNameTwo, CreateVBoxWithImage("C:\\Users\\Anja\\Desktop\\Billeder\\Simone.png"), ebTwo);
        employeeThree.getChildren().addAll(firstNameThree, lastNameThree, CreateVBoxWithImage("C:\\Users\\Anja\\Desktop\\Billeder\\Lise.png"), ebThree);
        employeeFour.getChildren().addAll(firstNameFour, lastNameFour, CreateVBoxWithImage("C:\\Users\\Anja\\Desktop\\Billeder\\Cecilie.png"), ebFour);



/** Gridpane containing Customer setup, tableView and elements */


        GridPane customerGrid = new GridPane();
        customerGrid.setVgap(5);

        Button addCustomerButton = new Button("+ Tilføj kunde");
        addCustomerButton.setStyle("-fx-base: #9CBC92;");
        addCustomerButton.setTextFill(Color.web("#ffffff"));


        TableView<Customer> table = new TableView<>();

        //Her oprettes de colums vi ønsker med en hvis størrelse
        TableColumn firstNameCol = new TableColumn("Navn");
        firstNameCol.setPrefWidth(290);


        TableColumn numberCol = new TableColumn("Nummer");
        numberCol.setPrefWidth(100);
        numberCol.setStyle("-fx-alignment: CENTER");

        TableColumn lastNameCol = new TableColumn("Efternavn");
        lastNameCol.setPrefWidth(290);


        //Denne kan kende forskel på firstname og age osv hvis de kaldes det, de gør i customer
        // så i customer er der pt firstName og age, og da jeg skriver dette heri præcis som det står deler den selv op i kolonnerne
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<>("firstName")
        );
        numberCol.setCellValueFactory(
                new PropertyValueFactory<>("phoneNumber")
        );
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        //Her indsættes hvilken liste selve tableview skal bruge (den liste vi har af customers)
        table.setItems(IxD406.Profiles_med_fx.Main.data);

        //her tilføjes de 2 kolonner
        table.getColumns().addAll(firstNameCol, lastNameCol, numberCol);


        GridPane.setConstraints(addCustomerButton, 0, 0);
        GridPane.setConstraints(table, 0, 2);


        customerGrid.setPadding(new Insets(10));
        customerGrid.getChildren().addAll(addCustomerButton, table);
        customerTab.setContent(customerGrid);


    }



    public static VBox CreateVBoxWithImage(String pathname){

        VBox vboxForImage = new VBox();
        File file = new File(pathname);
        String localURL = file.toURI().toString();

        Image image = new Image(localURL);
        ImageView imageView = new ImageView(image);

        vboxForImage.getChildren().add(imageView);

        return vboxForImage;


    }



}
