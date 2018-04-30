<<<<<<< Updated upstream
package IxD406.Profiles_med_fx.View;

import IxD406.Profiles_med_fx.Main;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class EmployeeView extends ProfileView {

    public EmployeeView(Parent root, double width, double height) {
        super(root, width, height);
    }

    public static void display(VBox vBox) {
        Stage employeeDetails = new Stage();

        employeeDetails.initModality(Modality.APPLICATION_MODAL);
        employeeDetails.setTitle("This is a pop up window");
        employeeDetails.setMinWidth(250);

        GridPane layout = new GridPane();
        layout.setPadding(new Insets(250));
        layout.getChildren().addAll();

        Label firstname = new Label();
        String firstnameOfEmployee = Main.employees.get(0).getFirstName();
        firstname.setText(firstnameOfEmployee);

        Label lastname = new Label();
        String lastnameOfEmployee = Main.employees.get(0).getLastName();
        lastname.setText(lastnameOfEmployee);

        GridPane.setConstraints(firstname, 0, 0);
        GridPane.setConstraints(lastname, 6, 6);

        layout.getChildren().addAll(firstname, lastname);



        Scene scene = new Scene(layout);
        employeeDetails.setScene(scene);
        employeeDetails.show();
    }
}
=======
package IxD406.Profiles_med_fx.View;
import IxD406.Profiles_med_fx.Main;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class EmployeeView extends IxD406.Profiles_med_fx.View.ProfileView {

    public EmployeeView(Parent root, double width, double height) {
        super(root, width, height);
    }

    public static void display() {
        Stage employeeDetails = new Stage();

        employeeDetails.initModality(Modality.APPLICATION_MODAL);
        employeeDetails.setTitle("Info om medarbejder");
        employeeDetails.setMinWidth(250);

        GridPane layout = new GridPane();
        layout.setMinWidth(575);
        layout.setMinHeight(325);
        layout.getChildren().addAll();

        Label firstname = new Label();
        String firstnameOfEmployee = Main.employees.get(0).getFirstName();
        firstname.setText(firstnameOfEmployee);
        firstname.setPadding(new Insets(10));
        firstname.setStyle("-fx-font: 20 arial");

        Label lastname = new Label();
        String lastnameOfEmployee = Main.employees.get(0).getLastName();
        lastname.setText(lastnameOfEmployee);
        lastname.setStyle("-fx-font: 20 arial");

        Label text = new Label("Adresse");
        text.setPadding(new Insets(10));
        text.setTextFill(Color.web("Grey"));
        Label address = new Label();
        String addressOfEmployee = Main.employees.get(0).getAddress();
        address.setText(addressOfEmployee);
        address.setStyle("-fx-font: 12 arial");

        Label text1 = new Label("Telefonnummer");
        text1.setPadding(new Insets(10));
        text1.setTextFill(Color.web("Grey"));
        Label phonenumber = new Label();
        int phonenumberOfEmployee = Main.employees.get(0).getPhoneNumber();
        phonenumber.setText(String.valueOf(phonenumberOfEmployee));
        phonenumber.setPadding(new Insets(10));
        phonenumber.setStyle("-fx-font: 12 arial");

        Label text2 = new Label("Fødselsdag");
        text2.setPadding(new Insets(10));
        text2.setTextFill(Color.web("Grey"));
        Label dateOfBirth = new Label();
        int dateOfBirthOfEmployee = Main.employees.get(0).getDateOfBirth();
        dateOfBirth.setText(String.valueOf(dateOfBirthOfEmployee));
        dateOfBirth.setPadding(new Insets(10));
        dateOfBirth.setStyle("-fx-font: 12 arial");

        Label text3 = new Label("Køn");
        text3.setPadding(new Insets(10));
        text3.setTextFill(Color.web("Grey"));
        Label sex = new Label();
        String sexOfEmployee = Main.employees.get(0).getSex();
        sex.setText(sexOfEmployee);
        sex.setPadding(new Insets(10));
        sex.setStyle("-fx-font: 12 arial");

        Label text4 = new Label("Basispris");
        text4.setPadding(new Insets(10));
        text4.setTextFill(Color.web("Grey"));
        Label baseprice = new Label();
        double basepriceOfEmployee = Main.employees.get(0).getBasePrice();
        baseprice.setText(String.valueOf(basepriceOfEmployee));
        baseprice.setPadding(new Insets(10));
        baseprice.setStyle("-fx-font: 12 arial");

        Label text5 = new Label("Erfaring antal år");
        text5.setPadding(new Insets(10));
        text5.setTextFill(Color.web("Grey"));
        Label experienceYears = new Label();
        int experinnceYearsEmployee = Main.employees.get(0).getExperienceYears();
        experienceYears.setText(String.valueOf(experinnceYearsEmployee));
        experienceYears.setPadding(new Insets(10));
        experienceYears.setStyle("-fx-font: 12 arial");

        Label text6 = new Label("Erfaring antal måneder");
        text6.setPadding(new Insets(10));
        text6.setTextFill(Color.web("Grey"));
        Label experienceMonths = new Label();
        int experienceMonthsEmployee = Main.employees.get(0).getExperienceMonths();
        experienceMonths.setText(String.valueOf(experienceMonthsEmployee));
        experienceMonths.setPadding(new Insets(10));
        experienceMonths.setStyle("-fx-font: 12 arial");

        Label text7 = new Label("Beskrivelse");
        text7.setTextFill(Color.web("Grey"));
        Label discription = new Label();
        String discriptionEmployee = Main.employees.get(0).getDescription();
        discription.setText(discriptionEmployee);
        TextField textfield = new TextField();
        Button gem = new Button("Gem info");
        gem.setStyle("-fx-font: 12 arial");

        Label text8 = new Label("Anbefalinger");
        text8.setPadding(new Insets(10));
        text8.setTextFill(Color.web("Grey"));
        Label recommendations = new Label();
        String recommendationEmployee = Main.employees.get(0).getDescription();
        recommendations.setText(recommendationEmployee);
        recommendations.setPadding(new Insets(10));
        recommendations.setStyle("-fx-font: 12 arial");

        Label text9 = new Label("Antal feriedage");
        text9.setPadding(new Insets(10));
        text9.setTextFill(Color.web("Grey"));
        Label holidaysAmount = new Label();
        int holidaysEmployee = Main.employees.get(0).getHolidayDaysAmount();
        holidaysAmount.setText(String.valueOf(holidaysEmployee));
        holidaysAmount.setPadding(new Insets(10));
        holidaysAmount.setStyle("-fx-font: 12 arial");

        Label text10 = new Label("Antal sygedage");
        text10.setPadding(new Insets(10));
        text10.setTextFill(Color.web("Grey"));
        Label sicknessAmount = new Label();
        int sicknessEmployee = Main.employees.get(0).getSicknessDaysAmount();
        sicknessAmount.setText(String.valueOf(sicknessEmployee));
        sicknessAmount.setPadding(new Insets(10));
        sicknessAmount.setStyle("-fx-font: 12 arial");

        VBox picture = new VBox();
        picture.getChildren().add(CreateVBoxWithImage("C:\\Users\\Anja\\Desktop\\Billeder\\Tommy.png"));

        GridPane.setConstraints(firstname, 0, 0);
        GridPane.setConstraints(lastname, 1, 0);
        GridPane.setConstraints(text, 0,1);
        GridPane.setConstraints(address, 1, 1);
        GridPane.setConstraints(text1, 0,2);
        GridPane.setConstraints(phonenumber, 1, 2);
        GridPane.setConstraints(text2, 0,3);
        GridPane.setConstraints(dateOfBirth, 1, 3);
        GridPane.setConstraints(text3, 0,4);
        GridPane.setConstraints(sex, 1, 4);
        GridPane.setConstraints(text4, 0,5);
        GridPane.setConstraints(baseprice, 1, 5);
        GridPane.setConstraints(text5, 2,1);
        GridPane.setConstraints(experienceYears, 3, 1);
        GridPane.setConstraints(text6, 2,2);
        GridPane.setConstraints(experienceMonths, 3, 2);
        GridPane.setConstraints(text7, 6,1);
        GridPane.setConstraints(discription, 6, 2);
        GridPane.setConstraints(textfield, 6,2);
        GridPane.setConstraints(gem, 6,3);
        GridPane.setConstraints(text8, 2,5);
        GridPane.setConstraints(recommendations, 3, 5);
        GridPane.setConstraints(text9,2,3);
        GridPane.setConstraints(holidaysAmount, 3, 3);
        GridPane.setConstraints(text10,2,4);
        GridPane.setConstraints(sicknessAmount, 3, 4);
        GridPane.setConstraints(picture, 6,0);


        layout.getChildren().addAll(firstname, lastname, text, address, text1, phonenumber, text2, dateOfBirth, text3, sex,
                text4, text5, baseprice, text6, experienceYears, experienceMonths, text7, discription, textfield, gem,
                text8, recommendations, text9, holidaysAmount, text10, sicknessAmount, picture);


        Scene scene = new Scene(layout);
        employeeDetails.setScene(scene);
        employeeDetails.show();
    }

}

