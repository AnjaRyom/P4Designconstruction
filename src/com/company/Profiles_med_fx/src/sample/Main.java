package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import sample.View.ProfileView;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        //Here we set the title for the window screen

        primaryStage.setTitle("Profiles");


        //Here we make an instance of the profile view which is a BorderPane and shows it.

        Scene ProfileViewScene = new ProfileView(new BorderPane(),500,500);
        primaryStage.setScene(ProfileViewScene);
        primaryStage.show();



    }


    public static void main(String[] args) {
        launch(args);
    }
}
