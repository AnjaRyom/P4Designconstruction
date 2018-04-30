package IxD406.Payment.View;

import IxD406.Payment.Controller.Controller;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class AddView {
    VBox addBox;

    public AddView(Controller controller) {
        this.addBox = new VBox();

        final ImageView serviceIcon = new ImageView(new Image("/IxD406/Payment/Assets/service_logo.png"));
        final ImageView productIcon = new ImageView(new Image("/IxD406/Payment/Assets/product_logo.png"));

        //Service button
        Button serviceButton = new Button("Behandlinger", serviceIcon);
        serviceButton.setStyle("" +
                "    -fx-background-insets: 0,1,2;" +
                "    -fx-font-family: \"Arial\";" +
                "    -fx-font-size: 40px;" +
                "    -fx-font-weight: bold;" +
                "    -fx-text-fill: grey;" +
                "    -fx-padding: 50 100 50 100;" +
                "    -fx-pref-width: 500px;" +
                "    -fx-background-radius: 25;"
        );

        //Product button
        Button productButton = new Button("Produkter", productIcon);
        productButton.setStyle(" \n" +
                "    -fx-background-insets: 0,1,2;\n" +
                "    -fx-font-family: \"Arial\";\n" +
                "    -fx-font-size: 40px;\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-text-fill: grey;\n" +
                "    -fx-padding: 50 100 50 100;\n" +
                "    -fx-pref-width: 500px;" +
                "    -fx-background-radius: 25");

        addBox.setSpacing(50);
        addBox.setAlignment(Pos.CENTER);

        addBox.getChildren().addAll(serviceButton, productButton);

    }
}

