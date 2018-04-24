package IxD406.inventoryFX.View;

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

public class InventoryView extends Scene {

    TableView<InventoryAttributes> table;

    //Initialized layout of scene, with top, left, and center menu
    BorderPane layout = new BorderPane();
    CenterMenu centerMenu = new CenterMenu();
    LeftMenu leftMenu = new LeftMenu();
    TopMenu topMenu = new TopMenu();
    Button orderButton;

    //Constructor of class, makes buttons and inserts them correctly

    public InventoryView (Parent root, double width, double height){
        super (root, width, height);



        super.setRoot(layout);


        //Here we make up the columns of the table
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

        //This is an old part of the code which I'm gonna remove later
        /*
        TableColumn<InventoryAttributes, String> orderedColumn = new TableColumn<>("Bestil");
        orderedColumn.setMinWidth(200);
        orderedColumn.setCellValueFactory(new PropertyValueFactory<>("ordered"));
        */

        //This parts calls the table by getting the name, product number, price, quantity, and button
        table = new TableView<>();
        table.setItems(getArticle());
        table.getColumns().addAll(nameColumn, productNrColumn,priceColumn,quantityColumn, orderedColumn);

        //This will be a double-clicks function in the table,
        //so if the user double-clicks, a window should appear
        table.setRowFactory( e -> {
            TableRow<InventoryAttributes> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {

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



        inventoryGridpane.getChildren().addAll(table);

        layout.setCenter(inventoryGridpane);
        layout.setLeft(leftMenu);
        layout.setTop(topMenu);



    }

    public ObservableList<InventoryAttributes>getArticle(){
        ObservableList<InventoryAttributes> articles = FXCollections.observableArrayList();

        articles.add(new InventoryAttributes
                ("Whatever Shampoo", 72401, 14.99, 88, orderButton = new Button("Bestil")));
        articles.add(new InventoryAttributes
                ("The Correct HairGoo", 15727, 18.44, 67, orderButton = new Button("Bestil")));
        articles.add(new InventoryAttributes
                ("Sister's Scissor", 34437, 4.99, 12, orderButton = new Button("Bestil")));
        articles.add(new InventoryAttributes
                ("Balsamico Balsam", 14895, 21.95, 27, orderButton = new Button("Bestil")));
        articles.add(new InventoryAttributes
                ("Psycho Shaver", 14894, 104.95, 3, orderButton = new Button("Bestil")));
        return articles;
    }


}
