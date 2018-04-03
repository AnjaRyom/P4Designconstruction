package sample.View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import sample.Model.Appointment;
import sample.Controller.Controller;
import sample.Model.Week;

import java.util.ArrayList;
import java.util.List;


/*
 * This class describes the centermenu for calendar view
 * The menu is gridpane extends from GridPane
 * The centermenu is absract since the center is either dayview or weekview
 */

public abstract class CenterMenu extends GridPane {

    Controller controller;

    public CenterMenu(Controller controller) {
        this.controller=controller;



    }

    public abstract void AddButtonForAppointment(Appointment appointment);

    public abstract void UpdateCenterMenu(Week currentWeek);


}
