package sample.View;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import sample.Controller.Controller;
import sample.Model.Appointment;
import sample.Model.Week;

import java.util.ArrayList;
import java.util.List;

/*
* This class describes a dayview
 */

public class DayView extends CenterMenu {

    Week.Day day;
    List<VBox> VboxesForAppointments = new ArrayList<>();

    public DayView(Controller controller, Week.Day day) {
        super(controller);
        this.day = day;
        this.setStyle("-fx-background-color: lightblue;");
        this.setGridLinesVisible(true);
        for (int i = 0; i < 4;i++){
            ColumnConstraints innerColumn = new ColumnConstraints();
            innerColumn.setPercentWidth(25);
            this.getColumnConstraints().add(innerColumn);

            VBox innerVbox = new VBox();
            this.setConstraints(innerVbox,i,0);
            VboxesForAppointments.add(innerVbox);
            this.getChildren().add(innerVbox);
        }
    }

    public Week.Day getDay() {
        return day;
    }

    public DayView ExpandView(){
        this.setPadding(new Insets(10,50,50,10));
        this.setMaxWidth(2360);
        this.setMinWidth(2360);
        return this;
    }

    public DayView ContractView(int width){
        this.setMaxWidth(width);
        this.setMinWidth(width);
        return this;
    }


    public void AddButtonForAppointment(Appointment appointment){
        Button newButton = new Button("Aftale for: " + appointment.getCustomer());
        newButton.setMinHeight(appointment.getDurationInMinutes());

        switch(appointment.getEmployee()){
            case Jessica:
                VboxesForAppointments.get(0).getChildren().add(newButton);
                VboxesForAppointments.get(0).setMargin(newButton,calcInsetForAppointment(appointment));
                break;
            case Gry:
                VboxesForAppointments.get(1).getChildren().add(newButton);
                VboxesForAppointments.get(1).setMargin(newButton,calcInsetForAppointment(appointment));
                break;
            default:
        }
    }

    private Insets calcInsetForAppointment(Appointment appointment){
        double top,center;
        center = appointment.getDurationInMinutes()/2;
        top = appointment.MinuteOfStartingPoint() + center;

        return new Insets(top,0,0,0);
    }

    public void UpdateCenterMenu(Week currentWeek){
        for (int i = 0; i < this.getChildren().size();i++){
            if(this.getChildren().get(i) instanceof VBox){
                VBox foundBox = (VBox)this.getChildren().get(i);
                foundBox.getChildren().removeIf(e-> e instanceof Button);
            }
        }
        List<Appointment> appointmentsForThisDay = new ArrayList<>(currentWeek.getAppointments());
        appointmentsForThisDay.removeIf(e -> e.getAppointmentDay() != day);
        for (Appointment appointment: appointmentsForThisDay) {
            AddButtonForAppointment(appointment);
        }
    }
}
