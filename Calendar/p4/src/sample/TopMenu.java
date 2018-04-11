package sample;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.util.Calendar;

public class TopMenu extends GridPane{

    Controller controller;

    public TopMenu(Controller controller) {
        this.controller = controller;

        Button newAppointment = new Button("Opret aftale");
        GridPane.setConstraints(newAppointment, 0, 0);
        newAppointment.setOnAction(e -> controller.ShowNewAppointmentView());
        Button back = new Button("<");
        GridPane.setConstraints(back, 1, 0);

        //Tager ugenummer og sætter ind som label
        int weeknumber = Calendar.getInstance().get(Calendar.WEEK_OF_YEAR);
        Label weekNumber = new Label("Weeknumber: " + Integer.toString(weeknumber));


        //Forskellige buttons
        GridPane.setConstraints(weekNumber, 2, 0);
        Button forward = new Button(">");
        GridPane.setConstraints(forward, 3, 0);
        Button employee1 = new Button("Tommy");
        GridPane.setConstraints(employee1, 4, 0);
        Button employee2 = new Button("Simone");
        GridPane.setConstraints(employee2, 5, 0);
        Button employee3 = new Button("Lise");
        GridPane.setConstraints(employee3, 6, 0);
        Button employee4 = new Button("Cecilie");
        GridPane.setConstraints(employee4, 7, 0);

        this.getChildren().addAll(newAppointment, back, weekNumber, forward, employee1, employee2, employee3, employee4);
        this.setPadding(new Insets(20, 20, 20,80));
        this.setHgap((10));
    }
}
