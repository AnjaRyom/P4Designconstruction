package IxD406.Payment.View;

import IxD406.Payment.Controller.Controller;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class PaymentView extends Scene {

    Controller controller;
    double width;
    double height;
    AddView addView;
    SummaryView summaryView;
    LeftMenu leftMenu;

    public PaymentView(Parent root, double width, double height, Controller controller) {
        super(root,width,height);
        this.controller = controller;
        this.width = width;
        this.height = height;
        this.addView = new AddView(this.controller);
        this.summaryView = new SummaryView(this.controller);
        this.leftMenu = new LeftMenu(this.controller);

        BorderPane paymentBorder = (BorderPane) root;

        paymentBorder.setLeft(this.leftMenu);
        paymentBorder.setCenter(this.addView.addBox);
        paymentBorder.setRight(this.summaryView.rightVBox);


    }

}
