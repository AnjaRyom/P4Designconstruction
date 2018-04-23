package sample.View;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import sample.Controller.Controller;
import sample.Model.Week;

import java.beans.PropertyChangeEvent;
import java.util.Calendar;

/**
 * <h1> TopMenu </h1>
 * This class describes the topmenu for the calendar view
 * The menu is a gridpane and extends from GridPane
 * Futrhermore the gridpane consist of a HBox
 */


public class TopMenu extends GridPane{

    Controller controller;
    HBox hBoxForWeek;
    HBox hBoxForDay;
    boolean isHboxForDayCreated = false;
    Label weekNumberLabel = new Label();
    Label dayLabel = new Label();
    Button newAppointment;
    Label employee1;
    Label employee2;
    Label employee3;
    Label employee4;
    HBox hBoxForEmployees;

    //Constructor for the topmenu
    public TopMenu(Controller controller) {
        this.controller = controller;


        ButtonForNewAppointment();

        hBoxForWeek = HBoxForWeek();
        weekNumberLabel.setPadding(new Insets(5,0,0,0));
        weekNumberLabel.setStyle("-fx-font: 16 arial;");

        GridPane.setConstraints(hBoxForWeek,44,0);

        //Make sure the label has the fitting week
        int weeknumber = controller.getCurrentWeek().getWeekNumber();
        if(weeknumber < 10){
            weekNumberLabel.setText("Uge: 0" + Integer.toString(weeknumber));
        }else{
            weekNumberLabel.setText("Uge: " + Integer.toString(weeknumber));
        }

        EmployeeInTopMenu();

        this.getChildren().addAll(newAppointment, hBoxForWeek, hBoxForEmployees);
        this.setPadding(new Insets(20, 0, 20,10));
        this.setHgap((10));
        }

    /**
     * This method creates the button which has an action - create new appointment, in the topmenu
     */
    private void ButtonForNewAppointment(){
        newAppointment = new Button("+ Opret aftale");
        newAppointment.setPrefSize(120,30);
        newAppointment.setStyle("-fx-base: #9a6262;");
        GridPane.setConstraints(newAppointment, 0, 0);
        newAppointment.setOnAction(e -> controller.ShowNewAppointmentView());

    }

    /**
     * This method creates the labels for the different employees, in the topmenu
     */
    private void EmployeeInTopMenu(){

        hBoxForEmployees = new HBox();
        employee1 = new Label("Tommy");
        employee1.setPadding(new Insets(5,5,5,5));
        employee1.setStyle("-fx-background-color: #b6e7b9;");
        employee2 = new Label("Simone");
        employee2.setPadding(new Insets(5,5,5,5));
        employee2.setStyle("-fx-background-color: #C69BE8;");
        employee3 = new Label("Lise");
        employee3.setPadding(new Insets(5,5,5,5));
        employee3.setStyle("-fx-background-color: #9486d0;");
        employee4 = new Label("Cecilie");
        employee4.setPadding(new Insets(5,5,5,5));
        employee4.setStyle("-fx-background-color: #66bbd0;");
        hBoxForEmployees.getChildren().addAll(employee1,employee2,employee3,employee4);
        hBoxForEmployees.setSpacing(10);
        GridPane.setConstraints(hBoxForEmployees, 70,0);
    }

    //Getter
    public boolean isHboxForDayCreated() {
        return isHboxForDayCreated;
    }

    /**
     * This method creates the hbox which containts 2 buttons and a label for week
     * @return HBox - returns the created HBox
     */
    private HBox HBoxForWeek(){
            HBox hBox = new HBox();
            Button next = new Button(">");
            Button prev = new Button("<");
            next.setPrefSize(20,30);
            next.setStyle("-fx-base: #9a6262;");
            prev.setPrefSize(20,30);
            prev.setStyle("-fx-base: #9a6262;");

            hBox.setMinWidth(200);
            hBox.setMaxWidth(200);

            hBox.getChildren().addAll(prev,weekNumberLabel,next);

            hBox.setSpacing(10);


            prev.setOnAction(e -> {
                controller.PreviousWeek();
                if(controller.getCurrentWeek().getWeekNumber() < 10){
                    weekNumberLabel.setText("Uge: 0" + Integer.toString(controller.getCurrentWeek().getWeekNumber()));
                }
                else weekNumberLabel.setText("Uge: " + Integer.toString(controller.getCurrentWeek().getWeekNumber()));
            });


            next.setOnAction(e -> {
                controller.NextWeek();
                if(controller.getCurrentWeek().getWeekNumber() < 10){
                    weekNumberLabel.setText("Uge: 0" + Integer.toString(controller.getCurrentWeek().getWeekNumber()));
                }
                else weekNumberLabel.setText("Uge: " + Integer.toString(controller.getCurrentWeek().getWeekNumber()));
            });

            return hBox;

        }

