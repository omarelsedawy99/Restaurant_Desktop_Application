package ordermodule;

import A.Employee;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class OrderModuleClass extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

    }

    public static VBox getOrderModule() throws FileNotFoundException {
        VBox grid = new VBox();
        grid.setPadding(new Insets(0, 20, 30, 20));
        //Make Order Label
        Image ImageMakeOrder = new Image(new FileInputStream("src/Icons/icons8_Create_Document_48px.png"));
        ImageView imageViewMakeOrder = new ImageView(ImageMakeOrder);
        Label MakeOrder = new Label("Make Order", imageViewMakeOrder);
        MakeOrder.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
        GridPane.setConstraints(MakeOrder, 0, 0);
        MakeOrder.setPadding(new Insets(20, 0, 30, 300));
        //CustomerID and  OrderID in this HBox \/
        HBox hbox1 = new HBox();
        //------End of HBox-----------------------------------------------------/
        //CustomerID Label
        Label CIDLabel = new Label("Customer ID:");
        CIDLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        //CustomerID Input
        TextField CIDTextField = new TextField();
        CIDTextField.setPromptText("Customer ID");
        TextFieldStyle(CIDTextField);
        //OrderID Label
        Label OIDLabel = new Label("Order ID:");
        OIDLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        //OrderID Input
        TextField OIDTextField = new TextField();
        OIDTextField.setPromptText("Order ID");
        TextFieldStyle(OIDTextField);
        //------Putting Elements in HBOX (Customer ID and OrderID)---------------
        hbox1.getChildren().addAll(CIDLabel, CIDTextField, OIDLabel, OIDTextField);
        hbox1.setAlignment(Pos.CENTER);
        hbox1.setSpacing(20);
        //----------------------End of Putting Elements--------------------------
        //Table for Meal--------------------------------------------------------
        TableView<Meal> table;
        table = new TableView<>();
        //MealName Column
        TableColumn<Meal, String> nameColumn = new TableColumn<>("MealName");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("MealName"));
        //MealName Column
        TableColumn<Meal, String> IDColumn = new TableColumn<>("MealID");
        IDColumn.setMinWidth(100);
        IDColumn.setCellValueFactory(new PropertyValueFactory<>("Id"));
        //MealName Column
        TableColumn<Meal, String> PriceColumn = new TableColumn<>("MealPrice");
        PriceColumn.setMinWidth(100);
        PriceColumn.setCellValueFactory(new PropertyValueFactory<>("MealPrice"));

        table.getColumns().addAll(nameColumn, IDColumn, PriceColumn);
        table.setMinWidth(300);
        table.setMinHeight(120);
        table.setStyle("-fx-border-color:#000000;-fx-border-radius:20;"
                + "-fx-padding:10;"
                + "-fx-background-radius:20;"
                + "-fx-border-width:5;");
        //----End of Table-------------------------------------------------------
        //Putting Table into one VBox--------------------------------------------
        VBox Table = new VBox();
        Table.getChildren().add(table);
        Table.setPadding(new Insets(0, 0, 0, 40));
        //-----------------------------------------------------------------------
        //Drop Down List for Meal-----------------------------------------------
        ObservableList<String> MealAvailable = FXCollections.observableArrayList(getMealNameString());
        final ComboBox AddMealBox = new ComboBox(MealAvailable);
        AddMealBox.maxWidth(30);
        AddMealBox.setPromptText("select");
        //-----End of Drop Down List---------------------------------------------
        //-----Button to Add from Drop Down List to Table------------------------
        Button AddMealButton = new Button("Add Meal");

        AddMealButton.setFont(Font.font("Verdana", FontWeight.BOLD, 20));

        HoverAndStyle(AddMealButton);
        //-----------------------------------------------------------------------
        //Drop Down List for Meal-----------------------------------------------
        //-----End of Drop Down List---------------------------------------------
        //-----Button to Add from Drop Down List to Table------------------------
        Button RemoveMealButton = new Button("Remove Meal");
        RemoveMealButton.setFont(Font.font("Verdana", FontWeight.BOLD, 20));

        HoverAndStyle(RemoveMealButton);
        //-----------------------------------------------------------------------
        //Total Label
        Label TotalLabel = new Label("Total:");
        TotalLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        GridPane.setConstraints(TotalLabel, 0, 8);
        //Total Output
        TextField TotalTextField = new TextField();
        TotalTextField.setPromptText("Total Price");
        GridPane.setConstraints(TotalTextField, 1, 8);
        TotalTextField.setEditable(false);
        TextFieldStyle(TotalTextField);
        //Adding ComboBoxes and Labels in another VBox---------------------------
        VBox ButtonsAndLabels = new VBox();
        //Adding Internal HBoxes
        HBox HBoxTotal = new HBox();
        HBox HBoxRemove = new HBox();
        HBox HBoxAdd = new HBox();
        HBoxAdd.setPadding(new Insets(70, 10, 10, 10));
        HBoxAdd.setSpacing(20);
        HBoxRemove.setPadding(new Insets(10));
        HBoxRemove.setSpacing(20);
        HBoxTotal.setPadding(new Insets(10));
        HBoxTotal.setSpacing(20);
        ButtonsAndLabels.setPadding(new Insets(500, 200, 0, 0));
        ButtonsAndLabels.setSpacing(40);
        ButtonsAndLabels.setStyle("-fx-border-color:#000000;-fx-border-radius:20;"
                + "-fx-padding:10;"
                + "-fx-background-radius:20;"
                + "-fx-border-width:5;");
        HBoxAdd.getChildren().addAll(AddMealBox, AddMealButton);
        HBoxRemove.getChildren().addAll(RemoveMealButton);
        HBoxTotal.getChildren().addAll(TotalLabel, TotalTextField);
        ButtonsAndLabels.getChildren().addAll(HBoxAdd, HBoxRemove, HBoxTotal);
        HBoxRemove.setAlignment(Pos.CENTER);
        HBoxTotal.setAlignment(Pos.CENTER);
        HBoxAdd.setMaxWidth(400);
        //-----------------------------------------------------------------------
        //Putting Both VBox in an HBox-------------------------------------------
        HBox Content = new HBox();
        Content.getChildren().addAll(ButtonsAndLabels, Table);
        Content.setAlignment(Pos.CENTER);
        Content.setPadding(new Insets(30, 0, 0, 60));
        //-----------------------------------------------------------------------
        //-------Make Order Button-----------------------------------------------
        HBox MakeOrderBox = new HBox();
        Button MakeOrderButton = new Button("Make Order!");
        MakeOrderButton.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
        MakeOrderButton.minWidth(400);
        HoverAndStyle(MakeOrderButton);
        MakeOrderBox.getChildren().addAll(MakeOrderButton);
        MakeOrderBox.setAlignment(Pos.CENTER);
        MakeOrderBox.setPadding(new Insets(50, 0, 0, 0));
        //----------End of Make Order Button-------------------------------------
        //--------Functionality of Buttons!!-------------------------------------
        AddMealButton.setOnAction(e -> {
            if (!AddMealBox.getSelectionModel().isEmpty()) {
                table.getItems().add(OnClickAdd((String) AddMealBox.getValue()));
                ObservableList<Meal> MealOBS = FXCollections.observableArrayList(getMeal());
                Meal x;
                double TotalPrice = 0;
                for (int i = 0; i < table.getItems().size(); i++) {
                    x = table.getItems().get(i);
                    TotalPrice += x.getMealPrice();
                }
                TotalTextField.setText("" + TotalPrice);
            } else {
                JOptionPane.showMessageDialog(null, "Cannot Add, Please Select Something");
            }
        });
        RemoveMealButton.setOnAction(e -> {
            if (table.getItems() != null) {
                Meal x;
                ObservableList<Meal> MealSelected, AllProducts;
                AllProducts = table.getItems();
                MealSelected = table.getSelectionModel().getSelectedItems();
                MealSelected.forEach(AllProducts::remove);
                double TotalPrice = 0;
                for (int i = 0; i < table.getItems().size(); i++) {
                    x = table.getItems().get(i);
                    TotalPrice += x.getMealPrice();
                }
                TotalTextField.setText("" + TotalPrice);
            } else {
                JOptionPane.showMessageDialog(null, "Cannot Remove, Please Select from the table");
            }
        });
        MakeOrderButton.setOnAction(e -> {
            if (table.getItems() != null && !CIDTextField.getText().equals("") && !OIDTextField.getText().equals("")) {
                if (new Employee().searchCustomer(CIDTextField.getText()) == null) {
                    ObservableList<Meal> MealSelected = table.getItems();
                    ArrayList<Meal> list = new ArrayList();
                    Order order = new Order();
                    for (int i = 0; i < MealSelected.size(); i++) {
                        list.add(MealSelected.get(i));
                    }
                    order.addMealArrayList(list);
                    order.setCustomer_id(CIDTextField.getText());
                    order.setId(OIDTextField.getText());
                    order.add();
                    JOptionPane.showMessageDialog(null, "Order Added Successfully!");
                    CIDTextField.setText("");
                    OIDTextField.setText("");
                    ObservableList<Meal> remove = FXCollections.observableArrayList();
                    table.setItems(remove);
                    TotalTextField.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "This id is used before ...!");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Please fill the table with meals");
            }
        });

        //---------End of Functionality!!----------------------------------------
        grid.getChildren().addAll(MakeOrder, hbox1, Content, MakeOrderBox);
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

    public static ObservableList<String> getMealNameString() {
        Meal x = new Meal();
        ArrayList<Meal> list = x.list();
        ObservableList<String> meals = FXCollections.observableArrayList();
        for (int i = 0; i < list.size(); i++) {
            meals.add(list.get(i).getMealName());
        }
        return meals;
    }

    public static ObservableList<String> getMealIDString() {
        Meal x = new Meal();
        ArrayList<Meal> list = x.list();
        ObservableList<String> meals = FXCollections.observableArrayList();
        for (int i = 0; i < list.size(); i++) {
            meals.add(list.get(i).getId());
        }
        return meals;
    }

    public static ObservableList<String> getMealPriceString() {
        Meal x = new Meal();
        ArrayList<Meal> list = x.list();
        ObservableList<String> meals = FXCollections.observableArrayList();
        for (int i = 0; i < list.size(); i++) {
            meals.add("" + list.get(i).getMealPrice());
        }
        return meals;
    }

    public static ObservableList<Meal> getMeal() {
        Meal x = new Meal();
        ArrayList<Meal> list = x.list();
        ObservableList<Meal> meals = FXCollections.observableArrayList();
        for (int i = 0; i < list.size(); i++) {
            meals.add(list.get(i));
        }
        return meals;
    }

    public static Meal OnClickAdd(String MealName) {
        Meal x = new Meal();
        Meal y = new Meal();
        ArrayList<Meal> list;
        list = y.list();
        int i;
        for (i = 0; i < list.size(); i++) {

            if (list.get(i).getMealName().equals(MealName)) {
                break;
            }
        }

        y = list.get(i);

        x.setMealName(y.getMealName());
        x.setId(y.getId());
        x.setMealPrice(y.getMealPrice());

        return x;
    }
}
