package IxD406.calendar.View;


import IxD406.calendar.Controller.Controller;
import IxD406.calendar.Model.Appointment;
import IxD406.calendar.Model.Week;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <h1> DayView </h1>
 * This class describes a dayview
 * A dayview is a centermenu, with root as VBox
 */


public class DayView extends CenterMenu {

    Week.Day day;
    List<VBox> vboxesForAppointments = new ArrayList<>();
    List<Appointment> appointmentsForThisDay;
    int hoursInWorkDay = 8;
    double originalWidth;
    double originalHeight;
    boolean isExpanded = false;

    //Constructor for DayView
    public DayView(Controller controller, Week.Day day) {
        super(controller);
        this.day = day;
        this.setStyle("-fx-background-color: white;");

        CreateVBoxes();

        originalWidth = this.getWidth();
        originalHeight = this.getHeight();
    }

    //Getters for weekview
    public Week.Day getDay() {
        return day;
    }

    /**
     * This method expand the view, when dayview is chosen for the centerMenu
     * @return Dayview - returns itself after expansion
     */
    public DayView ExpandView(){
        this.setPrefWidth(1100);
        isExpanded = true;
        UpdateVBoxes(3,23);
        UpdateButtons();

        return this;
    }

    /**
     * This method updates the buttons so they fit the mode of the dayview(expanded or contracted)
     */
    private void UpdateButtons(){
        int counterForAppointments = 0;
        Appointment appointmentForButton;
        for (Node node:this.getChildren()) {
            if(node instanceof VBox){
                VBox vBox = (VBox)node;
                for (Node node1:vBox.getChildren()) {
                    if(node1 instanceof Button){
                        Button button = (Button)node1;
                        button.setPrefWidth(1000);
                        appointmentForButton = appointmentsForThisDay.get(counterForAppointments);
                        if(isExpanded){
                            button.setText(button.getText() + "\n" + appointmentForButton.getHour() + ":" + appointmentForButton.getMinute());
                        }

                        counterForAppointments++;
                    }
                }

            }

        }
    }

    /**
     * This method updates the vboxes so they fit the mode of the dayview(expanded or contracted)
     * @param labelWidth double - the width of the column in which the labels are placed
     * @param columnWidth double - the width of the column in which the appointments are placed
     */
    private void UpdateVBoxes(double labelWidth, double columnWidth){
        int i = 0;
        this.getColumnConstraints().clear();
        for (Node node:this.getChildren()) {
            if(node instanceof VBox){
                VBox vBox = (VBox)node;
                ColumnConstraints innerColumn = new ColumnConstraints();
                if(i==0){
                    innerColumn.setPercentWidth(labelWidth);
                }
                else innerColumn.setPercentWidth(columnWidth);
                this.getColumnConstraints().add(innerColumn);
                this.setConstraints(vBox,i,0);
                i++;
            }

        }
    }

    /**
     * This method creates the vboxes for the labels and employees
     */
    private void CreateVBoxes(){
        for (int i = 0; i < 5;i++){
            ColumnConstraints innerColumn = new ColumnConstraints();
            if(i == 0){
                innerColumn.setPercentWidth(10);
            }
            else{
                innerColumn.setPercentWidth(22.5);
            }
            this.getColumnConstraints().add(innerColumn);

            VBox innerVbox = new VBox();
            this.setConstraints(innerVbox,i,0);
            innerVbox.setPrefHeight(500);
            if(i!=0) {
                vboxesForAppointments.add(innerVbox);
            } else{
                createTimeLabels(innerVbox);
            }
            this.getChildren().add(innerVbox);
        }
    }


    /**
     * This method contract the view, when weekview is chosen for the centerMenu
     * @return DayView - returns the contracted DayView
     */
    public DayView ContractView(){
        this.setPrefWidth(200);
        isExpanded = false;
        UpdateVBoxes(10,22.5);
        UpdateButtons();

        return this;
    }

