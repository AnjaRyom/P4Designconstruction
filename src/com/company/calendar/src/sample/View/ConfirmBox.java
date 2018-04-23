package sample.View;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * <h1>ConfirmBox</h1>
 * This class describes a confirmbox
 */

public class ConfirmBox {

    static boolean answer;

    /**
     * This method displays the confirmbox
     * @param title String - the title of the window
     * @param message String - the message in a label
     * @return boolean - returns the answer
     */
    public static boolean display(String title, String message){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);

        //Label
        Label label = new Label();
        label.setText(message);

        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");

        //Reaction on button clicked
        yesButton.setOnAction(e-> {
            answer = true;
            window.close();
        });

        noButton.setOnAction(e-> {
            answer = false;
            window.close();
        });

        //Layout on pop up
        HBox layout = new HBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(label, yesButton, noButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return answer;
    }
}
