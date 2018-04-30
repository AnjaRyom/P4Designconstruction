package IxD406.Profiles_med_fx.View;

import IxD406.Profiles_med_fx.Main;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CustomerView extends ProfileView {

    public CustomerView(Parent root, double width, double height) {
        super(root, width, height);
    }


    public static void display() {
        Stage customerDetails = new Stage();

        customerDetails.initModality(Modality.APPLICATION_MODAL);
        customerDetails.setTitle("Info om kunder");
        customerDetails.setMinWidth(250);

        GridPane layout = new GridPane();
        layout.setMinWidth(575);
        layout.setMinHeight(325);
        layout.getChildren().addAll();

        Label firstName = new Label();
        String firstNameOfCustomer = Main.customers.get(0).getFirstName();
        firstName.setText(firstNameOfCustomer);
        firstName.setPadding(new Insets(10));
        firstName.setStyle("-fx-font: 20 arial");

        Label lastName = new Label();
        String lastNameOfCustomer = Main.customers.get(0).getLastName();
        lastName.setText(lastNameOfCustomer);
        lastName.setStyle("-fx-font: 20 arial");

        Label text = new Label("Adresse");
        text.setPadding(new Insets(10));
        text.setTextFill(Color.web("Grey"));
        Label address = new Label();
        String addressOfCustomer = Main.customers.get(0).getAddress();
        address.setText(addressOfCustomer);
        address.setStyle("-fx-font: 12 arial");

        Label text1 = new Label("Telefonnummer");
        text1.setPadding(new Insets(10));
        text1.setTextFill(Color.web("Grey"));
        Label phoneNumber = new Label();
        int phoneNumberOfCustomer = Main.customers.get(0).getPhoneNumber();
        phoneNumber.setText(String.valueOf(phoneNumberOfCustomer));
        phoneNumber.setPadding(new Insets(10));
        phoneNumber.setStyle("-fx-font: 12 arial");

        Label text2 = new Label("Fødselsdag");
        text2.setPadding(new Insets(10));
        text2.setTextFill(Color.web("Grey"));
        Label dateOfBirth = new Label();
        int dateOfBirthOfCustomer = Main.customers.get(0).getDateOfBirth();
        dateOfBirth.setText(String.valueOf(dateOfBirthOfCustomer));
        dateOfBirth.setPadding(new Insets(10));
        dateOfBirth.setStyle("-fx-font: 12 arial");

        Label text3 = new Label("Køn");
        text3.setPadding(new Insets(10));
        text3.setTextFill(Color.web("Grey"));
        Label sex = new Label();
        String sexOfCustomer = Main.customers.get(0).getSex();
        sex.setText(sexOfCustomer);
        sex.setPadding(new Insets(10));
        sex.setStyle("-fx-font: 12 arial");

        Label text4 = new Label("Hårtype");
        text4.setPadding(new Insets(10));
        text4.setTextFill(Color.web("Grey"));
        Label hairtype = new Label();
        String hairtypeOfCustomer = Main.customers.get(0).getHairtype();
        hairtype.setText(hairtypeOfCustomer);
        hairtype.setPadding(new Insets(10));
        hairtype.setStyle("-fx-font: 12 arial");

        Label text5 = new Label("Købte produkter");
        text5.setPadding(new Insets(10));
        text5.setTextFill(Color.web("Grey"));
        Label purchasedProducts = new Label();
        String purchasedProductsOfCustomer = Main.customers.get(0).getPurchasedProducts();
        purchasedProducts.setText(purchasedProductsOfCustomer);
        purchasedProducts.setPadding(new Insets(10));
        purchasedProducts.setStyle("-fx-font: 12 arial");

        Label text6 = new Label("Beskrivelse");
        text6.setPadding(new Insets(10));
        text6.setTextFill(Color.web("Grey"));
        Label notes = new Label();
        String notesOfCustomer = Main.customers.get(0).getNotes();
        notes.setText(notesOfCustomer);
        notes.setPadding(new Insets(10));
        notes.setStyle("-fx-font: 12 arial");

        Button edit = new Button("Redigér");
        edit.setStyle("-fx-font: 12 arial");
        edit.setPadding(new Insets(10));


        Button delete = new Button("Slet");
        delete.setStyle("-fx-font: 12 arial");
        delete.setPadding(new Insets(10));



        GridPane.setConstraints(firstName, 0, 0);
        GridPane.setConstraints(lastName, 1, 0);
        GridPane.setConstraints(text, 0,1);
        GridPane.setConstraints(address, 1, 1);
        GridPane.setConstraints(text1, 0,2);
        GridPane.setConstraints(phoneNumber, 1, 2);
        GridPane.setConstraints(text2, 0,3);
        GridPane.setConstraints(dateOfBirth, 1, 3);
        GridPane.setConstraints(text3, 0,4);
        GridPane.setConstraints(sex, 1, 4);
        GridPane.setConstraints(text4, 0,5);
        GridPane.setConstraints(hairtype, 1, 5);
        GridPane.setConstraints(text5, 2,1);
        GridPane.setConstraints(purchasedProducts, 3, 1);
        GridPane.setConstraints(text6, 2,2);
        GridPane.setConstraints(notes, 3, 2);
        GridPane.setConstraints(edit, 2, 100);
        GridPane.setConstraints(delete, 8, 100);


        layout.getChildren().addAll(firstName, lastName, text, address, text1, phoneNumber, text2, dateOfBirth, text3, sex,
                text4, text5, hairtype, text6, purchasedProducts, notes, edit, delete);

        Scene scene = new Scene(layout);
        customerDetails.setScene(scene);
        customerDetails.show();
    }
}