class EmployeeViewOne extends IxD406.Profiles_med_fx.View.ProfileView {

    public EmployeeViewOne(Parent root, double width, double height) {
        super(root, width, height);
    }

    public static void displayOne() {
        Stage employeeDetails = new Stage();

        employeeDetails.initModality(Modality.APPLICATION_MODAL);
        employeeDetails.setTitle("Info om medarbejder");
        employeeDetails.setMinWidth(250);

        GridPane layout = new GridPane();
        layout.setMinWidth(575);
        layout.setMinHeight(325);
        layout.getChildren().addAll();

        Label firstname = new Label();
        String firstnameOfEmployee = Main.employees.get(1).getFirstName();
        firstname.setText(firstnameOfEmployee);
        firstname.setPadding(new Insets(10));
        firstname.setStyle("-fx-font: 20 arial");

        Label lastname = new Label();
        String lastnameOfEmployee = Main.employees.get(1).getLastName();
        lastname.setText(lastnameOfEmployee);
        lastname.setStyle("-fx-font: 20 arial");

        Label text = new Label("Adresse");
        text.setPadding(new Insets(10));
        text.setTextFill(Color.web("Grey"));
        Label address = new Label();
        String addressOfEmployee = Main.employees.get(1).getAddress();
        address.setText(addressOfEmployee);
        address.setStyle("-fx-font: 12 arial");

        Label text1 = new Label("Telefonnummer");
        text1.setPadding(new Insets(10));
        text1.setTextFill(Color.web("Grey"));
        Label phonenumber = new Label();
        int phonenumberOfEmployee = Main.employees.get(1).getPhoneNumber();
        phonenumber.setText(String.valueOf(phonenumberOfEmployee));
        phonenumber.setPadding(new Insets(10));
        phonenumber.setStyle("-fx-font: 12 arial");

        Label text2 = new Label("Fødselsdag");
        text2.setPadding(new Insets(10));
        text2.setTextFill(Color.web("Grey"));
        Label dateOfBirth = new Label();
        int dateOfBirthOfEmployee = Main.employees.get(1).getDateOfBirth();
        dateOfBirth.setText(String.valueOf(dateOfBirthOfEmployee));
        dateOfBirth.setPadding(new Insets(10));
        dateOfBirth.setStyle("-fx-font: 12 arial");

        Label text3 = new Label("Køn");
        text3.setPadding(new Insets(10));
        text3.setTextFill(Color.web("Grey"));
        Label sex = new Label();
        String sexOfEmployee = Main.employees.get(1).getSex();
        sex.setText(sexOfEmployee);
        sex.setPadding(new Insets(10));
        sex.setStyle("-fx-font: 12 arial");

        Label text4 = new Label("Basispris");
        text4.setPadding(new Insets(10));
        text4.setTextFill(Color.web("Grey"));
        Label baseprice = new Label();
        double basepriceOfEmployee = Main.employees.get(1).getBasePrice();
        baseprice.setText(String.valueOf(basepriceOfEmployee));
        baseprice.setPadding(new Insets(10));
        baseprice.setStyle("-fx-font: 12 arial");

        Label text5 = new Label("Erfaring antal år");
        text5.setPadding(new Insets(10));
        text5.setTextFill(Color.web("Grey"));
        Label experienceYears = new Label();
        int experinnceYearsEmployee = Main.employees.get(1).getExperienceYears();
        experienceYears.setText(String.valueOf(experinnceYearsEmployee));
        experienceYears.setPadding(new Insets(10));
        experienceYears.setStyle("-fx-font: 12 arial");

        Label text6 = new Label("Erfaring antal måneder");
        text6.setPadding(new Insets(10));
        text6.setTextFill(Color.web("Grey"));
        Label experienceMonths = new Label();
        int experienceMonthsEmployee = Main.employees.get(1).getExperienceMonths();
        experienceMonths.setText(String.valueOf(experienceMonthsEmployee));
        experienceMonths.setPadding(new Insets(10));
        experienceMonths.setStyle("-fx-font: 12 arial");

        Label text7 = new Label("Beskrivelse");
        text7.setTextFill(Color.web("Grey"));
        Label discription = new Label();
        String discriptionEmployee = Main.employees.get(1).getDescription();
        discription.setText(discriptionEmployee);
        TextField textfield = new TextField();
        Button gem = new Button("Gem info");
        gem.setStyle("-fx-font: 12 arial");

        Label text8 = new Label("Anbefalinger");
        text8.setPadding(new Insets(10));
        text8.setTextFill(Color.web("Grey"));
        Label recommendations = new Label();
        String recommendationEmployee = Main.employees.get(1).getDescription();
        recommendations.setText(recommendationEmployee);
        recommendations.setPadding(new Insets(10));
        recommendations.setStyle("-fx-font: 12 arial");

        Label text9 = new Label("Antal feriedage");
        text9.setPadding(new Insets(10));
        text9.setTextFill(Color.web("Grey"));
        Label holidaysAmount = new Label();
        int holidaysEmployee = Main.employees.get(1).getHolidayDaysAmount();
        holidaysAmount.setText(String.valueOf(holidaysEmployee));
        holidaysAmount.setPadding(new Insets(10));
        holidaysAmount.setStyle("-fx-font: 12 arial");

        Label text10 = new Label("Antal sygedage");
        text10.setPadding(new Insets(10));
        text10.setTextFill(Color.web("Grey"));
        Label sicknessAmount = new Label();
        int sicknessEmployee = Main.employees.get(1).getSicknessDaysAmount();
        sicknessAmount.setText(String.valueOf(sicknessEmployee));
        sicknessAmount.setPadding(new Insets(10));
        sicknessAmount.setStyle("-fx-font: 12 arial");

        VBox picture = new VBox();
        picture.getChildren().add(CreateVBoxWithImage("C:\\Users\\Anja\\Desktop\\Billeder\\Simone.png"));

        GridPane.setConstraints(firstname, 0, 0);
        GridPane.setConstraints(lastname, 1, 0);
        GridPane.setConstraints(text, 0,1);
        GridPane.setConstraints(address, 1, 1);
        GridPane.setConstraints(text1, 0,2);
        GridPane.setConstraints(phonenumber, 1, 2);
        GridPane.setConstraints(text2, 0,3);
        GridPane.setConstraints(dateOfBirth, 1, 3);
        GridPane.setConstraints(text3, 0,4);
        GridPane.setConstraints(sex, 1, 4);
        GridPane.setConstraints(text4, 0,5);
        GridPane.setConstraints(baseprice, 1, 5);
        GridPane.setConstraints(text5, 2,1);
        GridPane.setConstraints(experienceYears, 3, 1);
        GridPane.setConstraints(text6, 2,2);
        GridPane.setConstraints(experienceMonths, 3, 2);
        GridPane.setConstraints(text7, 6,1);
        GridPane.setConstraints(discription, 6, 2);
        GridPane.setConstraints(textfield, 6,2);
        GridPane.setConstraints(gem, 6,3);
        GridPane.setConstraints(text8, 2,5);
        GridPane.setConstraints(recommendations, 3, 5);
        GridPane.setConstraints(text9,2,3);
        GridPane.setConstraints(holidaysAmount, 3, 3);
        GridPane.setConstraints(text10,2,4);
        GridPane.setConstraints(sicknessAmount, 3, 4);
        GridPane.setConstraints(picture, 6,0);


        layout.getChildren().addAll(firstname, lastname, text, address, text1, phonenumber, text2, dateOfBirth, text3, sex,
                text4, text5, baseprice, text6, experienceYears, experienceMonths, text7, discription, textfield, gem,
                text8, recommendations, text9, holidaysAmount, text10, sicknessAmount, picture);


        Scene scene = new Scene(layout);
        employeeDetails.setScene(scene);
        employeeDetails.show();
    }
}

