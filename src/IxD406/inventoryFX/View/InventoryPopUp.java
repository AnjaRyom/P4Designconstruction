package IxD406.inventoryFX.View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.*;
import javafx.stage.*;


public class InventoryPopUp extends GridPane {

    public static void display(String name, int productNr, double price, int quantity, Button orderButton) {
        GridPane gridPane = new GridPane();

        /**
         * The window should be its own, and you should not be able to close it before you have saved your actions
         */
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(name);

        /**
         * Here the paddings are made.
         */
        gridPane.setPadding(new Insets(10,20,20,20));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        /**
         * Here the heading is made.
         */
        Label heading = new Label("Nr. 2015 - Funkpunk Haircolor Blue");
        heading.setStyle("-fx-font: 16 arial;");
        heading.setPadding(new Insets(10, 10, 10, 0));
        heading.setAlignment(Pos.TOP_LEFT);

        /**
         * The articles in stock.
         */
        Label stock = new Label("På lager");
        Label inStock = new Label("1");

        HBox articleInStock = new HBox();
        articleInStock.getChildren().addAll(stock, inStock);
        articleInStock.setSpacing(220);

        /**
         * Automatic ordering (Yes/No) buttons.
         */
        Label automaticOrdering = new Label("Automatisk bestilling");

        RadioButton rbYes = new RadioButton();
        RadioButton rbNo = new RadioButton();

        HBox automatic = new HBox();
        automatic.getChildren().addAll(rbYes, rbNo);
        automatic.setSpacing(25);
        automatic.setPadding(new Insets(0, 0, 0, 8));

        Label buttonYes = new Label("Ja");
        Label buttonNo = new Label("Nej");

        HBox YesNo = new HBox();
        YesNo.getChildren().addAll(buttonYes, buttonNo);
        YesNo.setSpacing(37);
        YesNo.setStyle("-fx-font: 8 arial;");
        YesNo.setPadding(new Insets(0, 0, 0, 11));

        /**
         * Minimum in stock.
         */
        Label minimumInStock = new Label("Minimumslager");
        TextField textbox = new TextField();
        textbox.setPrefSize(40, 8);

        HBox minStock = new HBox();
        minStock.getChildren().addAll(minimumInStock, textbox);
        minStock.setSpacing(165);

        /**
         * Refill number in stock.
         */
        Label refillNumber = new Label("Genfyldningsantal");
        TextField textbox1 = new TextField();
        textbox1.setPrefSize(40, 8);

        HBox refill = new HBox();
        refill.getChildren().addAll(refillNumber, textbox1);
        refill.setSpacing(152);

        /**
         * Purchase- and retail price.
         */
        Label purchasePrice = new Label("Indkøbspris");
        Label priceDkk = new Label("3000 dkk");

        HBox purPrice = new HBox();
        purPrice.getChildren().addAll(purchasePrice, priceDkk);
        purPrice.setSpacing(180);

        Label retailPrice = new Label("Udsalgspris");
        Label Dkk = new Label("2000 dkk");

        HBox retPrice = new HBox();
        retPrice.getChildren().addAll(retailPrice, Dkk);
        retPrice.setSpacing(181);

        /**
         * The saving (Gem) button.
         * The doesn't actually save anything yet, it just closes the window
         */
        Button saveButton = new Button("Gem");
        saveButton.setPrefWidth(80);
        saveButton.setPrefHeight(35);
        saveButton.setOnAction(e -> window.close());

        HBox button = new HBox();
        button.setPadding(new Insets(20, 10, 5, 10));
        button.setAlignment(Pos.CENTER);

        /**
         * This method creates columns and rows for the content.
         */
        GridPane.setConstraints(heading, 0, 0);
        GridPane.setConstraints(articleInStock, 0, 1);
        GridPane.setConstraints(automaticOrdering, 0, 2);
        GridPane.setConstraints(automatic, 0, 3);
        GridPane.setConstraints(YesNo, 0, 4);
        GridPane.setConstraints(minStock, 0, 5);
        GridPane.setConstraints(refill, 0, 6);
        GridPane.setConstraints(purPrice, 0, 7);
        GridPane.setConstraints(retPrice, 0, 8);
        GridPane.setConstraints(button, 0, 9);

        /**
         * This method calls the button and HBoxes made in regarding stock.
         */
        gridPane.getChildren().addAll(heading, articleInStock, automaticOrdering, minStock, refill, purPrice, retPrice, button, automatic, YesNo);
        button.getChildren().addAll(saveButton);

        Scene scene = new Scene(gridPane);
        window.setScene(scene);
        window.showAndWait();

    }

}
