package mytestaboutfx;

import A.Admin;
import A.Gift;
import A.RewardProgram;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javax.swing.JOptionPane;

public class RewardProgramPane extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

    }

    public static VBox RewardProgramPane() throws FileNotFoundException {

        Image imageReward = new Image(new FileInputStream("src/Icons/icons8_Trophy_80px.png"));
        ImageView imageViewReward = new ImageView(imageReward);
        Label Title = new Label(" Reward Programs ", imageViewReward);
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
        Tsearch.setMinWidth(300);

        Button Bsearch = new Button("Search");
        Bsearch.setMinWidth(100);
        Top.getChildren().addAll(Tsearch, Bsearch);

        TableView<RewardProgram> Table = new TableView<>();
        TableColumn<RewardProgram, String> IdCol = new TableColumn<>("Id");
        IdCol.setCellValueFactory(new PropertyValueFactory<>("Id"));
        IdCol.setMinWidth(250);
        TableColumn<RewardProgram, String> NameCol = new TableColumn<>("OrderNumber");
        NameCol.setCellValueFactory(new PropertyValueFactory<>("Ordre_Numbers"));
        NameCol.setMinWidth(250);
        TableColumn<RewardProgram, String> GiftNameColl = new TableColumn<>("GiftName");
        GiftNameColl.setCellValueFactory(new PropertyValueFactory<>("GiftName"));
        GiftNameColl.setMinWidth(250);
        Table.setMinHeight(500);
        Table.setItems(setData());
        Table.getColumns().addAll(IdCol, NameCol, GiftNameColl);

        HBox Tfs = new HBox();
        Tfs.setAlignment(Pos.CENTER);
        Tfs.setSpacing(50);
        Tfs.setPadding(new Insets(10, 10, 10, 10));
        TextField TfId = new TextField();
        TfId.setMinWidth(150);
        TfId.setPromptText("Enter Id");
        TextField NumberOfOrder = new TextField();
        NumberOfOrder.setMinWidth(150);
        NumberOfOrder.setPromptText("Enter Number Of Order");
        ComboBox<String> C1 = new ComboBox<>();

        // Set combboxbox with Gifts
        Gift g = new Gift();
        ArrayList<Gift> allGifts = g.list();
        for (int i = 0; i < allGifts.size(); i++) {
            C1.getItems().add(allGifts.get(i).getName());
        }

        C1.setPromptText("Set a Gift");
        Tfs.getChildren().addAll(TfId, NumberOfOrder, C1);

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
                Admin admin = new Admin();
                RewardProgram r = new RewardProgram();
                r = admin.searchRewardProgram(Tsearch.getText());
                if (r != null) {
                    r.getRewardProgram(Tsearch.getText());
                    TfId.setText(r.getId());
                    C1.setValue(r.getGiftName());
                    NumberOfOrder.setText(String.valueOf(r.getOrdre_Numbers()));
                } else {
                    JOptionPane.showMessageDialog(null, "This Id Not Found");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please entre the id ...!");
            }
        });
        Badd.setOnMouseClicked(e -> {
            if (!TfId.getText().equals("") && !NumberOfOrder.getText().equals("") && !C1.getSelectionModel().isEmpty()) {

                validation v = new validation();
                if (v.checkId(TfId.getText())) {
                    if (v.checkNumberOfMeals(NumberOfOrder.getText())) {
                        A.RewardProgram r = new A.RewardProgram();
                        Admin admin = new Admin();
                        if (admin.searchRewardProgram(TfId.getText()) == null) {
                            r.setId(TfId.getText());
                            r.setOrdre_Numbers(Integer.parseInt(NumberOfOrder.getText()));
                            r.setGiftName(C1.getValue());
                            admin.addRewardProgram(r);
                            JOptionPane.showMessageDialog(null, "Done ...!");
                            TfId.setText("");
                            NumberOfOrder.setText("");
                            C1.getSelectionModel().clearSelection();
                        } else {
                            JOptionPane.showMessageDialog(null, "This id is used before ...!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "The Number Of Orders Is Wrong");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "The Id Is Wrong");
                }
            } else {
                JOptionPane.showMessageDialog(null, "There is field is missing ...!");
            }
            Table.setItems(setData());
        });
        Bupdate.setOnAction(e -> {
            if (!Tsearch.getText().equals("") && !TfId.getText().equals("") && !NumberOfOrder.getText().equals("") && !C1.getSelectionModel().isEmpty()) {
                validation v = new validation();
                if (v.checkId(TfId.getText())) {
                    if (v.checkNumberOfMeals(NumberOfOrder.getText())) {

                        Admin admin = new Admin();
                        RewardProgram Rew = new RewardProgram();
                        Rew.setId(TfId.getText());
                        Rew.setOrdre_Numbers(Integer.parseInt(NumberOfOrder.getText()));
                        Rew.setGiftName(C1.getValue());
                        admin.updateRewardProgram(Tsearch.getText(), Rew);
                        JOptionPane.showMessageDialog(null, "Done ...!");
                        TfId.setText("");
                        NumberOfOrder.setText("");
                        C1.getSelectionModel().clearSelection();

                    } else {
                        JOptionPane.showMessageDialog(null, "The Number Of Orders Is Wrong");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "The Id Is Wrong");
                }
            } else {
                JOptionPane.showMessageDialog(null, "There is field is missing ...!");
            }
            Table.setItems(setData());
        });
        Bdelete.setOnAction(e -> {
            if (!Tsearch.getText().equals("") && !TfId.getText().equals("") && !NumberOfOrder.getText().equals("") && !C1.getSelectionModel().isEmpty()) {
                Admin admin = new Admin();
                admin.deleteRewardProgram(Tsearch.getText());
                JOptionPane.showMessageDialog(null, "Done ...!");
                Tsearch.setText("");
                TfId.setText("");
                NumberOfOrder.setText("");
                C1.getSelectionModel().clearSelection();
            } else {
                JOptionPane.showMessageDialog(null, "There is Text Field Empty");
            }
            Table.setItems(setData());
        });
        VBox Window = new VBox();
        Window.getChildren().addAll(Icon, Top, Table, Tfs, Btns);
        return Window;
    }

    public static ObservableList<RewardProgram> setData() {

        RewardProgram x = new RewardProgram();
        ArrayList<RewardProgram> allRew = new ArrayList();
        allRew = (ArrayList<RewardProgram>) x.list();
        ObservableList<RewardProgram> Data = FXCollections.observableArrayList();
        for (int i = 0; i < allRew.size(); i++) {
            Data.add(allRew.get(i));
        }
        return Data;
    }
}
