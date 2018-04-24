package IxD406.calendar.View;

import IxD406.calendar.Controller.Controller;
import IxD406.calendar.Model.Week;
import javafx.scene.layout.GridPane;


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
