package sample.View;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import sample.Model.Appointment;
import sample.Controller.Controller;
import sample.Model.Week;

import java.util.ArrayList;
import java.util.List;


/**
 * This class describes the centermenu for calendar view
 * The menu extends from GridPane
 * The centermenu is absract since the center is either dayview or weekview
 */

public abstract class CenterMenu extends GridPane{

    Controller controller;

    public CenterMenu(Controller controller) {
        this.controller=controller;

    }

    /**
     * Make sure each subclass is able to update the centermenu
     * @param currentWeek Week - the week containing the elements that should be updated
     */
    public abstract void UpdateCenterMenu(Week currentWeek);


}
