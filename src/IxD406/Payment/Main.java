package IxD406.Payment;

import IxD406.Payment.Controller.Controller;
import IxD406.Payment.View.PaymentView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public Controller controller;

    @Override
    public void start(Stage primaryStage) {


        //layout
        BorderPane paymentBorder = new BorderPane();
        Scene scene = new PaymentView(paymentBorder, 300, 250, this.controller);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setFullScreen(true);


    }
}
