package IxD406.calendar.View;

import IxD406.calendar.Controller.Controller;
import IxD406.calendar.Model.Employee;
import IxD406.calendar.Model.Service;
import IxD406.calendar.Model.Week;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import IxD406.calendar.Main;


/**
 * <h1> NewAppointmentView </h1>
 * This class describes the new appointment view
 * The class creates a new stage/window which makes the class like a pop up window
 */



public class NewAppointmentView {

    static Controller controller;
    Label hourLabel;
    Label colonLabel;
    Label weekLabel;
    Label dayLabel;
    Label durationLabel;
    Label serviceLabel;
    Label employeeLabel;
    Label customerLabel;
    Label phoneNumberLabel;
    TextField hourTextField;
    TextField minuteTextField;
    TextField weekNumberTextField;
    TextField durationTextField;
    TextField customerTextField;
    TextField phoneNumberTextField;
    ComboBox<Employee> employeeComboBox;
    ComboBox<Week.Day> dayComboBox;
    ComboBox<Service> serviceComboBox;
    GridPane newAppointmentView;
    GridPane gridpane1;
    GridPane gridpane2;
    GridPane gridpane3;
    GridPane gridpane4;
    Button saveButton;
    Stage window;




    //Constructor for NewAppointmentView
    public NewAppointmentView(Controller controller) {
        this.controller = controller;

        window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL); //blokerer action med andre vinduer

        window.setTitle("Appointment");
        window.setMinWidth(500);
        window.setMinHeight(150);

        MakeTimePartOfNewAppointmentView();
        MakeWeekPartOfNewAppointmentView();
        MakeDayPartOfNewAppointmentView();
        MakeDurationPartOfNewAppointmentView();
        MakeCustomerPartOfNewAppointmentView();
        MakeEmployeePartOfNewAppointmentView();
        MakePhoneNumberPartOfNewAppointmentView();
        MakeServicePartOfNewAppointmentView();

        //Layout med hboxe + gridpane
        newAppointmentView = new GridPane();
        gridpane1 = new GridPane();
        gridpane2 = new GridPane();
        gridpane3 = new GridPane();
        gridpane4 = new GridPane();

        newAppointmentView.setStyle("-fx-background: #9a6262;");
        gridpane1.setPadding(new Insets(20, 20, 20,20));
        gridpane2.setPadding(new Insets(20, 20, 20,20));
        gridpane3.setPadding(new Insets(20, 20, 20,20));
        gridpane4.setPadding(new Insets(20, 20, 20,20));

        saveButton = new Button("Gem");

        gridpane1.getChildren().addAll(customerLabel,customerTextField, phoneNumberLabel, phoneNumberTextField);
        gridpane2.getChildren().addAll(hourLabel, hourTextField, colonLabel, minuteTextField, dayLabel, dayComboBox, weekLabel, weekNumberTextField);
        gridpane3.getChildren().addAll(serviceLabel, serviceComboBox, durationLabel, durationTextField, employeeLabel, employeeComboBox);
        gridpane4.getChildren().addAll(saveButton);

        GridPane.setConstraints(gridpane1, 0,1 );
        GridPane.setConstraints(gridpane2, 0,2 );
        GridPane.setConstraints(gridpane3, 0,3 );
        GridPane.setConstraints(gridpane4, 0,4 );

        GridPane.setConstraints(customerLabel, 0,0);
        GridPane.setConstraints(customerTextField, 1,0);
        GridPane.setConstraints(phoneNumberLabel, 2,0);
        GridPane.setConstraints(phoneNumberTextField, 3,0);

        GridPane.setConstraints(hourLabel, 0,0);
        GridPane.setConstraints(hourTextField, 1,0);
        GridPane.setConstraints(colonLabel, 2,0);
        GridPane.setConstraints(minuteTextField, 3,0);
        GridPane.setConstraints(dayLabel, 4,0);
        GridPane.setConstraints(dayComboBox, 5,0);
        GridPane.setConstraints(weekLabel, 6,0);
        GridPane.setConstraints(weekNumberTextField, 7,0);

        GridPane.setConstraints(serviceLabel, 0,0);
        GridPane.setConstraints(serviceComboBox, 1,0);
        GridPane.setConstraints(durationLabel, 2,0);
        GridPane.setConstraints(durationTextField, 3,0);
        GridPane.setConstraints(employeeLabel, 4,0);
        GridPane.setConstraints(employeeComboBox, 5,0);

