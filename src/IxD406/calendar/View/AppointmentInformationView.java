package IxD406.calendar.View;

import IxD406.calendar.Controller.Controller;
import IxD406.calendar.Model.Appointment;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * <h1> AppointmentInformationView</h1>
 * This class describes the information view associated with an appointment
 * This class extends the NewAppointmentView
 */


public class AppointmentInformationView extends NewAppointmentView {

    private boolean isDisabled = true;

    //The constructor for AppointmentInformationView
    public AppointmentInformationView(Controller controller, Appointment appointment, String title) {
        super(controller);
        super.hourTextField.setText("" + Integer.toString(appointment.getHour()));
        super.minuteTextField.setText("" + Integer.toString(appointment.getMinute()));
        super.weekNumberTextField.setText("" + Integer.toString(controller.getCurrentWeek().getWeekNumber()));
        super.customerTextField.setText("" + appointment.getCustomer());
        super.durationTextField.setText("" + Integer.toString((appointment.getDurationInMinutes())));
        super.phoneNumberTextField.setText("" + Integer.toString(appointment.getPhoneNumber()));
        super.dayComboBox.setValue(appointment.getAppointmentDay());
        super.employeeComboBox.setValue(appointment.getEmployee());
        super.serviceComboBox.setValue(appointment.getService());

        super.saveButton.setVisible(false);
        Button editButton = new Button("Rediger");
        editButton.setPrefWidth(100);
        Button deleteButton = new Button("Slet");
        deleteButton.setPrefWidth(100);
        super.saveButton.setPrefWidth(100);
        super.gridpane4.getChildren().addAll(editButton, deleteButton);
        super.gridpane4.setConstraints(editButton, 21,0);
        super.gridpane4.setConstraints(deleteButton, 22,0);
        super.gridpane4.setConstraints(super.saveButton, 20,0);
        DisableOrEnableFields();

        Button finishButton = new Button("Til kassen");
        finishButton.setPrefWidth(200);
        super.gridpane4.setConstraints(finishButton, 0,0);
        super.gridpane4.getChildren().add(finishButton);

        editButton.setOnAction(e -> {
            DisableOrEnableFields();
            super.saveButton.setVisible(true);
            editButton.setVisible(false);
            deleteButton.setVisible(false);
            super.gridpane4.setConstraints(editButton, 20,0);
            super.gridpane4.setConstraints(deleteButton, 21,0);
            super.gridpane4.setConstraints(super.saveButton, 22,0);
            finishButton.setVisible(false);

            super.saveButton.setOnAction(e1 -> {
                controller.OverWriteAppointment(appointment, hourTextField.getText(), minuteTextField.getText(),
                        weekNumberTextField.getText(), dayComboBox.getValue(), durationTextField.getText(),
                        employeeComboBox.getValue(), customerTextField.getText(), phoneNumberTextField.getText(), serviceComboBox.getValue());
                DisableOrEnableFields();
                super.saveButton.setVisible(false);
                editButton.setVisible(true);
                deleteButton.setVisible(true);
                finishButton.setVisible(true);


                super.gridpane4.setConstraints(editButton, 21,0);
                super.gridpane4.setConstraints(deleteButton, 22,0);
                super.gridpane4.setConstraints(super.saveButton, 20,0);

            });

        });

        deleteButton.setOnAction(e -> {
            super.window.close();
            controller.DeleteAppointment(appointment);

        });
    }


    /**
     * This method enables or disables the textfields and comboboxes based on their current state
     */
    private void DisableOrEnableFields(){
        for (Node node:super.newAppointmentView.getChildren()) {
            if (node instanceof GridPane){
                GridPane gridpane = (GridPane)node;
                for (Node node1:gridpane.getChildren()) {
                    if(node1 instanceof TextField || node1 instanceof ComboBox){
                        node1.setDisable(isDisabled);
                    }
                }
            }

        }
        isDisabled = !isDisabled;
    }
}
