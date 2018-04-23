package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import sample.Controller.Controller;
import sample.Model.DatabaseConnecter;
import sample.Model.Employee;
import sample.Model.Service;
import sample.View.CalendarView;
import sample.View.ConfirmBox;

import java.util.ArrayList;
import java.util.List;


public class Main extends Application {

    Stage window;

    public static Service service1 = new Service("Hårklipning dame", 300);
    public static Service service2 = new Service("Hårklipning mand", 300);
    public static Service service3 = new Service("Hårfarvning lang", 1200);
    public static Service service4 = new Service("Hårfarvning kort", 600);


    public static List<Employee> employees = new ArrayList<>();
    public static List<Service> listOfServices = new ArrayList<>();

    public static void main(String[] args)
    {
        launch(args);
    }


    public void start(Stage primaryStage) throws Exception{
        DatabaseConnecter.ConnectToDatabase();

        listOfServices.add(service1);
        listOfServices.add(service2);
        listOfServices.add(service3);
        listOfServices.add(service4);

        employees.add(new Employee("Tommy"));
        employees.add(new Employee("Simone"));
        employees.add(new Employee("Lise"));
        employees.add(new Employee("Cecilie"));

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
