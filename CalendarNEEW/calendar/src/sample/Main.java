package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import sample.Controller.Controller;
import sample.Model.DatabaseConnecter;
import sample.View.CalendarView;
import sample.View.ConfirmBox;


public class Main extends Application {

    Stage window;
    public enum Employee{
        Gry,Jessica
    }

    public static void main(String[] args)
    {
        launch(args);
    }


    public void start(Stage primaryStage) throws Exception{
        DatabaseConnecter.ConnectToDatabase();
        window = primaryStage;
        window.setTitle("Hairdresser");
        Controller controller = new Controller();
        Scene calendarViewScene = new CalendarView(new BorderPane(),2560,1440, controller);
        controller.setCurrentScene(calendarViewScene);
        controller.setCalendarViewScene((CalendarView) calendarViewScene);
        controller.LoadFromDatabase();
        window.setScene(calendarViewScene);
        window.show();
        //window.setOnCloseRequest(e -> closeProgram());
    }


    //How to react on close
    private void closeProgram(){
        boolean answer = ConfirmBox.display("Title", "Sure you want to exit?");
        if(answer==true){
            window.close();
        }
    }


    private void loadFromDatabase(){}
}
