package IxD406.Profiles_med_fx.View;

import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class CustomerView extends ProfileView {

// Initializing the layout of the scene and the top, left and center menu

        BorderPane layout = new BorderPane();
        IxD406.Profiles_med_fx.View.CenterMenu centerMenu = new IxD406.Profiles_med_fx.View.CenterMenu();
        IxD406.Profiles_med_fx.View.LeftMenu leftMenu = new IxD406.Profiles_med_fx.View.LeftMenu();
        IxD406.Profiles_med_fx.View.TopMenu topMenu = new IxD406.Profiles_med_fx.View.TopMenu();

    public CustomerView(Parent root, double width, double height) {
        super(root, width, height);
    }
}
