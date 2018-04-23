package sample.View;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import sample.Controller.Controller;
import sample.Model.Week;

import java.util.ArrayList;
import java.util.List;


/**
 * <h1> WeekView </h1>
 * This class describes a weekview
 * A weekview consist 5 dayviews
 */


public class WeekView extends CenterMenu {

    List<DayView> dayViews = new ArrayList<>();

    //Constructor for WeekView
    public WeekView(Controller controller) {
        super(controller);

        CreateColumns();
        CreateDayViews();
        CreateRows();

        //Label for weekdays
        Button monday = new Button("Mandag");
        monday.setPrefSize(455,20);
        monday.setStyle("-fx-font: 22 arial; -fx-base: #9a6262;");
        GridPane.setConstraints(monday, 0, 0);
        monday.setOnMouseClicked(e -> controller.ChangeToDayView(dayViews.get(0)));

        Button tuesday = new Button("Tirsdag");
        tuesday.setPrefSize(455,20);
        tuesday.setStyle("-fx-font: 22 arial; -fx-base: #9a6262;");
        GridPane.setConstraints(tuesday, 1, 0);
        tuesday.setOnMouseClicked(e -> controller.ChangeToDayView(dayViews.get(1)));

        Button wednesday = new Button("Onsdag");
        wednesday.setPrefSize(455,20);
        wednesday.setStyle("-fx-font: 22 arial; -fx-base: #9a6262;");
        GridPane.setConstraints(wednesday, 2, 0);
        wednesday.setOnMouseClicked(e -> controller.ChangeToDayView(dayViews.get(2)));

        Button thursday = new Button("Torsdag");
        thursday.setPrefSize(455,20);
        thursday.setStyle("-fx-font: 22 arial; -fx-base: #9a6262;");
        GridPane.setConstraints(thursday, 3, 0);
        thursday.setOnMouseClicked(e -> controller.ChangeToDayView(dayViews.get(3)));

        Button friday = new Button("Fredag");
        friday.setPrefSize(455,20);
        friday.setStyle("-fx-font: 22 arial; -fx-base: #9a6262;");
        GridPane.setConstraints(friday, 4, 0);
        friday.setOnMouseClicked(e -> controller.ChangeToDayView(dayViews.get(4)));

        this.setHgap(7);
        this.setPadding(new Insets(1.5,50,50,10));
        this.getChildren().addAll(monday, tuesday, wednesday, thursday, friday);
        this.setMaxWidth(1110);
        this.setMinWidth(1110);
    }

    //Getter
    public List<DayView> getDayViews() {
        return dayViews;
    }



    /**
     * This method creates columns for the calendar centerview
     * Those columns should contain the dayviews
     */
    public void CreateColumns(){

        for (int i = 0; i < 5; i++) {
            ColumnConstraints column = new ColumnConstraints();
            column.setPercentWidth(20);
            this.getColumnConstraints().add(column);
        }
    }

    /**
     * This method creates rows for the calendar centerview
     * Those rows should contain the dayviews
     */
    public void CreateRows(){
        RowConstraints labelRow = new RowConstraints(40);
        this.getRowConstraints().add(labelRow);
        RowConstraints buttonRow = new RowConstraints();
        buttonRow.setPercentHeight(100);
        this.getRowConstraints().add(buttonRow);


    }

    /**
     * This method creates the 5 dayviews which are displayed in the columns from the CreateColumns method
     */
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


    /**
     * This method calls the update of all dayviews
     * @param currentWeek Week - the week containing the elements that should be updated
     */
    public void UpdateCenterMenu(Week currentWeek){
        for (DayView day:dayViews)
        {
            day.ContractView();
            day.UpdateCenterMenu(currentWeek);
            if(!this.getChildren().contains(day)){
                this.getChildren().add(day);
            }
        }
    }

}
