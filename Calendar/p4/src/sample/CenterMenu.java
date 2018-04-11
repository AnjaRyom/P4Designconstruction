package sample;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class CenterMenu extends GridPane {

    Controller controller;

    public CenterMenu(Controller controller) {

        this.controller=controller;

        //Denne sørger for at lave 5 colums, der er hver 160
        for (int i = 0; i < 5; i++) {
            ColumnConstraints column = new ColumnConstraints(160);
            this.getColumnConstraints().add(column);
        }

        //Denne sørger for at lave 5 rows, der hver er 40 høj
        for (int i = 0; i < 5; i++) {
            RowConstraints row = new RowConstraints(40);
            this.getRowConstraints().add(row);
        }

        //Label for ugedage
        Label monday = new Label("Mandag");
        GridPane.setConstraints(monday, 0, 0);
        Label tuesday = new Label("Tirsdag");
        GridPane.setConstraints(tuesday, 1, 0);
        Label wednesday = new Label("Onsdag");
        GridPane.setConstraints(wednesday, 2, 0);
        Label thursday = new Label("Torsdag");
        GridPane.setConstraints(thursday, 3, 0);
        Label friday = new Label("Fredag");
        GridPane.setConstraints(friday, 4, 0);


        this.setPadding(new Insets(10,50,50,0));
        this.setHgap(10);
        this.getChildren().addAll(monday, tuesday, wednesday, thursday, friday);
        this.setMaxWidth(800);
    }

    public void AddButtonForAppointment(Appointment appointment)
    {
        Button newButton = new Button("Aftale for: " + appointment.customer );
        this.setConstraints(newButton,0,1);
        this.getChildren().add(newButton);
    }
}
