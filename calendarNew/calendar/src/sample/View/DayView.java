package sample.View;


import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.VBox;
import sample.Controller.Controller;
import sample.Model.Appointment;
import sample.Model.Week;
import java.util.ArrayList;
import java.util.List;

/*
 * This class describes a dayview
 * A dayview is a centermenu, with root as VBox
 */

public class DayView extends CenterMenu {

    Week.Day day;
    List<VBox> vboxesForAppointments = new ArrayList<>();
    List<Appointment> appointmentsForThisDay;
    int hoursInWorkDay = 8;

    //Constructor for DayView
    public DayView(Controller controller, Week.Day day) {
        super(controller);
        this.day = day;
        this.setStyle("-fx-background-color: #dbb6e7;");

        //this.setGridLinesVisible(true);
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

    //Getters for weekview
    public Week.Day getDay() {
        return day;
    }

    //This method expand the view, when dayview is chosen for the centerMenu
    public DayView ExpandView(){
        this.setPadding(new Insets(10,50,50,10));
        this.setMaxWidth(2360);
        this.setMinWidth(2360);
        return this;
    }
    //This method contract the view, when weekview is chosen for the centerMenu
    public DayView ContractView(int width){
        this.setMaxWidth(width);
        this.setMinWidth(width);
        return this;
    }

    //This methods creates the labels for the timestamps
    public void createTimeLabels(VBox timeLabelBox){
        for(int i = 0; i < hoursInWorkDay; i++){
            Label timeLabel = new Label(""+(i+hoursInWorkDay));
            timeLabelBox.getChildren().add(timeLabel);
            if(i != 0){
                  timeLabelBox.setMargin(timeLabel,new Insets(56-timeLabel.getFont().getSize(),0,0,0));
            }
        }
    }

    //This method adds button for created appointment
    //and adds it to the right column based on employee
    public void AddButtonForAppointment(Appointment appointment, int appointmentIndex){
        Button newButton = new Button("Aftale for: " + appointment.getCustomer());
        newButton.setPrefHeight(appointment.getDurationInMinutes());
        newButton.setPrefWidth(vboxesForAppointments.get(0).getWidth());
        newButton.setOnAction(e -> controller.ShowExistingAppointmentView(appointment));
        switch(appointment.getEmployee()){
            case Jessica:
                vboxesForAppointments.get(0).getChildren().add(newButton);
                vboxesForAppointments.get(0).setMargin(newButton,calcInsetForAppointment(appointment, appointmentIndex));
                break;
            case Gry:
                vboxesForAppointments.get(1).getChildren().add(newButton);
                vboxesForAppointments.get(1).setMargin(newButton,calcInsetForAppointment(appointment, appointmentIndex));
                break;
            default:
        }
    }

    //This method calculate where the button for appointment should be placed (in order to top)
    private Insets calcInsetForAppointment(Appointment appointment, int appointmentIndex){
        double top,center;
        Label labelForSize = new Label("1");


        if(appointmentIndex == 0){
            top = appointment.MinuteOfStartingPoint() + labelForSize.getFont().getSize()/2;
        } else {
            Appointment previousAppointment = appointmentsForThisDay.get(appointmentIndex-1);
            top = (appointment.MinuteOfStartingPoint()) - (previousAppointment.MinuteOfStartingPoint() + previousAppointment.getDurationInMinutes());
        }

        return new Insets(top,0,0,0);
    }

    //This method updates the centermenu when something change
    public void UpdateCenterMenu(Week currentWeek){
        for (int i = 0; i < this.getChildren().size();i++){
            if(this.getChildren().get(i) instanceof VBox){
                VBox foundBox = (VBox)this.getChildren().get(i);
                foundBox.getChildren().removeIf(e-> e instanceof Button);
            }
        }
        appointmentsForThisDay = new ArrayList<>(currentWeek.getAppointments());
        appointmentsForThisDay.removeIf(e -> e.getAppointmentDay() != day);
        int counterForAppointmentIndex = 0;
        for (Appointment appointment: appointmentsForThisDay) {
            AddButtonForAppointment(appointment, counterForAppointmentIndex);
            counterForAppointmentIndex++;
        }
    }
}
