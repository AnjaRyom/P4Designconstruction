package IxD406.P4Designconstruction.src.IxD406.Profiles_med_fx;

import IxD406.P4Designconstruction.src.IxD406.Profiles_med_fx.View.ProfileView;
import IxD406.Profiles_med_fx.Model.Employee;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    public static List<Employee> employees = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) throws Exception{
        employees.add(new Employee("Tommy", "Hansen", "Something", 88888888, 123, "Mand", 200, 2, 5, "blabla", "jaja", 2, 0, true, true, "blue"));
        employees.add(new Employee("Simone", "Lindgaard", "Something", 88888888, 123, "Kvinde", 200, 2, 5, "blabla", "jaja", 2, 0, true, true, "blue"));
        employees.add(new Employee("Lise", "Harelund", "Something", 88888888, 123, "Kvinde", 200, 2, 5, "blabla", "jaja", 2, 0, true, true, "blue" ));
        employees.add(new Employee("Cecilie",  "Jensen", "Something", 88888888, 123, "Kvinde", 200, 2, 5, "blabla", "jaja", 2, 0, true, true, "blue"));

        //Here we set the title for the window screen

        primaryStage.setTitle("Profiles");

        //Here we make an instance of the profile view which is a BorderPane and shows it.

        Scene ProfileViewScene = new ProfileView(new BorderPane(),910,500);
        primaryStage.setScene(ProfileViewScene);
        primaryStage.show();




    }


    public static void main(String[] args) {
        launch(args);
    }
}
