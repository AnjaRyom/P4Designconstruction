package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import sample.Controller.Controller;
import sample.View.ConfirmBox;
import sample.View.InventoryView;


public class Main extends Application {

    Stage window;


    public static void main(String[] args) {
        launch(args);
    }


    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("Hairdresser");
        Controller controller = new Controller();
        Scene inventoryViewScene = new InventoryView(new BorderPane(),1920,1080, controller);
        controller.setCurrentScene(inventoryViewScene);

        window.setScene(inventoryViewScene);
        window.show();
    }



    //How to react on close
    private void closeProgram(){
        boolean answer = ConfirmBox.display("Title", "Sure you want to exit?");
        if(answer==true){
            window.close();
        }
    }
}
