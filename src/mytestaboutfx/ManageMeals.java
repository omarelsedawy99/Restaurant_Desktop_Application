package mytestaboutfx;

import A.Admin;
import A.Meal;
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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class ManageMeals extends Application {

    @Override
    public void start(Stage primaryStage) {

    }

    public static VBox ManageMealsPane() throws FileNotFoundException {

        Image imageMeal = new Image(new FileInputStream("src/Icons/icons8_Meal_80px.png"));
        ImageView imageViewMeal = new ImageView(imageMeal);
        Label Title = new Label("Manage Meals", imageViewMeal);
        Title.setFont(Font.font("Italic", FontWeight.NORMAL, 40));
        Title.setPadding(new Insets(0, 10, 30, 0));
        HBox Icon = new HBox();
        Icon.setAlignment(Pos.CENTER);
        Icon.getChildren().add(Title);

        HBox Top = new HBox();
        Top.setAlignment(Pos.CENTER);
        Top.setSpacing(20);
        Top.setPadding(new Insets(10, 10, 10, 10));
        TextField Tsearch = new TextField();
        Tsearch.setMinWidth(200);

        Button Bsearch = new Button("Search");
        Bsearch.setMinWidth(100);
        Top.getChildren().addAll(Tsearch, Bsearch);

        TableView<Meal> Table = new TableView();
        TableColumn<Meal, String> IdCol = new TableColumn<>("Id");
        IdCol.setCellValueFactory(new PropertyValueFactory<>("Id"));
        IdCol.setMinWidth(250);
        TableColumn<Meal, String> NameCol = new TableColumn<>("MealName");
        NameCol.setCellValueFactory(new PropertyValueFactory<>("MealName"));
        NameCol.setMinWidth(250);
        TableColumn<Meal, Double> PriceCol = new TableColumn<>("MealPrice");
        PriceCol.setCellValueFactory(new PropertyValueFactory<>("MealPrice"));
        PriceCol.setMinWidth(256);
        Table.setMinHeight(500);
        Table.setItems(setData());
        Table.getColumns().addAll(IdCol, NameCol, PriceCol);

        HBox Tfs = new HBox();
        Tfs.setAlignment(Pos.CENTER);
        Tfs.setSpacing(50);
        Tfs.setPadding(new Insets(10, 10, 10, 10));
        TextField TfId = new TextField();
        TfId.setMinWidth(150);
        TfId.setPromptText("Id");
        TextField TfName = new TextField();
        TfName.setMinWidth(150);
        TfName.setPromptText("Name");
        TextField TfPrice = new TextField();
        TfPrice.setMinWidth(150);
        TfPrice.setPromptText("Price");
        Tfs.getChildren().addAll(TfId, TfName, TfPrice);

        HBox Btns = new HBox();
        Btns.setAlignment(Pos.CENTER);
        Btns.setSpacing(20);
        Btns.setPadding(new Insets(10, 10, 10, 10));
        Button Badd = new Button("Add");
        Badd.setMinWidth(100);
        Button Bdelete = new Button("Delete");
        Bdelete.setMinWidth(100);
        Button Bupdate = new Button("Update");
        Bupdate.setMinWidth(100);
        Btns.getChildren().addAll(Badd, Bdelete, Bupdate);

        Bsearch.setOnAction(e -> {
            if (!Tsearch.getText().equals("")) {
                Admin Adn = new Admin();
                Meal meal = Adn.searchMeal(Tsearch.getText());
                if (meal != null) {
                    TfId.setText(meal.getId());
                    TfName.setText(meal.getMealName());
                    TfPrice.setText(Double.toString(meal.getMealPrice()));
                } else {
                    Tsearch.setText("");
                    JOptionPane.showMessageDialog(null, "Not Found ...!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please, entre the id ...!");
            }
        });
        Badd.setOnAction(e -> {
            if (!TfId.getText().equals("") && !TfName.getText().equals("") && !TfPrice.getText().equals("")) {
                Admin Adn = new Admin();
                if (Adn.searchMeal(TfId.getText()) == null) {
                    Meal meal = new Meal();
                    meal.setId(TfId.getText());
                    meal.setMealName(TfName.getText());
                    meal.setMealPrice(Double.parseDouble(TfPrice.getText()));
                    Adn.addMeal(meal);
                    TfId.setText("");
                    TfName.setText("");
                    TfPrice.setText("");
                    JOptionPane.showMessageDialog(null, "Done ...!");
                } else {
                    JOptionPane.showMessageDialog(null, "This id is used before ...!");
                }

            } else {
                JOptionPane.showMessageDialog(null, "There is field is missing ...!");
            }
            Table.setItems(setData());
        });
        Bdelete.setOnAction(e -> {
            if (!Tsearch.getText().equals("") && !TfId.getText().equals("") && !TfName.getText().equals("") && !TfPrice.getText().equals("")) {
                Admin Adn = new Admin();
                Adn.deleteMeal(Tsearch.getText());
                TfId.setText("");
                TfName.setText("");
                TfPrice.setText("");
                Tsearch.setText("");
                JOptionPane.showMessageDialog(null, "Done ...!");
            } else {
                JOptionPane.showMessageDialog(null, "There is field is missing ...!");
            }
            Table.setItems(setData());
        });
        Bupdate.setOnAction(e -> {
            if (!Tsearch.getText().equals("") && !TfId.getText().equals("") && !TfName.getText().equals("") && !TfPrice.getText().equals("")) {
                Admin Adn = new Admin();
                Meal meal = new Meal();
                meal.setId(TfId.getText());
                meal.setMealName(TfName.getText());
                meal.setMealPrice(Double.parseDouble(TfPrice.getText()));
                Adn.updateMeal(Tsearch.getText(), meal);
                TfId.setText("");
                TfName.setText("");
                TfPrice.setText("");
                Tsearch.setText("");
                JOptionPane.showMessageDialog(null, "Done ...!");
            } else {
                JOptionPane.showMessageDialog(null, "There is field is missing ...!");
            }
            Table.setItems(setData());
        });
        VBox MangeMeals = new VBox();
        MangeMeals.getChildren().addAll(Icon, Top, Table, Tfs, Btns);
        return MangeMeals;

    }

    public static ObservableList<Meal> setData() {
        Meal x = new Meal();
        ArrayList<Meal> meals = (ArrayList<Meal>) x.list();
        ObservableList<Meal> Data = FXCollections.observableArrayList();
        for (int i = 0; i < meals.size(); i++) {
            Data.add(meals.get(i));
        }
        return Data;
    }
}
