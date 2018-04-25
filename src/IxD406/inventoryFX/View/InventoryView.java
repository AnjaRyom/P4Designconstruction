package IxD406.inventoryFX.View;

import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class InventoryView extends Scene {

    TableView<InventoryAttributes> table;

    //Initialized layout of scene, with top, left, and center menu
    BorderPane layout = new BorderPane();
    CenterMenu centerMenu = new CenterMenu(); //This is not used at the moment.
    LeftMenu leftMenu = new LeftMenu();
    TopMenu topMenu = new TopMenu(); //This is not used either at the moment

    //OrderButton starts existing here
    Button orderButton = new Button();

    //Constructor of class, makes buttons and inserts them correctly

    public InventoryView (Parent root, double width, double height){
        super (root, width, height);

        super.setRoot(layout);


        //Here we make up the table
        TableColumn<InventoryAttributes, String> nameColumn = new TableColumn<>("Navn");
        nameColumn.setMinWidth(400);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<InventoryAttributes, String> productNrColumn = new TableColumn<>("Produkt Nr.");
        productNrColumn.setMinWidth(250);
        productNrColumn.setCellValueFactory(new PropertyValueFactory<>("productNr"));

        TableColumn<InventoryAttributes, String> priceColumn = new TableColumn<>("Pris");
        priceColumn.setMinWidth(250);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<InventoryAttributes, String> quantityColumn = new TableColumn<>("På lager");
        quantityColumn.setMinWidth(250);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        TableColumn<InventoryAttributes, String> orderedColumn = new TableColumn<>("Bestil");
        orderedColumn.setMinWidth(250);
        orderedColumn.setCellValueFactory(new PropertyValueFactory<>("orderButton"));
        orderedColumn.setStyle("-fx-alignment: CENTER");


        table = new TableView<>();
        table.setItems(getArticle());
        table.getColumns().addAll(nameColumn, productNrColumn,priceColumn,quantityColumn, orderedColumn);

        //This will be a double-clicks function in the table,
        //so if the user double-clicks, a window should appear
        table.setRowFactory( e -> {
            TableRow<InventoryAttributes> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    InventoryAttributes rowData = row.getItem();
                    System.out.println("You doubleclicked the " +rowData.getName());
                    //ClassName.display();

                }
            });
            return row ;
        });

        //Need a gridpane in here, in which we will make a table
        GridPane inventoryGridpane = new GridPane();
        inventoryGridpane.setHgap(0);
        inventoryGridpane.setVgap(0);
        inventoryGridpane.setPadding(new Insets(0,0,0,0));


        //The last column should be a button, instead of just a boolean
        //Button orderButton = new Button("Bestil");



        inventoryGridpane.getChildren().addAll(table);

        layout.setCenter(inventoryGridpane);
        layout.setLeft(leftMenu);
        layout.setTop(topMenu);

    }

    public void orderButtonClicked (){
        this.orderButton.setStyle("-fx-base: #6666FF;"); //This does not work, since it only changes the latest button created.
        //The only button having the orderButtonClicked action will not change color on itself
    }

    public ObservableList<InventoryAttributes>getArticle(){
        ObservableList<InventoryAttributes> articles = FXCollections.observableArrayList();

        //Each of these article.add(s) should take information from the Article database. Note that I have to re-make the button each time.
        //I have tried to reduce the amount of code used for buttons, but to no avail
        articles.add(new InventoryAttributes
                ("Whatever Shampoo", 72401, 14.99, 88, orderButton = new Button("Genbestil")));
        orderButton.setStyle("-fx-base: #007f00;"); orderButton.setTextFill(Color.web("#ffffff")); orderButton.setOnAction(e -> orderButtonClicked());
        articles.add(new InventoryAttributes
                ("The Correct HairGoo", 15727, 18.44, 67, orderButton = new Button("Genbestil")));
        orderButton.setStyle("-fx-base: #007f00;"); orderButton.setTextFill(Color.web("#ffffff"));
        articles.add(new InventoryAttributes
                ("Sister's Scissor", 34437, 4.99, 12, orderButton = new Button("Genbestil")));
        orderButton.setStyle("-fx-base: #007f00;"); orderButton.setTextFill(Color.web("#ffffff"));
        articles.add(new InventoryAttributes
                ("Balsamico Balsam", 14895, 21.95, 27, orderButton = new Button("Genbestil")));
        orderButton.setStyle("-fx-base: #007f00;"); orderButton.setTextFill(Color.web("#ffffff"));
        articles.add(new InventoryAttributes
                ("Psycho Shaver", 14894, 104.95, 3, orderButton = new Button("Genbestil")));
        orderButton.setStyle("-fx-base: #007f00;"); orderButton.setTextFill(Color.web("#ffffff"));
        return articles;
    }


}