class EmployeeViewTwo extends IxD406.Profiles_med_fx.View.ProfileView {

    public EmployeeViewTwo(Parent root, double width, double height) {
        super(root, width, height);
    }

    public static void displayTwo() {
        Stage employeeDetails = new Stage();

        employeeDetails.initModality(Modality.APPLICATION_MODAL);
        employeeDetails.setTitle("Info om medarbejder");
        employeeDetails.setMinWidth(250);

        GridPane layout = new GridPane();
        layout.setMinWidth(575);
        layout.setMinHeight(325);
        layout.getChildren().addAll();

        Label firstname = new Label();
        String firstnameOfEmployee = Main.employees.get(2).getFirstName();
        firstname.setText(firstnameOfEmployee);
        firstname.setPadding(new Insets(10));
        firstname.setStyle("-fx-font: 20 arial");

        Label lastname = new Label();
        String lastnameOfEmployee = Main.employees.get(2).getLastName();
        lastname.setText(lastnameOfEmployee);
        lastname.setStyle("-fx-font: 20 arial");

        Label text = new Label("Adresse");
        text.setPadding(new Insets(10));
        text.setTextFill(Color.web("Grey"));
        Label address = new Label();
        String addressOfEmployee = Main.employees.get(2).getAddress();
        address.setText(addressOfEmployee);
        address.setStyle("-fx-font: 12 arial");

        Label text1 = new Label("Telefonnummer");
        text1.setPadding(new Insets(10));
        text1.setTextFill(Color.web("Grey"));
        Label phonenumber = new Label();
        int phonenumberOfEmployee = Main.employees.get(2).getPhoneNumber();
        phonenumber.setText(String.valueOf(phonenumberOfEmployee));
        phonenumber.setPadding(new Insets(10));
        phonenumber.setStyle("-fx-font: 12 arial");

        Label text2 = new Label("Fødselsdag");
        text2.setPadding(new Insets(10));
        text2.setTextFill(Color.web("Grey"));
        Label dateOfBirth = new Label();
        int dateOfBirthOfEmployee = Main.employees.get(2).getDateOfBirth();
        dateOfBirth.setText(String.valueOf(dateOfBirthOfEmployee));
        dateOfBirth.setPadding(new Insets(10));
        dateOfBirth.setStyle("-fx-font: 12 arial");

        Label text3 = new Label("Køn");
        text3.setPadding(new Insets(10));
        text3.setTextFill(Color.web("Grey"));
        Label sex = new Label();
        String sexOfEmployee = Main.employees.get(2).getSex();
        sex.setText(sexOfEmployee);
        sex.setPadding(new Insets(10));
        sex.setStyle("-fx-font: 12 arial");

        Label text4 = new Label("Basispris");
        text4.setPadding(new Insets(10));
        text4.setTextFill(Color.web("Grey"));
        Label baseprice = new Label();
        double basepriceOfEmployee = Main.employees.get(2).getBasePrice();
        baseprice.setText(String.valueOf(basepriceOfEmployee));
        baseprice.setPadding(new Insets(10));
        baseprice.setStyle("-fx-font: 12 arial");

        Label text5 = new Label("Erfaring antal år");
        text5.setPadding(new Insets(10));
        text5.setTextFill(Color.web("Grey"));
        Label experienceYears = new Label();
        int experinnceYearsEmployee = Main.employees.get(2).getExperienceYears();
        experienceYears.setText(String.valueOf(experinnceYearsEmployee));
        experienceYears.setPadding(new Insets(10));
        experienceYears.setStyle("-fx-font: 12 arial");

        Label text6 = new Label("Erfaring antal måneder");
        text6.setPadding(new Insets(10));
        text6.setTextFill(Color.web("Grey"));
        Label experienceMonths = new Label();
        int experienceMonthsEmployee = Main.employees.get(2).getExperienceMonths();
        experienceMonths.setText(String.valueOf(experienceMonthsEmployee));
        experienceMonths.setPadding(new Insets(10));
        experienceMonths.setStyle("-fx-font: 12 arial");

        Label text7 = new Label("Beskrivelse");
        text7.setTextFill(Color.web("Grey"));
        Label discription = new Label();
        String discriptionEmployee = Main.employees.get(2).getDescription();
        discription.setText(discriptionEmployee);
        TextField textfield = new TextField();
        Button gem = new Button("Gem info");
        gem.setStyle("-fx-font: 12 arial");

        Label text8 = new Label("Anbefalinger");
        text8.setPadding(new Insets(10));
        text8.setTextFill(Color.web("Grey"));
        Label recommendations = new Label();
        String recommendationEmployee = Main.employees.get(2).getDescription();
        recommendations.setText(recommendationEmployee);
        recommendations.setPadding(new Insets(10));
        recommendations.setStyle("-fx-font: 12 arial");

        Label text9 = new Label("Antal feriedage");
        text9.setPadding(new Insets(10));
        text9.setTextFill(Color.web("Grey"));
        Label holidaysAmount = new Label();
        int holidaysEmployee = Main.employees.get(2).getHolidayDaysAmount();
        holidaysAmount.setText(String.valueOf(holidaysEmployee));
        holidaysAmount.setPadding(new Insets(10));
        holidaysAmount.setStyle("-fx-font: 12 arial");

        Label text10 = new Label("Antal sygedage");
        text10.setPadding(new Insets(10));
        text10.setTextFill(Color.web("Grey"));
        Label sicknessAmount = new Label();
        int sicknessEmployee = Main.employees.get(2).getSicknessDaysAmount();
        sicknessAmount.setText(String.valueOf(sicknessEmployee));
        sicknessAmount.setPadding(new Insets(10));
        sicknessAmount.setStyle("-fx-font: 12 arial");

        VBox picture = new VBox();
        picture.getChildren().add(CreateVBoxWithImage("C:\\Users\\Anja\\Desktop\\Billeder\\Lise.png"));

        GridPane.setConstraints(firstname, 0, 0);
        GridPane.setConstraints(lastname, 1, 0);
        GridPane.setConstraints(text, 0,1);
        GridPane.setConstraints(address, 1, 1);
        GridPane.setConstraints(text1, 0,2);
        GridPane.setConstraints(phonenumber, 1, 2);
        GridPane.setConstraints(text2, 0,3);
        GridPane.setConstraints(dateOfBirth, 1, 3);
        GridPane.setConstraints(text3, 0,4);
        GridPane.setConstraints(sex, 1, 4);
        GridPane.setConstraints(text4, 0,5);
        GridPane.setConstraints(baseprice, 1, 5);
        GridPane.setConstraints(text5, 2,1);
        GridPane.setConstraints(experienceYears, 3, 1);
        GridPane.setConstraints(text6, 2,2);
        GridPane.setConstraints(experienceMonths, 3, 2);
        GridPane.setConstraints(text7, 6,1);
        GridPane.setConstraints(discription, 6, 2);
        GridPane.setConstraints(textfield, 6,2);
        GridPane.setConstraints(gem, 6,3);
        GridPane.setConstraints(text8, 2,5);
        GridPane.setConstraints(recommendations, 3, 5);
        GridPane.setConstraints(text9,2,3);
        GridPane.setConstraints(holidaysAmount, 3, 3);
        GridPane.setConstraints(text10,2,4);
        GridPane.setConstraints(sicknessAmount, 3, 4);
        GridPane.setConstraints(picture, 6,0);


        layout.getChildren().addAll(firstname, lastname, text, address, text1, phonenumber, text2, dateOfBirth, text3, sex,
                text4, text5, baseprice, text6, experienceYears, experienceMonths, text7, discription, textfield, gem,
                text8, recommendations, text9, holidaysAmount, text10, sicknessAmount, picture);


        Scene scene = new Scene(layout);
        employeeDetails.setScene(scene);
        employeeDetails.show();
    }
}


