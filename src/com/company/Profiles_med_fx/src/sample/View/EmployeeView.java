package sample.View;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

public class EmployeeView extends ProfileView {

    public EmployeeView(Parent root, double width, double height) {
        super(root, width, height);
    }

    public static void display() {
        Stage employeeDetails = new Stage();

        employeeDetails.initModality(Modality.APPLICATION_MODAL);
        employeeDetails.setTitle("This is a pop up window");
        employeeDetails.setMinWidth(250);

        GridPane layout = new GridPane();
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll();


        Scene scene = new Scene(layout);
        employeeDetails.setScene(scene);
        employeeDetails.show();
    }
}
