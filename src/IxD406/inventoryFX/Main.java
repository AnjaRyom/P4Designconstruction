package IxD406.inventoryFX;

import IxD406.inventoryFX.View.InventoryView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

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
