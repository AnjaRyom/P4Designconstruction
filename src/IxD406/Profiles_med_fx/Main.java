package IxD406.Profiles_med_fx;

import IxD406.Profiles_med_fx.Model.Customer;
import IxD406.Profiles_med_fx.Model.Employee;
import IxD406.Profiles_med_fx.View.ProfileView;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    public static List<Employee> employees = new ArrayList<>();
    public static ObservableList<Customer> customers = FXCollections.observableArrayList();


    @Override
    public void start(Stage primaryStage) throws Exception{


        //HERE ARE EMPLOYEES
        employees.add(new Employee("Tommy", "Hansen", "Something", 88888888, 123, "Mand", 200, 2, 5, "blabla", "jaja", 2, 0, true, true, "blue"));
        employees.add(new Employee("Simone", "Lindgaard", "Something", 88888888, 123, "Kvinde", 200, 2, 5, "blabla", "jaja", 2, 0, true, true, "blue"));
        employees.add(new Employee("Lise", "Harelund", "Something", 88888888, 123, "Kvinde", 200, 2, 5, "blabla", "jaja", 2, 0, true, true, "blue" ));
        employees.add(new Employee("Cecilie",  "Jensen", "Something", 88888888, 123, "Kvinde", 200, 2, 5, "blabla", "jaja", 2, 0, true, true, "blue"));

        //HERE ARE CUSTOMERS
        customers.add(new Customer("Bob", "Bobsen",
                "Jomfru ane gade", 90201010, 10, "Mand",
                "Tykt", "Brun", "kort", "6",
                4, "none"));

        customers.add(new Customer("Børge", "Børgesen", "Vesterå",
                90101010, 10, "Mand", "Tykt",
                "Brun", "kort", "0", 4, "none"));



        //Here we set the title for the window screen
        primaryStage.setTitle("Profiles");
        //Here we make an instance of the profile view which is a BorderPane and shows it.

        Scene ProfileViewScene = new ProfileView(new BorderPane(),910,500);
        primaryStage.setScene(ProfileViewScene);
        ProfileViewScene.getStylesheets().add("IxD406/Profiles_med_fx/StyleCSS.css");
        primaryStage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }

}