    /**
     * This method creates the hbox which containts 2 buttons and a label for day
     * @return HBox - returns the created HBox
     */
    private HBox HBoxForDay(){
            HBox hBox = new HBox();
            hBox.setMinWidth(200);
            hBox.setMaxWidth(200);
            Button next = new Button(">");
            Button prev = new Button("<");
            next.setPrefSize(20,30);
            next.setStyle("-fx-base: #9a6262;");
            prev.setPrefSize(20,30);
            prev.setStyle("-fx-base: #9a6262;");
            dayLabel.setPadding(new Insets(5,0,0,0));
            dayLabel.setStyle("-fx-font: 16 arial;");

            dayLabel.setText(((DayView) ((CalendarView) controller.getCurrentScene()).getCenterMenu()).getDay().toString());


            next.setOnAction(e -> {
                controller.NextDay();
                dayLabel.setText(((DayView) ((CalendarView) controller.getCurrentScene()).getCenterMenu()).getDay().toString());
                if(controller.getCurrentWeek().getWeekNumber() < 10){
                    weekNumberLabel.setText("Uge: 0" + Integer.toString(controller.getCurrentWeek().getWeekNumber()));
                }
                else weekNumberLabel.setText("Uge: " + Integer.toString(controller.getCurrentWeek().getWeekNumber()));
            });

            prev.setOnAction(e -> {
                controller.PreviousDay();
                dayLabel.setText( ((DayView) ((CalendarView) controller.getCurrentScene()).getCenterMenu()).getDay().toString());
                if(controller.getCurrentWeek().getWeekNumber() < 10){
                    weekNumberLabel.setText("Uge: 0" + Integer.toString(controller.getCurrentWeek().getWeekNumber()));
                }
                else weekNumberLabel.setText("Uge: " + Integer.toString(controller.getCurrentWeek().getWeekNumber()));
            });
            hBox.setSpacing(10);

            hBox.getChildren().addAll(prev,dayLabel,weekNumberLabel,next);
            return hBox;
        }

    /**
     * This method calls the HBoxForDay method, to make sure that hBoxForDay is not null
     * This method is needed since the HBoxForDay method relies upon the centermenu being
     * an instance of dayview and therefore this method is public so it can be called
     * after the centermnu has been set to a dayview
     */
    public void createHBoxForDay(){
            hBoxForDay = HBoxForDay();
            GridPane.setConstraints(hBoxForDay,44,0);
            this.getChildren().add(hBoxForDay);
            isHboxForDayCreated = true;
        }

    /**
     * This method change the HBox in the topmenu to the hBoxForDay
     */
    public void ChangeHBoxToDay(){
        hBoxForDay.setVisible(true);
        hBoxForWeek.setVisible(false);
        if(!hBoxForDay.getChildren().contains(weekNumberLabel)){
            hBoxForDay.getChildren().add(2,weekNumberLabel);
        }
        dayLabel.setText(((DayView) ((CalendarView) controller.getCurrentScene()).getCenterMenu()).getDay().toString());
    }

    /**
     * This method change the HBox in the topmenu to the hBoxForWeek
     */
    public void ChangeHBoxToWeek(){
        hBoxForDay.setVisible(false);
        hBoxForWeek.setVisible(true);
        if(!hBoxForWeek.getChildren().contains(weekNumberLabel)){
            hBoxForWeek.getChildren().add(1,weekNumberLabel);
        }
    }
}
