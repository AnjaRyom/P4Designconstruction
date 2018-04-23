package sample.View;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import sample.Controller.Controller;

import java.io.File;

/**
 * <h1> LeftMenu </h1>
 * This class describes the leftmenu for the whole application
 * The menu is a VBox and extends from VBox
 * The leftmenu consist of four buttons
 * The buttons is also Vboxes
 */


public class LeftMenu extends VBox{

    Controller controller;



    //Constructor for leftmenu
    public LeftMenu(Controller controller) {

        Button calendarButton = CreateButtonsWithIcons("/Users/gryegelundpetersen/desktop/kalender1.png", "Kalender");
        calendarButton.setOnAction(e-> controller.changeToWeekView(controller.getWeekView()));

        Button inventoryButton = CreateButtonsWithIcons("/Users/gryegelundpetersen/desktop/inventory1.png", "Lager");

        Button cashOutButton = CreateButtonsWithIcons("/Users/gryegelundpetersen/desktop/cashout1.png", "Kassen");

        Button profilesButton = CreateButtonsWithIcons("/Users/gryegelundpetersen/desktop/profiles1.png", "Profiler");

        this.controller = controller;
        this.getChildren().addAll(calendarButton, inventoryButton, cashOutButton, profilesButton);
        this.setMinWidth(200); //Sets min. width for leftmenu
        this.setMaxWidth(200);
    }

    /**
     * This method creates buttons with a pathname (for the image) and a labelname (for the label in the button)
     * @param pathname String - the path of the image
     * @param labelName String - the label of the button
     * @return Button -
     */
    private Button CreateButtonsWithIcons(String pathname, String labelName){

        VBox vboxForButton = new VBox();
        Label labelForButton = new Label(labelName);
        File file = new File(pathname);
        String localURL = file.toURI().toString();

        vboxForButton.getChildren().add(new ImageView(localURL));
        vboxForButton.getChildren().add(labelForButton);
        vboxForButton.setAlignment(Pos.CENTER);

        Button newButton = new Button();
        newButton.setGraphic(vboxForButton);

        vboxForButton.setSpacing(10);

        labelForButton.setTextFill(Color.web("#ffffff"));
        newButton.setStyle("-fx-font: 22 arial; -fx-base: #9a6262;");

        newButton.setOnMouseEntered(e -> labelForButton.setTextFill(Color.web("#000000")));
        newButton.setOnMouseExited(e -> labelForButton.setTextFill(Color.web("#ffffff")));

        newButton.setPrefSize(200,160.5);

        return newButton;
    }

}
