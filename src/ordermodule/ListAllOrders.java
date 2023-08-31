package ordermodule;

import A.Order;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ListAllOrders extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
    }

    public static VBox getListOrders() throws FileNotFoundException {
        VBox grid = new VBox();
        //HBox for Label Icon---------------------------------------------------
        HBox Hbox1 = new HBox();
        //Icon for List
        Image img = new Image(new FileInputStream("src/Icons/icons8_Report_Card_48px.png"));
        ImageView ImageViewIcon = new ImageView(img);
        Label icon = new Label("Orders' List", ImageViewIcon);
        icon.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
        Hbox1.getChildren().addAll(icon);
        //End of HBox-----------------------------------------------------------
        //HBox for Table---------------------------------------------------------
        HBox Hbox2 = new HBox();
        //Table for Orders--------------------------------------------------
        TableView<Order> table;
        table = new TableView<>();
        //MealName Column
        TableColumn<Order, String> nameColumn = new TableColumn<>("Customer ID");
        nameColumn.setMinWidth(400);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("Customer_id"));
        //Customer ID Column
        TableColumn<Order, String> IDColumn = new TableColumn<>("Order ID");
        IDColumn.setMinWidth(400);
        IDColumn.setCellValueFactory(new PropertyValueFactory<>("Id"));

        table.getColumns().addAll(nameColumn, IDColumn);
        table.setItems(getOrders());
        table.setMinWidth(800);
        table.setMinHeight(660);
        Hbox2.getChildren().addAll(table);
        //End of HBox------------------------------------------------------------
        VBox.setMargin(Hbox2, new Insets(0, 0, 0, 100));
        VBox.setMargin(Hbox1, new Insets(0, 0, 0, 300));
        //----End of Table-------------------------------------------------------
        grid.getChildren().addAll(Hbox1, Hbox2);
        return grid;
    }

    public static ObservableList<Order> getOrders() {
        Order x = new Order();
        ObservableList<Order> Orders
                = FXCollections.observableArrayList();
        ArrayList<Order> list = x.list();
        Orders.addAll(list);
        return Orders;
    }
}
