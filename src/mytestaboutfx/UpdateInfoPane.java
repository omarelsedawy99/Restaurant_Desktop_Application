package mytestaboutfx;

import A.Admin;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class UpdateInfoPane extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
    }

    public static VBox UpdaeInfoPane() throws FileNotFoundException {

        Image imageInfo = new Image(new FileInputStream("src/Icons/icons8_More_Info_80px.png"));
        ImageView imageViewInfo = new ImageView(imageInfo);
        Label Title = new Label("Update Info", imageViewInfo);
        Title.setFont(Font.font("Italic", FontWeight.NORMAL, 40));
        Title.setPadding(new Insets(0, 10, 30, 0));
        HBox Icon = new HBox();
        Icon.setAlignment(Pos.CENTER);
        Icon.getChildren().add(Title);

        HBox Main0 = new HBox();
        Label Ml0 = new Label("ID");
        Ml0.setStyle("-fx-Font-size:25px;-fx-Font-Family:bold;");
        TextField Tfid = new TextField();
        Tfid.setMaxWidth(150);
        Tfid.setMaxHeight(30);
        Tfid.setMinWidth(350);
        Main0.setSpacing(110);
        Main0.setAlignment(Pos.CENTER);
        Main0.setPadding(new Insets(10, 10, 10, 10));
        Main0.getChildren().addAll(Ml0, Tfid);

        HBox Main1 = new HBox();
        Label Ml1 = new Label("UserName");
        Ml1.setStyle("-fx-Font-size:25px;-fx-Font-Family:bold");
        TextField TFusername = new TextField();
        TFusername.setMaxWidth(150);
        TFusername.setMinWidth(350);
        TFusername.setMaxHeight(30);
        Main1.setSpacing(20);
        Main1.setAlignment(Pos.CENTER);
        Main1.setPadding(new Insets(10, 10, 10, 10));
        Main1.getChildren().addAll(Ml1, TFusername);

        HBox Main2 = new HBox();
        Label Ml2 = new Label("PassWord");
        Ml2.setStyle("-fx-Font-size:25px;-fx-Font-Family:bold");
        TextField TFpassword = new TextField();
        TFpassword.setMinWidth(350);
        TFpassword.setMaxHeight(30);
        Main2.setSpacing(25);
        Main2.setAlignment(Pos.CENTER);
        Main2.setPadding(new Insets(10, 10, 10, 10));
        Main2.getChildren().addAll(Ml2, TFpassword);

        HBox Main3 = new HBox();
        Label Ml3 = new Label("Fname");
        Ml3.setStyle("-fx-Font-size:25px;-fx-Font-Family:bold");
        TextField TFfname = new TextField();
        TFfname.setMaxHeight(30);
        TFfname.setMinWidth(350);
        TFfname.setMaxWidth(150);
        Main3.setSpacing(62);
        Main3.setAlignment(Pos.CENTER);
        Main3.setPadding(new Insets(10, 10, 10, 10));
        Main3.getChildren().addAll(Ml3, TFfname);

        HBox Main4 = new HBox();
        Label Ml4 = new Label("Lname");
        Ml4.setStyle("-fx-Font-size:25px;-fx-Font-Family:bold");
        TextField TFlname = new TextField();
        TFlname.setMaxHeight(30);
        TFlname.setMaxWidth(150);
        TFlname.setMinWidth(350);
        Main4.setSpacing(62);
        Main4.setAlignment(Pos.CENTER);
        Main4.setPadding(new Insets(10, 10, 10, 10));
        Main4.getChildren().addAll(Ml4, TFlname);

        HBox Main5 = new HBox();
        Label Ml5 = new Label("Gender");
        Ml5.setStyle("-fx-Font-size:25px;-fx-Font-Family:bold");
        TextField TFgender = new TextField();
        TFgender.setMaxHeight(30);
        TFgender.setMaxWidth(150);
        TFgender.setMinWidth(350);
        Main5.setSpacing(55);
        Main5.setAlignment(Pos.CENTER);
        Main5.setPadding(new Insets(10, 10, 10, 10));
        Main5.getChildren().addAll(Ml5, TFgender);

        HBox b = new HBox();
        Button btnSave = new Button("Save");
        btnSave.setMinWidth(410);
        btnSave.setMinHeight(50);
        btnSave.setStyle("-fx-background-radius:20 ;-fx-border-width: 3px;-fx-border-radius: 20;-fx-background-color:linear-gradient(gray, lightgray);-fx-font-size:30px");
//      
        b.setSpacing(20);
        b.setAlignment(Pos.CENTER);
        b.setPadding(new Insets(50, 10, 10, 10));
        b.getChildren().addAll(btnSave);

        btnSave.setOnAction(e -> {
            if (!TFfname.getText().equals("") && !TFlname.getText().equals("") && !TFpassword.getText().equals("")
                    && !TFusername.getText().equals("") && !TFgender.getText().equals("")) {
                Admin new_admin = new Admin();
                new_admin.setId(Tfid.getText());
                new_admin.setFrist_name(TFfname.getText());
                new_admin.setLast_name(TFlname.getText());
                new_admin.setUsername(TFusername.getText());
                new_admin.setPassword((TFpassword.getText()));
                if (TFgender.getText().equals("Male") || TFgender.getText().equals("male")) {
                    new_admin.setGender("Male");
                } else if (TFgender.getText().equals("Female") || TFgender.getText().equals("female")) {
                    new_admin.setGender("Female");
                } else {
                    JOptionPane.showMessageDialog(null, "There is something is missing or wrong");
                }
                new_admin.changeData();
                Tfid.setText("");
                TFfname.setText("");
                TFgender.setText("");
                TFlname.setText("");
                TFpassword.setText("");
                TFusername.setText("");
                JOptionPane.showMessageDialog(null, "your data is updated");
            } else {
                JOptionPane.showMessageDialog(null, "There is something is missing ...!");
            }
        });

        VBox Window = new VBox();
        Window.getChildren().addAll(Icon, Main0, Main1, Main2, Main3, Main4, Main5, b);
        Window.setMinHeight(600);
        Window.setMinWidth(600);

        return Window;

    }

}
