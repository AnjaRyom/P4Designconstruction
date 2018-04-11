package sample.View;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import sample.Controller.Controller;
import sample.Model.Appointment;
import sample.Model.Week;

import java.util.ArrayList;
import java.util.List;

/*
* This class describes a weekview
* A weekview consist 5 dayviews
 */

public class WeekView extends CenterMenu {

    List<DayView> dayViews = new ArrayList<>();

    public WeekView(Controller controller) {
        super(controller);

        CreateColumns();
        CreateDayViews();
        CreateRows();

        //Label for weekdays
        Label monday = new Label("Mandag");
        GridPane.setConstraints(monday, 0, 0);
        monday.setOnMouseClicked(e -> controller.ChangeToDayView(dayViews.get(0)));
        Label tuesday = new Label("Tirsdag");
        GridPane.setConstraints(tuesday, 1, 0);
        tuesday.setOnMouseClicked(e -> controller.ChangeToDayView(dayViews.get(1)));
        Label wednesday = new Label("Onsdag");
        GridPane.setConstraints(wednesday, 2, 0);
        wednesday.setOnMouseClicked(e -> controller.ChangeToDayView(dayViews.get(2)));
        Label thursday = new Label("Torsdag");
        GridPane.setConstraints(thursday, 3, 0);
        thursday.setOnMouseClicked(e -> controller.ChangeToDayView(dayViews.get(3)));
        Label friday = new Label("Fredag");
        GridPane.setConstraints(friday, 4, 0);
        friday.setOnMouseClicked(e -> controller.ChangeToDayView(dayViews.get(4)));

        this.setHgap(10);
        this.setPadding(new Insets(10,50,50,10));
        this.getChildren().addAll(monday, tuesday, wednesday, thursday, friday);
        this.setMaxWidth(2360);
        this.setMinWidth(2360);
    }


    //Create columns for the calendar centerview
    public void CreateColumns(){

        for (int i = 0; i < 5; i++) {
            ColumnConstraints column = new ColumnConstraints();
            column.setPercentWidth(20);
            this.getColumnConstraints().add(column);
        }
    }

    //Create rows for the calendar centerview
    public void CreateRows(){
        RowConstraints labelRow = new RowConstraints(40);
        this.getRowConstraints().add(labelRow);
        RowConstraints buttonRow = new RowConstraints();
        buttonRow.setPercentHeight(100);
        this.getRowConstraints().add(buttonRow);


    }

    public void CreateDayViews(){
        int i = 0;
        for (Week.Day day:Week.Day.values())
        {
            DayView newDayView = new DayView(this.controller,day);
            dayViews.add(newDayView);
            this.setConstraints(newDayView,i,1);
            this.getChildren().add(newDayView);
            i++;
        }
    }

    public void UpdateCenterMenu(Week currentWeek){
        for (DayView day:dayViews)
        {
            day.UpdateCenterMenu(currentWeek);
        }
       // for (Appointment appointment: currentWeek.getAppointments()) {
       //     AddButtonForAppointment(appointment);
       // }
    }

    public void AddButtonForAppointment(Appointment appointment)
    {
        Button newButton = new Button("Aftale for: " + appointment.getCustomer());
        newButton.setMinHeight(appointment.getDurationInMinutes());
        switch (appointment.getAppointmentDay()){
            case MANDAG: AddButtonWithConstraints(newButton,dayViews.get(0),1, appointment);
                break;
            case TIRSDAG: AddButtonWithConstraints(newButton,dayViews.get(1),1,appointment);
                break;
            case ONSDAG: AddButtonWithConstraints(newButton,dayViews.get(2),1,appointment);
                break;
            case TORSDAG: AddButtonWithConstraints(newButton,dayViews.get(3),1,appointment);
                break;
            case FREDAG: AddButtonWithConstraints(newButton,dayViews.get(4),1,appointment);
                break;
            default:

        }
    }

    private void AddButtonWithConstraints(Button button, DayView dayView, int rowIndex, Appointment appointment){
        switch(appointment.getEmployee()){
            case Jessica:dayView.setConstraints(button,0,rowIndex);
                break;
            case Gry:dayView.setConstraints(button,1,rowIndex);
                break;
            default:
        }
        dayView.getChildren().add(button);
    }
}
