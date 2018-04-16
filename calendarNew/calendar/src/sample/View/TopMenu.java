package sample.View;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
        newAppointment.setPrefSize(100,30);
        newAppointment.setStyle("-fx-base: #dbb6e7;");

        GridPane.setConstraints(newAppointment, 0, 0);
        newAppointment.setOnAction(e -> controller.ShowNewAppointmentView());

        Button back = new Button("<");
        back.setPrefSize(20,30);
        back.setStyle("-fx-base: #dbb6e7;");


        back.setOnAction(e -> {
            controller.PreviousWeek();
            weekNumberLabel.setText("Weeknumber: " + Integer.toString(controller.getCurrentWeek().getWeekNumber()));
        });

        GridPane.setConstraints(back, 1, 0);


        //Different buttons
        GridPane.setConstraints(weekNumberLabel, 2, 0);
        Button forward = new Button(">");
        forward.setPrefSize(20,30);
        forward.setStyle("-fx-base: #dbb6e7;");


        forward.setOnAction(e -> {
            controller.NextWeek();
            weekNumberLabel.setText("Weeknumber: " + Integer.toString(controller.getCurrentWeek().getWeekNumber()));
        });

        weekNumberLabel.setStyle("-fx-font: 16 arial;");
        GridPane.setConstraints(forward, 3, 0);
        Label employee1 = new Label("Tommy");
        employee1.setPadding(new Insets(5,5,5,5));
        employee1.setStyle("-fx-background-color: #b6e7b9;");
        GridPane.setConstraints(employee1, 4, 0);
        Label employee2 = new Label("Simone");
        employee2.setPadding(new Insets(5,5,5,5));
        employee2.setStyle("-fx-background-color: #64b1e0;");
        GridPane.setConstraints(employee2, 5, 0);
        Label employee3 = new Label("Lise");
        employee3.setPadding(new Insets(5,5,5,5));
        employee3.setStyle("-fx-background-color: #7664e0;");
        GridPane.setConstraints(employee3, 6, 0);
        Label employee4 = new Label("Cecilie");
        employee4.setPadding(new Insets(5,5,5,5));
        employee4.setStyle("-fx-background-color: #ed944b;");
        GridPane.setConstraints(employee4, 7, 0);


        this.getChildren().addAll(newAppointment, back, weekNumberLabel, forward, employee1, employee2, employee3, employee4);
        this.setPadding(new Insets(20, 400, 20,400));
        this.setHgap((10));
    }
}
