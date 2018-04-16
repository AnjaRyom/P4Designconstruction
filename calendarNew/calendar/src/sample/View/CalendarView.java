package sample.View;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import sample.Controller.Controller;

/*
* This class describes the calendar view
* It extends from the scene class of javafx,
* since it is considered as entire scene itself
* It consist of leftmenu, topmenu and centermenu
* The calendar view is a borderpane
*/

public class CalendarView extends Scene{

    Controller controller;
    private double width;
    private double height;
    private WeekView weekView;
    private BorderPane border = new BorderPane();
    LeftMenu leftMenu;
    TopMenu topMenu;
    CenterMenu centerMenu;



    //The constructor for the calendar view
    public CalendarView(Parent root, double width, double height,Controller controller) {
        super(root,width,height);
        this.controller = controller;
        this.width = width;
        this.height = height;
        this.weekView = new WeekView(this.controller);

        this.leftMenu = new LeftMenu(this.controller);
        this.topMenu = new TopMenu(this.controller);
        this.centerMenu = this.weekView;


        topMenu.setStyle("-fx-background-color: white;");
        centerMenu.setStyle("-fx-background-color: #bd72db;");
        leftMenu.setStyle("-fx-background-color: #bd72db;");
        border.setLeft(leftMenu);
        border.setTop(topMenu);
        border.setCenter(centerMenu);

        super.setRoot(border);

    }

    //Getters for calendar view
    public LeftMenu getLeftMenu() {
        return leftMenu;
    }
    public TopMenu getTopMenu() {
        return topMenu;
    }
    public CenterMenu getCenterMenu() {
        return centerMenu;
    }
    public void setCenterMenu(CenterMenu centerMenu) {
        this.centerMenu = centerMenu;
        border.setCenter(centerMenu);
    }
    public BorderPane getBorder() {
        return border;
    }
    public WeekView getWeekView() {
        return weekView;
    }

}
