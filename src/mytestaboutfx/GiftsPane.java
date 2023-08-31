package mytestaboutfx;

import A.Admin;
import A.Gift;
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

public class GiftsPane extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
    }

    public static VBox GiftPane() throws FileNotFoundException {

        Image imageGifts = new Image(new FileInputStream("src/Icons/icons8_Gift_80px.png"));
        ImageView imageViewGifts = new ImageView(imageGifts);
        Label Title = new Label("Gifts", imageViewGifts);
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

        TableView<Gift> Table = new TableView();
        TableColumn<Gift, String> IdCol = new TableColumn<>("Id");
        IdCol.setCellValueFactory(new PropertyValueFactory<>("Id"));
        IdCol.setMinWidth(380);
        TableColumn<Gift, String> NameCol = new TableColumn<>("Name");
        NameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        NameCol.setMinWidth(380);
        Table.setMinHeight(500);
        Table.setItems(setData());
        Table.getColumns().addAll(IdCol, NameCol);

        HBox Tfs = new HBox();
        Tfs.setAlignment(Pos.CENTER);
        Tfs.setSpacing(50);
        Tfs.setPadding(new Insets(10, 10, 10, 10));
        TextField TfId = new TextField();
        TfId.setMinWidth(150);
        TfId.setPromptText("Enter ID");
        TextField TfName = new TextField();
        TfName.setMinWidth(150);
        TfName.setPromptText("Enter Name");
        Tfs.getChildren().addAll(TfId, TfName);

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
                Gift gift = Adn.searchGift(Tsearch.getText());
                if (gift != null) {
                    TfId.setText(gift.getId());
                    TfName.setText(gift.getName());
                } else {
                    JOptionPane.showMessageDialog(null, "Not Found ...!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please, Search By ID before submit ...!");
            }
        });
        Badd.setOnAction(e -> {
            if (!TfId.getText().equals("") && !TfName.getText().equals("")) {
                Admin Adn = new Admin();
                if (Adn.searchGift(TfId.getText()) == null) {
                    Gift gift = new Gift();
                    gift.setId(TfId.getText());
                    gift.setName(TfName.getText());
                    Adn.addGift(gift);
                    TfId.setText("");
                    TfName.setText("");
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
            if (!Tsearch.getText().equals("") && !TfId.getText().equals("") && !TfName.getText().equals("")) {
                Admin Adn = new Admin();
                Adn.deleteGift(Tsearch.getText());
                TfId.setText("");
                TfName.setText("");
                Tsearch.setText("");
                JOptionPane.showMessageDialog(null, "Done ...!");
            } else {
                JOptionPane.showMessageDialog(null, "There is field is missing ...!");
            }
            Table.setItems(setData());
        });
        Bupdate.setOnAction(e -> {
            if (!Tsearch.getText().equals("") && !TfId.getText().equals("") && !TfName.getText().equals("")) {
                Admin Adn = new Admin();
                Gift gift = new Gift();
                gift.setId(TfId.getText());
                gift.setName(TfName.getText());
                Adn.updateGift(TfId.getText(), gift);
                TfId.setText("");
                TfName.setText("");
                Tsearch.setText("");
                JOptionPane.showMessageDialog(null, "Done ...!");
            } else {
                JOptionPane.showMessageDialog(null, "There is field is missing ...!");
            }
            Table.setItems(setData());
        });

        VBox Window = new VBox();
        Window.getChildren().addAll(Icon, Top, Table, Tfs, Btns);
        return Window;
    }

    public static ObservableList<Gift> setData() {
        Gift x = new Gift();
        ArrayList<Gift> allEmp = new ArrayList();
        allEmp = (ArrayList<Gift>) x.list();
        ObservableList<Gift> Data = FXCollections.observableArrayList();
        for (int i = 0; i < allEmp.size(); i++) {
            Data.add(allEmp.get(i));
        }
        return Data;
    }
}
