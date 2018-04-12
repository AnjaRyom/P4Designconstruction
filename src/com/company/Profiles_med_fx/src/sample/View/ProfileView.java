package sample.View;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

/* This class describes the Profileview which is a scene*/

public class ProfileView extends Scene{

// Initializing the layout of the scene and the top, left and center menu

    BorderPane layout = new BorderPane();
    CenterMenu centerMenu = new CenterMenu();
    LeftMenu leftMenu = new LeftMenu();
    TopMenu topMenu = new TopMenu();


// Constructer of class, which currently makes buttons and inserts them the right places

    public ProfileView(Parent root, double width, double height) {
        super(root, width, height);

        Button clickMe = new Button("Click me");

// Set on action to button (reaction) which is made by a lambda expression

        clickMe.setOnAction(e-> {
            clickMe.setText("Noooo u clicked");
        });

        Button topButton = new Button ("Sej");


// We're placing our menus on specific places in BorderPane

        layout.setCenter(centerMenu);
        layout.setLeft(leftMenu);
        layout.setTop(topMenu);


// We add buttons ect. to the layout (For adding more, use addAll instead of add)

        centerMenu.getChildren().add(clickMe);
        topMenu.getChildren().add(topButton);

// Since Profileview is a Scene, it is supposed to have an origin/root.
// Here we define the root, which can be seen earlier in the constructor input which is at that point empty.
        super.setRoot(layout);

    }





}
