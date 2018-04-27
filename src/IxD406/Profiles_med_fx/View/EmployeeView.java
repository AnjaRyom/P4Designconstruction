package IxD406.Profiles_med_fx.View;

import IxD406.Profiles_med_fx.Main;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class EmployeeView extends ProfileView {

    public EmployeeView(Parent root, double width, double height) {
        super(root, width, height);
    }

    public static void display(VBox vBox) {
        Stage employeeDetails = new Stage();

        employeeDetails.initModality(Modality.APPLICATION_MODAL);
        employeeDetails.setTitle("This is a pop up window");
        employeeDetails.setMinWidth(250);

        GridPane layout = new GridPane();
        layout.setPadding(new Insets(250));
        layout.getChildren().addAll();

        Label firstname = new Label();
        String firstnameOfEmployee = Main.employees.get(0).getFirstName();
        firstname.setText(firstnameOfEmployee);

        Label lastname = new Label();
        String lastnameOfEmployee = Main.employees.get(0).getLastName();
        lastname.setText(lastnameOfEmployee);

        GridPane.setConstraints(firstname, 0, 0);
        GridPane.setConstraints(lastname, 6, 6);

        layout.getChildren().addAll(firstname, lastname);



        Scene scene = new Scene(layout);
        employeeDetails.setScene(scene);
        employeeDetails.show();
    }
}