        GridPane.setConstraints(saveButton, 54,0);

        gridpane1.setHgap(10);
        gridpane2.setHgap(10);
        gridpane3.setHgap(10);
        gridpane4.setHgap(10);

        newAppointmentView.getChildren().addAll(gridpane1, gridpane2, gridpane3, gridpane4);

        saveButton.setOnAction(e->{controller.CreateAndSaveAppointment(hourTextField.getText(),
                minuteTextField.getText(), weekNumberTextField.getText(), dayComboBox.getValue(), durationTextField.getText(),
                employeeComboBox.getValue(), customerTextField.getText(), phoneNumberTextField.getText(), serviceComboBox.getValue());
            window.close();
        });

        Scene scene = new Scene(newAppointmentView);
        window.setScene(scene);
        window.show();
    }


    /**
     * This method creates the controls for time in the NewAppointmentView
     */
    private void MakeTimePartOfNewAppointmentView(){
        hourLabel = new Label("Klokkeslæt");
        hourLabel.setPadding(new Insets(4,0,0,0));
        hourLabel.setPrefWidth(70);
        hourTextField = new TextField();
        hourTextField.setPrefWidth(35);
        hourTextField.setPromptText("12");
        minuteTextField = new TextField();
        minuteTextField.setPromptText("30");
        minuteTextField.setPrefWidth(35);
        colonLabel = new Label(":");
        colonLabel.setPadding(new Insets(4,0,0,0));

    }

    /**
     * This method creates the controls for week in the NewAppointmentView
     */
    private void MakeWeekPartOfNewAppointmentView(){
        weekLabel = new Label("Ugenr");
        weekLabel.setPadding(new Insets(0,0,0,17));
        weekNumberTextField = new TextField();
        weekNumberTextField.setPrefWidth(35);
        weekNumberTextField.setPromptText("10");
    }

    /**
     * This method creates the controls for day in the NewAppointmentView
     */
    private void MakeDayPartOfNewAppointmentView(){
        dayLabel = new Label("Dag");
        dayLabel.setPadding(new Insets(0,0,0,146));
        dayComboBox = new ComboBox<>();
        dayComboBox.setPrefWidth(110);
        dayComboBox.setValue(Week.Day.Mandag);


    }

    /**
     * This method creates the controls for duration in the NewAppointmentView
     */
    private void MakeDurationPartOfNewAppointmentView(){
        durationLabel = new Label("Længde");
        durationLabel.setPadding(new Insets(0,0,0,40));
        durationTextField = new TextField();
        durationTextField.setPrefWidth(45);
        durationTextField.setPromptText("120");
        dayComboBox.setItems(FXCollections.observableArrayList(Week.Day.values()));

    }

    /**
     * This method creates the controls for employee in the NewAppointmentView
     */
    private void MakeEmployeePartOfNewAppointmentView(){
        employeeLabel = new Label("Frisør");
        employeeComboBox = new ComboBox<>();
        employeeComboBox.setItems(FXCollections.observableArrayList(Main.employees));
        employeeComboBox.setValue(Main.employees.get(0));

    }

    /**
     * This method creates the controls for customer in the NewAppointmentView
     */
    private void MakeCustomerPartOfNewAppointmentView(){
        customerLabel = new Label("Kundenavn");
        customerLabel.setPrefWidth(70);
        customerTextField = new TextField();
        customerTextField.setPromptText("Kundenavn");
    }

    /**
     * This method creates the controls for phonenumber in the NewAppointmentView
     */
    private void MakePhoneNumberPartOfNewAppointmentView(){
        phoneNumberLabel = new Label("Telefonnummer");
        phoneNumberTextField = new TextField();
        phoneNumberLabel.setPadding(new Insets(0,0,0,73));
        phoneNumberTextField.setPrefWidth(150);
        phoneNumberTextField.setPromptText("+45 88 88 88 88");

    }

    /**
     * This method creates the controls for service in the NewAppointmentView
     */
    private void MakeServicePartOfNewAppointmentView(){
        serviceLabel = new Label("Service");
        serviceLabel.setPrefWidth(70);
        serviceComboBox = new ComboBox<>();
        serviceComboBox.setItems(FXCollections.observableArrayList(Main.listOfServices));
        serviceComboBox.setPrefWidth(200);

    }
}
