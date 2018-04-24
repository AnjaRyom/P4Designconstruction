package IxD406.calendar.View;


import IxD406.calendar.Controller.Controller;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.BorderPane;


/**
 * <h1>CalendarView</h1>
 * This class describes the calendar view
 * It extends from the scene class of javafx,
 * since it is considered as entire scene itself
 * It consist of LeftMenu, TopMenu and CenterMenu which are placed in a BorderPane
 */

public class CalendarView extends Scene{

    Controller controller;
    private double width;
    private double height;
    private WeekView weekView;
    LeftMenu leftMenu;
    TopMenu topMenu;
    CenterMenu centerMenu;
    ScrollPane scrollPane;

    private BorderPane border = new BorderPane();


    //The constructor for the calendar view
    public CalendarView(Parent root, double width, double height,Controller controller) {
        super(root,width,height);
        this.controller = controller;
        this.width = width;
        this.height = height;
        this.weekView = new WeekView(this.controller);
        this.controller.setWeekView(this.weekView);
        this.topMenu = new TopMenu(this.controller);
        this.leftMenu = new LeftMenu(this.controller);
        this.centerMenu = this.weekView;

        //Scrollpane for the view
        scrollPane = new ScrollPane();
        scrollPane.setContent(this.centerMenu);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.addEventFilter(ScrollEvent.SCROLL, new EventHandler<ScrollEvent>() {
            @Override
            public void handle(ScrollEvent event) {
                if (event.getDeltaX() != 0){
                    event.consume();
                }
            }
        });

        //Sets the background color for top-,center- and left menu
        topMenu.setStyle("-fx-background-color: #efefef;");
        centerMenu.setStyle("-fx-background-color: #efefef;");
        leftMenu.setStyle("-fx-background-color: #efefef;");

        border.setLeft(leftMenu);
        border.setTop(topMenu);
        border.setCenter(scrollPane);

        super.setRoot(border);
    }

    //Getters for calendar view
    public LeftMenu getLeftMenu() { return leftMenu; }
    public TopMenu getTopMenu() { return topMenu; }
    public CenterMenu getCenterMenu() { return centerMenu; }
    public void setCenterMenu(CenterMenu centerMenu) {
        scrollPane.setContent(centerMenu);
        this.centerMenu = centerMenu;
    }
    public BorderPane getBorder() { return border; }
    public WeekView getWeekView() { return weekView; }

}
