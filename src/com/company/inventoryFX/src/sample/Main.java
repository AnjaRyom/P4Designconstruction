package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import sample.View.InventoryView;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        //Screen title
        primaryStage.setTitle("Inventory");

        //Instance of inventory view - border pane
        Scene InventoryViewScene = new InventoryView(new BorderPane(), 1600, 800);
        primaryStage.setScene(InventoryViewScene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
