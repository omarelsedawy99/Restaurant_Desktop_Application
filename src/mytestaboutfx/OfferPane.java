package mytestaboutfx;

import A.Admin;
import A.Meal;
import A.Offer;
import A.validation;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javax.swing.JOptionPane;

public class OfferPane extends Application {

    @Override
    public void start(Stage primaryStage) {

    }

    public static VBox OfferPane() throws FileNotFoundException {
        Image imageOffer = new Image(new FileInputStream("src/Icons/icons8_Sale_80px_2.png"));
        ImageView imageViewOffer = new ImageView(imageOffer);
        Label Title = new Label("Offers", imageViewOffer);
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
        Tsearch.setMinWidth(350);

        Button Bsearch = new Button("Search");
        Bsearch.setMinWidth(100);
        Top.getChildren().addAll(Tsearch, Bsearch);

        HBox TableBox = new HBox();
        TableBox.setAlignment(Pos.CENTER);
        TableBox.setSpacing(50);
        TableBox.setPadding(new Insets(10, 10, 10, 10));
        TableView<Offer> Table = new TableView();
        TableColumn<Offer, String> IdCol = new TableColumn<>("Id");
        TableColumn<Offer, String> MealName = new TableColumn<>("MealName");
        MealName.setMinWidth(150);
        TableColumn<Offer, Integer> NumberOfMeals = new TableColumn<>("NumberOfMeals");
        NumberOfMeals.setMinWidth(180);
        TableColumn<Offer, Integer> Discount = new TableColumn<>("Discount%");
        Discount.setMinWidth(130);
        Table.setMaxWidth(600);
        Table.getColumns().addAll(IdCol, MealName, NumberOfMeals, Discount);
        Table.setMinHeight(500);
        TableBox.getChildren().addAll(Table);

        IdCol.setCellValueFactory(new PropertyValueFactory<>("Id_Offer"));
        MealName.setCellValueFactory(new PropertyValueFactory<>("MealName"));
        NumberOfMeals.setCellValueFactory(new PropertyValueFactory<>("num_of_meal"));
        Discount.setCellValueFactory(new PropertyValueFactory<>("discount_precentage"));
        Table.setItems(setData());

        HBox Tfs = new HBox();
        Tfs.setAlignment(Pos.CENTER);
        Tfs.setSpacing(20);
        Tfs.setPadding(new Insets(10, 10, 10, 10));
        TextField TfId = new TextField();
        TfId.setMaxWidth(100);
        TfId.setPromptText("Set Id");
        TextField TfName = new TextField();
        TfName.setMaxWidth(100);

        ComboBox<String> C1 = new ComboBox<>();
        Meal g = new Meal();
        ArrayList<Meal> allMeals = g.list();
        for (int i = 0; i < allMeals.size(); i++) {
            C1.getItems().add(allMeals.get(i).getMealName());
        }
        C1.setOnAction(e -> {
            TfName.setText(C1.getValue());
        });
        TfName.setDisable(true);

        C1.setPromptText("Set a Meal");
        TextField TfNoOfMeals = new TextField();
        TfNoOfMeals.setMaxWidth(100);
        TfNoOfMeals.setPromptText("Number Of Meals");
        TextField TfDiscount = new TextField();
        TfDiscount.setMaxWidth(100);
        TfDiscount.setPromptText("Set Discount");
        Tfs.getChildren().addAll(TfId, TfName, TfNoOfMeals, TfDiscount, C1);

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

        /// Search Button
        Bsearch.setOnAction(e -> {
            if (!Tsearch.getText().equals("")) {
                Admin admin = new Admin();
                Offer r = new Offer();
                r = admin.searchOffer(Tsearch.getText());
                if (r != null) {
                    r.getOffer(Tsearch.getText());
                    TfId.setText("" + r.getId_Offer());
                    C1.setValue("" + r.getMealName());
                    TfNoOfMeals.setText("" + r.getNum_of_meal());
                    TfDiscount.setText("" + r.getDiscount_precentage());
                    TfName.setText("" + r.getMealName());
                } else {
                    System.out.println("This Id Not Found");
                }
            } else {
                JOptionPane.showMessageDialog(null, "The Text Field Empty");
            }
        });
        ///Add Button
        Badd.setOnMouseClicked(e -> {
            if (!TfId.getText().equals("") && !TfName.getText().equals("") && !TfNoOfMeals.getText().equals("")
                    && !TfDiscount.getText().equals("") && !C1.getSelectionModel().isEmpty()) {

                validation v = new validation();
                if (v.CheckName(TfName.getText())) {
                    if (v.checkId(TfId.getText())) {
                        if (v.checkNumberOfMeals(TfNoOfMeals.getText())) {
                            if (v.checkDiscont(TfDiscount.getText())) {

                                Offer r = new Offer();
                                Admin admin = new Admin();
                                if (admin.searchOffer(TfId.getText()) == null) {
                                    r.setId_Offer(TfId.getText());
                                    r.setNum_of_meal(Integer.parseInt(TfNoOfMeals.getText()));
                                    r.setDiscount_precentage(Integer.parseInt(TfDiscount.getText()));
                                    r.setMealName(C1.getValue());
                                    admin.addOffer(r);
                                    JOptionPane.showMessageDialog(null, "Saved");
                                    TfId.setText("");
                                    TfName.setText("");
                                    TfDiscount.setText("");
                                    TfNoOfMeals.setText("");
                                } else {
                                    JOptionPane.showMessageDialog(null, "This id is used before ...!");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "The Discount Is Wrong");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "The Number Of Meals Is Wrong");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "The ID Is Wrong");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "The Name Is Wrong");
                }

            } else {
                JOptionPane.showMessageDialog(null, "There Is Empty TextField");
            }
            Table.setItems(setData());
        });
        Bupdate.setOnAction(e -> {
            if (!Tsearch.equals("") && !TfId.getText().equals("") && !TfNoOfMeals.getText().equals("")
                    && !TfDiscount.getText().equals("") && !C1.getSelectionModel().isEmpty()) {

                validation v = new validation();
                if (v.CheckName(TfName.getText())) {
                    if (v.checkId(TfId.getText())) {
                        if (v.checkNumberOfMeals(TfNoOfMeals.getText())) {
                            if (v.checkDiscont(TfDiscount.getText())) {

                                Offer r = new Offer();
                                Admin admin = new Admin();
                                r.setId_Offer(TfId.getText());
                                r.setNum_of_meal(Integer.parseInt(TfNoOfMeals.getText()));
                                r.setDiscount_precentage(Integer.parseInt(TfDiscount.getText()));
                                r.setMealName(C1.getValue());
                                admin.updateOffer(Tsearch.getText(), r);
                                JOptionPane.showMessageDialog(null, "Updated");
                                TfId.setText("");

                                TfName.setText("");
                                TfDiscount.setText("");
                                TfNoOfMeals.setText("");
                                Tsearch.setText("");
                                Table.setItems(setData());

                            } else {
                                JOptionPane.showMessageDialog(null, "The Discount Is Wrong");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "The Number Of Meals Is Wrong");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "The ID Is Wrong");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "The Name Is Wrong");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Enter Id");
            }
        });
        Bdelete.setOnAction(e -> {
            if (!Tsearch.equals("") && !TfId.getText().equals("") && !TfNoOfMeals.getText().equals("")
                    && !TfDiscount.getText().equals("") && !C1.getSelectionModel().isEmpty()) {
                Admin admin = new Admin();
                admin.deleteOffer(Tsearch.getText());
                JOptionPane.showMessageDialog(null, "Deleted");
            } else {
                JOptionPane.showMessageDialog(null, "There is Text Field Empty");
            }
            TfId.setText("");
            TfName.setText("");
            TfDiscount.setText("");
            TfNoOfMeals.setText("");
            Table.setItems(setData());
            Tsearch.setText("");
            Table.setItems(setData());
        });

        VBox Window = new VBox();
        Window.getChildren().addAll(Icon, Top, TableBox, Tfs, Btns);

        return Window;

    }

    public static ObservableList<Offer> setData() {

        Offer x = new Offer();
        ArrayList<Offer> allOffers = new ArrayList();
        allOffers = x.listOffer();
        ObservableList<Offer> Data = FXCollections.observableArrayList();
        for (int i = 0; i < allOffers.size(); i++) {
            Data.add(allOffers.get(i));
        }
        return Data;

    }

}
