package sample.View;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import sample.Controller.Controller;

import java.beans.PropertyChangeEvent;
import java.util.Calendar;

/*
 * This class describes the topmenu for the calendar view
 * The menu is a gridpane and extends from GridPane
 * The topmenu consist of....
 */

public class TopMenu extends GridPane{

    Controller controller;

    //Constructor for the topmenu
    public TopMenu(Controller controller) {
        this.controller = controller;


        //Current weeknumber as a label
        int weeknumber = Calendar.getInstance().get(Calendar.WEEK_OF_YEAR);
        Label weekNumberLabel = new Label("Weeknumber: " + Integer.toString(weeknumber));

        Button newAppointment = new Button("Opret aftale");
        GridPane.setConstraints(newAppointment, 0, 0);
        newAppointment.setOnAction(e -> controller.ShowNewAppointmentView());
        Button back = new Button("<");
        back.setOnAction(e -> {
            controller.PreviousWeek();
            weekNumberLabel.setText("Weeknumber: " + Integer.toString(controller.getCurrentWeek().getWeekNumber()));
        });

        GridPane.setConstraints(back, 1, 0);


        //Different buttons
        GridPane.setConstraints(weekNumberLabel, 2, 0);
        Button forward = new Button(">");
        forward.setOnAction(e -> {
            controller.NextWeek();
            weekNumberLabel.setText("Weeknumber: " + Integer.toString(controller.getCurrentWeek().getWeekNumber()));
        });

        GridPane.setConstraints(forward, 3, 0);
        Button employee1 = new Button("Tommy");
        GridPane.setConstraints(employee1, 4, 0);
        Button employee2 = new Button("Simone");
        GridPane.setConstraints(employee2, 5, 0);
        Button employee3 = new Button("Lise");
        GridPane.setConstraints(employee3, 6, 0);
        Button employee4 = new Button("Cecilie");
        GridPane.setConstraints(employee4, 7, 0);

        this.getChildren().addAll(newAppointment, back, weekNumberLabel, forward, employee1, employee2, employee3, employee4);
        this.setPadding(new Insets(20, 20, 20,80));
        this.setHgap((10));
    }
}
