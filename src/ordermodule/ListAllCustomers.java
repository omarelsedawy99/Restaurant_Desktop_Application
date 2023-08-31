package ordermodule;

import A.Customer;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

public class ListAllCustomers extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
    }

    public static VBox getListCustomers() throws FileNotFoundException {
        VBox grid = new VBox();
        //HBox for Label Icon---------------------------------------------------
        HBox Hbox1 = new HBox();
        //Icon for List
        Image img = new Image(new FileInputStream("src/Icons/icons8_User_Menu_Male_48px.png"));
        ImageView ImageViewIcon = new ImageView(img);
        Label icon = new Label("Customers' List", ImageViewIcon);
        icon.setFont(Font.font("Verdana", FontWeight.BOLD, 30));

        Hbox1.getChildren().addAll(icon);
        //End of HBox-----------------------------------------------------------
        //HBox for Table--------------------------------------------------------
        HBox Hbox2 = new HBox();
        //Table for Customer--------------------------------------------------------
        TableView<Customer> table;
        table = new TableView<>();
        //Customer ID Column
        TableColumn<Customer, String> CIDColumn = new TableColumn<>("Customer ID");
        CIDColumn.setMinWidth(200);
        CIDColumn.setCellValueFactory(new PropertyValueFactory<>("Id"));
        //Customer Name Column
        TableColumn<Customer, String> nameColumn = new TableColumn<>("CFirst Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("Frist_name"));
        //Customer ID Column
        TableColumn<Customer, String> IDColumn = new TableColumn<>("CLast_Name");
        IDColumn.setMinWidth(200);
        IDColumn.setCellValueFactory(new PropertyValueFactory<>("Last_name"));
        //Orders Column
        TableColumn<Customer, String> PriceColumn = new TableColumn<>("Gender");
        PriceColumn.setMinWidth(200);
        PriceColumn.setCellValueFactory(new PropertyValueFactory<>("Gender"));
        table.getColumns().addAll(CIDColumn, nameColumn, IDColumn, PriceColumn);
        table.setMinWidth(800);
        table.getItems().addAll(getCustomers());
        table.setMinHeight(660);
        Hbox2.getChildren().addAll(table);
        //End of HBox------------------------------------------------------------
        VBox.setMargin(Hbox2, new Insets(0, 0, 0, 100));
        VBox.setMargin(Hbox1, new Insets(0, 0, 0, 250));
        //----End of Table-------------------------------------------------------
        grid.getChildren().addAll(Hbox1, Hbox2);
        return grid;
    }

    public static ObservableList<Customer> getCustomers() {
        Customer x = new Customer();
        ObservableList<Customer> list = FXCollections.observableArrayList();
        list.addAll(x.list());
        return list;
    }

}
