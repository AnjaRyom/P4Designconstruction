package sample.View;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.Controller.Controller;
import sample.Main;
import sample.Model.Week;

/*
 * This class describes the new appointment view
 * The class creates a new stage which makes the class like a pop up window
 */

public class NewAppointmentView {

    static Controller controller;


    public NewAppointmentView(Controller controller) {
        this.controller = controller;
    }

    public static void display(String title){

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL); //blokerer action med andre vinduer

        window.setTitle(title);
        window.setMinWidth(250);
        window.setMinHeight(250);

        //Time
        Label hourLabel = new Label("Klokkeslæt");
        TextField hourTextField = new TextField();
        hourTextField.setPromptText("Time angivelse");
        TextField minuteTextField = new TextField();
        minuteTextField.setPromptText("Minut angivelse");

        Label weekLabel = new Label("Ugenr");
        TextField weekNumberTextField = new TextField();
        weekNumberTextField.setPromptText("Ugenummer");

        Label dayLabel = new Label("Dag i ugen");
        ComboBox<Week.Day> dayComboBox = new ComboBox<>();
        dayComboBox.setValue(Week.Day.MANDAG);

        Label durationLabel = new Label("Varighed i minutter");
        TextField durationTextField = new TextField();
        durationTextField.setPromptText("Varighed");
        dayComboBox.setItems(FXCollections.observableArrayList(Week.Day.values()));


        //Employee
        Label employeeLabel = new Label("Frisør");
        ComboBox<Main.Employee> employeeComboBox = new ComboBox<>();
        employeeComboBox.setItems(FXCollections.observableArrayList(Main.Employee.values()));
        employeeComboBox.setValue(Main.Employee.Jessica);


        //Customer
        Label customerLabel = new Label("Kundenavn");
        TextField customerTextField = new TextField();
        customerTextField.setPromptText("Kundenavn");

        //Button
        Button saveButton = new Button("Save appointment");
        saveButton.setOnAction(e->{controller.CreateAndSaveAppointment(hourTextField.getText(),
                    minuteTextField.getText(), weekNumberTextField.getText(), dayComboBox.getValue(), durationTextField.getText(),
                    employeeComboBox.getValue(), customerTextField.getText());
                window.close();
                });

        //layout on pop up
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20,20));

        layout.getChildren().addAll(hourLabel,hourTextField,minuteTextField, weekLabel, weekNumberTextField,
                dayLabel, dayComboBox,durationLabel, durationTextField,employeeLabel, employeeComboBox, customerLabel,
                customerTextField, saveButton);


        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}