class EmployeeViewThree extends IxD406.Profiles_med_fx.View.ProfileView {

    public EmployeeViewThree(Parent root, double width, double height) {
        super(root, width, height);
    }

    public static void displayThree() {
        Stage employeeDetails = new Stage();

        employeeDetails.initModality(Modality.APPLICATION_MODAL);
        employeeDetails.setTitle("Info om medarbejder");
        employeeDetails.setMinWidth(250);

        GridPane layout = new GridPane();
        layout.setMinWidth(575);
        layout.setMinHeight(325);
        layout.getChildren().addAll();

        Label firstname = new Label();
        String firstnameOfEmployee = Main.employees.get(3).getFirstName();
        firstname.setText(firstnameOfEmployee);
        firstname.setPadding(new Insets(10));
        firstname.setStyle("-fx-font: 20 arial");

        Label lastname = new Label();
        String lastnameOfEmployee = Main.employees.get(3).getLastName();
        lastname.setText(lastnameOfEmployee);
        lastname.setStyle("-fx-font: 20 arial");

        Label text = new Label("Adresse");
        text.setPadding(new Insets(10));
        text.setTextFill(Color.web("Grey"));
        Label address = new Label();
        String addressOfEmployee = Main.employees.get(3).getAddress();
        address.setText(addressOfEmployee);
        address.setStyle("-fx-font: 12 arial");

        Label text1 = new Label("Telefonnummer");
        text1.setPadding(new Insets(10));
        text1.setTextFill(Color.web("Grey"));
        Label phonenumber = new Label();
        int phonenumberOfEmployee = Main.employees.get(3).getPhoneNumber();
        phonenumber.setText(String.valueOf(phonenumberOfEmployee));
        phonenumber.setPadding(new Insets(10));
        phonenumber.setStyle("-fx-font: 12 arial");

        Label text2 = new Label("Fødselsdag");
        text2.setPadding(new Insets(10));
        text2.setTextFill(Color.web("Grey"));
        Label dateOfBirth = new Label();
        int dateOfBirthOfEmployee = Main.employees.get(3).getDateOfBirth();
        dateOfBirth.setText(String.valueOf(dateOfBirthOfEmployee));
        dateOfBirth.setPadding(new Insets(10));
        dateOfBirth.setStyle("-fx-font: 12 arial");

        Label text3 = new Label("Køn");
        text3.setPadding(new Insets(10));
        text3.setTextFill(Color.web("Grey"));
        Label sex = new Label();
        String sexOfEmployee = Main.employees.get(3).getSex();
        sex.setText(sexOfEmployee);
        sex.setPadding(new Insets(10));
        sex.setStyle("-fx-font: 12 arial");

        Label text4 = new Label("Basispris");
        text4.setPadding(new Insets(10));
        text4.setTextFill(Color.web("Grey"));
        Label baseprice = new Label();
        double basepriceOfEmployee = Main.employees.get(3).getBasePrice();
        baseprice.setText(String.valueOf(basepriceOfEmployee));
        baseprice.setPadding(new Insets(10));
        baseprice.setStyle("-fx-font: 12 arial");

        Label text5 = new Label("Erfaring antal år");
        text5.setPadding(new Insets(10));
        text5.setTextFill(Color.web("Grey"));
        Label experienceYears = new Label();
        int experinnceYearsEmployee = Main.employees.get(3).getExperienceYears();
        experienceYears.setText(String.valueOf(experinnceYearsEmployee));
        experienceYears.setPadding(new Insets(10));
        experienceYears.setStyle("-fx-font: 12 arial");

        Label text6 = new Label("Erfaring antal måneder");
        text6.setPadding(new Insets(10));
        text6.setTextFill(Color.web("Grey"));
        Label experienceMonths = new Label();
        int experienceMonthsEmployee = Main.employees.get(3).getExperienceMonths();
        experienceMonths.setText(String.valueOf(experienceMonthsEmployee));
        experienceMonths.setPadding(new Insets(10));
        experienceMonths.setStyle("-fx-font: 12 arial");

        //Funktionaliteten hertil skal implementeres! Der sker intet når man trykker på gem info
        Label text7 = new Label("Beskrivelse");
        text7.setTextFill(Color.web("Grey"));
        Label discription = new Label();
        String discriptionEmployee = Main.employees.get(3).getDescription();
        discription.setText(discriptionEmployee);
        TextField textfield = new TextField();
        Button gem = new Button("Gem info");
        gem.setStyle("-fx-font: 12 arial");

        Label text8 = new Label("Anbefalinger");
        text8.setPadding(new Insets(10));
        text8.setTextFill(Color.web("Grey"));
        Label recommendations = new Label();
        String recommendationEmployee = Main.employees.get(3).getDescription();
        recommendations.setText(recommendationEmployee);
        recommendations.setPadding(new Insets(10));
        recommendations.setStyle("-fx-font: 12 arial");

        Label text9 = new Label("Antal feriedage");
        text9.setPadding(new Insets(10));
        text9.setTextFill(Color.web("Grey"));
        Label holidaysAmount = new Label();
        int holidaysEmployee = Main.employees.get(3).getHolidayDaysAmount();
        holidaysAmount.setText(String.valueOf(holidaysEmployee));
        holidaysAmount.setPadding(new Insets(10));
        holidaysAmount.setStyle("-fx-font: 12 arial");

        Label text10 = new Label("Antal sygedage");
        text10.setPadding(new Insets(10));
        text10.setTextFill(Color.web("Grey"));
        Label sicknessAmount = new Label();
        int sicknessEmployee = Main.employees.get(3).getSicknessDaysAmount();
        sicknessAmount.setText(String.valueOf(sicknessEmployee));
        sicknessAmount.setPadding(new Insets(10));
        sicknessAmount.setStyle("-fx-font: 12 arial");

        VBox picture = new VBox();
        picture.getChildren().add(CreateVBoxWithImage("C:\\Users\\Anja\\Desktop\\Billeder\\Cecilie.png"));

        GridPane.setConstraints(firstname, 0, 0);
        GridPane.setConstraints(lastname, 1, 0);
        GridPane.setConstraints(text, 0,1);
        GridPane.setConstraints(address, 1, 1);
        GridPane.setConstraints(text1, 0,2);
        GridPane.setConstraints(phonenumber, 1, 2);
        GridPane.setConstraints(text2, 0,3);
        GridPane.setConstraints(dateOfBirth, 1, 3);
        GridPane.setConstraints(text3, 0,4);
        GridPane.setConstraints(sex, 1, 4);
        GridPane.setConstraints(text4, 0,5);
        GridPane.setConstraints(baseprice, 1, 5);
        GridPane.setConstraints(text5, 2,1);
        GridPane.setConstraints(experienceYears, 3, 1);
        GridPane.setConstraints(text6, 2,2);
        GridPane.setConstraints(experienceMonths, 3, 2);
        GridPane.setConstraints(text7, 6,1);
        GridPane.setConstraints(discription, 6, 2);
        GridPane.setConstraints(textfield, 6,2);
        GridPane.setConstraints(gem, 6,3);
        GridPane.setConstraints(text8, 2,5);
        GridPane.setConstraints(recommendations, 3, 5);
        GridPane.setConstraints(text9,2,3);
        GridPane.setConstraints(holidaysAmount, 3, 3);
        GridPane.setConstraints(text10,2,4);
        GridPane.setConstraints(sicknessAmount, 3, 4);
        GridPane.setConstraints(picture, 6,0);


        layout.getChildren().addAll(firstname, lastname, text, address, text1, phonenumber, text2, dateOfBirth, text3, sex,
                text4, text5, baseprice, text6, experienceYears, experienceMonths, text7, discription, textfield, gem,
                text8, recommendations, text9, holidaysAmount, text10, sicknessAmount, picture);


        Scene scene = new Scene(layout);
        employeeDetails.setScene(scene);
        employeeDetails.show();
    }
}

>>>>>>> Stashed changes