    /**
     * This methods creates the labels for the timestamps
     * @param timeLabelBox VBox - the vbox which the labels should be placed in
     */
    public void createTimeLabels(VBox timeLabelBox){
        for(int i = 0; i < hoursInWorkDay + 1; i++){
            Label timeLabel = new Label(""+(i+hoursInWorkDay));
            timeLabelBox.getChildren().add(timeLabel);
            if(i != 0){
                  timeLabelBox.setMargin(timeLabel,new Insets(56*2-timeLabel.getFont().getSize(),0,0,0));
            }
        }
    }

    /**
     * This method adds button for created appointment, in the right color based on employee
     * and adds it to the right column based on employee
     * @param appointment Appointment - the appointment for which a button has to be made
     */
    public void AddButtonForAppointment(Appointment appointment){
        Button newButton = new Button("" + appointment.getCustomer());
        newButton.setPrefHeight(appointment.getDurationInMinutes()*2);
        newButton.setOnAction(e -> controller.ShowExistingAppointmentView(appointment));
        newButton.setPrefWidth(1000);
        newButton.setFont(new Font(10));
        switch(appointment.getEmployee().getName()){
            case "Tommy":
                vboxesForAppointments.get(0).getChildren().add(newButton);
                vboxesForAppointments.get(0).setMargin(newButton,calcInsetForAppointment(appointment));
                newButton.setStyle("-fx-base: #b6e7b9;");
                break;
            case "Simone":
                vboxesForAppointments.get(1).getChildren().add(newButton);
                vboxesForAppointments.get(1).setMargin(newButton,calcInsetForAppointment(appointment));
                newButton.setStyle("-fx-base: #C69BE8;");
                break;
            case "Lise":
                vboxesForAppointments.get(2).getChildren().add(newButton);
                vboxesForAppointments.get(2).setMargin(newButton,calcInsetForAppointment(appointment));
                newButton.setStyle("-fx-base: #9486d0;");
                break;
            case "Cecilie":
                vboxesForAppointments.get(3).getChildren().add(newButton);
                vboxesForAppointments.get(3).setMargin(newButton,calcInsetForAppointment(appointment));
                newButton.setStyle("-fx-base: #66bbd0;");
                break;
            default:
        }
    }


    /**
     * This method calculates where the button for appointment should be placed
     * (in relation to the top or bottom of the previous button)
     * @param appointment Appointment - specifies which appointment the calculation is made for
     * @return Insets - returns the insets for the margin
     */
    private Insets calcInsetForAppointment(Appointment appointment){
        double top;
        Label labelForSize = new Label("1");

        List<Appointment> appointmentsForEmployeeOnThisDay = appointment.getEmployee().getAppointmentsForEmployee().stream().filter(
                item -> item.getAppointmentDay() == appointment.getAppointmentDay() && item.getWeekNumber() == appointment.getWeekNumber()
        ).collect(Collectors.toList());
        int indexOfAppointmentInFilteredListOfEmployee = appointmentsForEmployeeOnThisDay.indexOf(appointment);

        if(indexOfAppointmentInFilteredListOfEmployee == 0){
            top = appointment.MinuteOfStartingPoint() + labelForSize.getFont().getSize()/2;
        } else {
            Appointment previousAppointment = appointmentsForEmployeeOnThisDay.get(appointmentsForEmployeeOnThisDay.indexOf(appointment)-1);
            top = (appointment.MinuteOfStartingPoint()) - (previousAppointment.MinuteOfStartingPoint() + previousAppointment.getDurationInMinutes()*2);
        }

        return new Insets(top,0,0,0);
    }


    /**
     * This method updates the centermenu when something change
     * @param currentWeek Week - the week containing the elements that should be updated
     */
    public void UpdateCenterMenu(Week currentWeek){
        for (int i = 0; i < this.getChildren().size();i++){
            if(this.getChildren().get(i) instanceof VBox){
                VBox foundBox = (VBox)this.getChildren().get(i);
                foundBox.getChildren().removeIf(e-> e instanceof Button);
            }
        }
        appointmentsForThisDay = new ArrayList<>(currentWeek.getAppointments());
        appointmentsForThisDay.removeIf(e -> e.getAppointmentDay() != day);
        for (Appointment appointment: appointmentsForThisDay) {
            AddButtonForAppointment(appointment);

        }
        if(isExpanded){
            ExpandView();
        }
    }
}
