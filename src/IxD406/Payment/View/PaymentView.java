package IxD406.Payment.View;

import IxD406.calendar.View.LeftMenu;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import IxD406.calendar.View.LeftMenu;

public class PaymentView extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        //layout
        BorderPane paymentBorder = new BorderPane();
        HBox upperHBox = new HBox();
        HBox lowerHBox = new HBox();
        VBox centerVBox = new VBox();
        VBox rightVBox = new VBox();
        LeftMenu paymentLeft = new LeftMenu(this.controller);

        paymentBorder.setLeft(paymentLeft);
        paymentBorder.setCenter(centerVBox);
        paymentBorder.setRight(rightVBox);

        Scene scene = new Scene(paymentBorder, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();

        //centerVBox
        Button serviceButton = new Button("Services");
        upperHBox.getChildren().add(serviceButton);

        Button productButton = new Button("Produkter");
        lowerHBox.getChildren().add(productButton);



    }
}
