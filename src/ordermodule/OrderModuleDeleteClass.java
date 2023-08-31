package ordermodule;

import A.Meal;
import A.Order;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class OrderModuleDeleteClass extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
    }

    public static VBox getOrderDeleteModule() throws FileNotFoundException {
        VBox grid = new VBox();
        grid.setPadding(new Insets(20, 20, 30, 20));
        //Adding an HBox for the Title Label-------------------------------------
        HBox HBox1 = new HBox();
        //Search and Delete Label
        Image img = new Image(new FileInputStream("src/Icons/icons8_Delete_Document_48px.png"));
        ImageView imgview = new ImageView(img);
        Label DeleteOrder = new Label("Search & Cancel Order", imgview);
        DeleteOrder.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
        HBox1.getChildren().add(DeleteOrder);
        HBox1.setPadding(new Insets(0, 0, 50, 250));
        //---------End of HBox Function------------------------------------------
        //Adding HBox for OrderID Label and Input--------------------------------
        HBox HBox2 = new HBox();
        //OrderID Label
        Label OIDLabel = new Label("Order ID:");
        OIDLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        //OrderID Input
        TextField OIDTextField = new TextField();
        OIDTextField.setPromptText("Order ID");
        TextFieldStyle(OIDTextField);
        //-----------------------------------------------------------------------
        HBox2.setSpacing(40);
        HBox2.setAlignment(Pos.CENTER);
        HBox2.setPadding(new Insets(0, 0, 50, 0));
        HBox2.getChildren().addAll(OIDLabel, OIDTextField);
        //----End of HBox2 Functionality-----------------------------------------
        //Main HBox for Table and Labels-----------------------------------------
        HBox Content = new HBox();
        //VBox for the Table-----------------------------------------------------
        VBox VBoxTable = new VBox();
        //Table for Meals---------------------------------------------------
        TableView<Meal> table;
        table = new TableView<>();
        //MealName Column
        TableColumn<Meal, String> nameColumn = new TableColumn<>("MealName");
        nameColumn.setMinWidth(400);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("MealName"));
        //MealName Column
        TableColumn<Meal, String> IDColumn = new TableColumn<>("MealID");
        IDColumn.setMinWidth(300);
        IDColumn.setCellValueFactory(new PropertyValueFactory<>("Id"));
        //MealName Column
        TableColumn<Meal, Double> PriceColumn = new TableColumn<>("MealPrice");
        PriceColumn.setMinWidth(200);
        PriceColumn.setCellValueFactory(new PropertyValueFactory<>("MealPrice"));

        table.getColumns().addAll(nameColumn, IDColumn, PriceColumn);
        table.setMinWidth(930);
        table.setMinHeight(320);
        //----End of Table--------------------------------------------------    
        VBoxTable.setStyle("-fx-border-color:#000000;-fx-border-radius:20;"
                + "-fx-padding:10;"
                + "-fx-background-radius:20;"
                + "-fx-border-width:5;");
        VBoxTable.getChildren().addAll(table);
        //-----End of VBox for Table---------------------------------------------
        //-----------------------------------------------------------------------
        Content.setSpacing(50);
        Content.getChildren().addAll(VBoxTable);
        //End Of Main HBox containing Table And Labels----------------------------
        //HBox for The Search and Cancel Buttons---------------------------------
        HBox Buttons = new HBox();
        //-------Search Order Button-----------------------------------------------
        Button SearchOrderButton = new Button("Search Order!");
        SearchOrderButton.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
        HoverAndStyle(SearchOrderButton);
        //----------End of Search Order Button-------------------------------------
        //-------Cancel Order Button-----------------------------------------------
        Button CancelOrderButton = new Button("Cancel Order!");
        CancelOrderButton.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
        HoverAndStyle(CancelOrderButton);
        //----------End of Cancel Order Button-------------------------------------
        Buttons.setSpacing(500);
        Buttons.setPadding(new Insets(100, 0, 0, 0));
        Buttons.getChildren().addAll(SearchOrderButton, CancelOrderButton);
        //End of HBox------------------------------------------------------------
        //Functionality of Buttons-----------------------------------------------
        SearchOrderButton.setOnAction(e
                -> {
            String x = OIDTextField.getText();
            if (getMeal(x) != null) {
                table.setItems(getMeal(x));
                JOptionPane.showMessageDialog(null, "Order Found!");
            } else {
                JOptionPane.showMessageDialog(null, "Cannot Find Order!");
            }
        }
        );
        CancelOrderButton.setOnAction(e
                -> {
            Order x = new Order();
            String ID = OIDTextField.getText();
            if (x.search(ID) != -1) {
                DelMeal(ID);
                OIDTextField.setText("");
                ObservableList<Meal> list = FXCollections.observableArrayList();
                table.setItems(list);
                JOptionPane.showMessageDialog(null, "Order Deleted Successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Cannot Find Order!");
            }
        }
        );
        //-------End of Functionality--------------------------------------------
        grid.getChildren().addAll(HBox1, HBox2, Content, Buttons);

        return grid;
    }

    public static void HoverAndStyle(Button b) {
        b.setTextFill(Paint.valueOf("rgb(255,255,255)"));
        b.setStyle("-fx-background-color:rgb(0,0,0); -fx-background-radius: 12px, 12px, 8px, 6px;");
        b.setOnMouseEntered(e
                -> {
            b.setTextFill(Paint.valueOf("rgb(0,0,0)"));
            b.setStyle("-fx-background-color:rgb(255,255,255); -fx-background-radius: 12px, 12px, 8px, 6px;");
        });
        b.setOnMouseExited(e
                -> {
            b.setTextFill(Paint.valueOf("rgb(255,255,255)"));
            b.setStyle("-fx-background-color:rgb(0,0,0); -fx-background-radius: 12px, 12px, 8px, 6px;");
        }
        );
    }

    public static void TextFieldStyle(TextField tf) {
        tf.setStyle("-fx-background-radius: 12px, 12px, 8px, 6px;");
    }

    public static ObservableList<Meal> getMeal(String OrderID) {
        Order x = new Order();
        if (x.search(OrderID) != -1) {
            int index = x.search(OrderID);
            ObservableList<Meal> OBSList
                    = FXCollections.observableArrayList();
            ArrayList<Order> orders = x.list();
            x = orders.get(index);
            ArrayList<Meal> list = x.getMealArrayList();
            return OBSList;
        } else {
            return null;
        }
    }

    public static void DelMeal(String OrderID) {
        Order x = new Order();
        x.delete(OrderID);
    }
}
