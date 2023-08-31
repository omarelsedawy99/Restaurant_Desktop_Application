package mytestaboutfx;

import A.Admin;
import A.Employee;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import ordermodule.OrderModule;

public class login extends Application {

    @Override
    public void start(Stage primaryStage) {

        BorderPane bp = new BorderPane();

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);

        Label lblUserName = new Label("Username:");
        final TextField txtUserName = new TextField();
        txtUserName.setPromptText(" Enter User Name");
        txtUserName.setStyle("-fx-background-radius: 20");

        Label lblPassword = new Label("Password:");
        final PasswordField pf = new PasswordField();
        pf.setPromptText(" Enter Password");
        pf.setStyle("-fx-background-radius: 20");

        Button btnLogin = new Button("Sign in");
        btnLogin.setFont(Font.font("fatoma", FontPosture.ITALIC, 18));
        btnLogin.setStyle("-fx-background-radius:15 ;-fx-border-width: 2px;-fx-border-color: #f6b541;-fx-text-fill: black;-fx-border-radius: 15;-fx-background-color: linear-gradient(lightgray,gray );");
        btnLogin.setOnMouseExited(e -> {

            btnLogin.setStyle("-fx-background-radius:15 ;-fx-border-width: 2px;-fx-border-color: #ffb74d;-fx-text-fill: black;-fx-border-radius: 15;-fx-background-color: linear-gradient(lightgray,gray );");
        });
        btnLogin.setOnMouseMoved(e -> {
            btnLogin.setStyle("-fx-background-radius:15 ;-fx-border-width: 2px;-fx-border-color: black;-fx-text-fill: black;-fx-border-radius: 15;-fx-background-color: linear-gradient(lightgray,gray );");
        });

        lblUserName.setFont(Font.font("fatoma", FontPosture.ITALIC, 20));
        lblPassword.setFont(Font.font("fatoma", FontPosture.ITALIC, 20));

        grid.add(lblUserName, 0, 1);
        grid.add(txtUserName, 0, 2);
        grid.add(lblPassword, 0, 3);
        grid.add(pf, 0, 4);
        grid.add(btnLogin, 2, 5);

        Reflection R = new Reflection();
        R.setFraction(0.7f);
        grid.setEffect(R);

        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(10);
        dropShadow.setOffsetY(10);

        Text text = new Text("Login");
        text.setFont(Font.font("Courier New", FontWeight.BOLD, 80));
        text.setEffect(dropShadow);
        text.setStyle("-fx-fill:#ffb74d;");

        HBox hb = new HBox();
        hb.setPadding(new Insets(30, 30, 30, 30));
        hb.getChildren().add(text);
        hb.setAlignment(Pos.CENTER);

        btnLogin.setOnAction(e -> {
            if (!txtUserName.getText().equals("") && !pf.getText().equals("")) {
                Admin admin = new Admin();
                Employee emp = new Employee();
                if (emp.login(txtUserName.getText(), pf.getText())) {
                    primaryStage.close();
                    Stage s = new Stage();
                    OrderModule x = new OrderModule();
                    try {
                        x.start(s);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (admin.login(txtUserName.getText(), pf.getText())) {
                    primaryStage.close();
                    Stage s = new Stage();
                    AdminPane x = new AdminPane();
                    try {
                        x.start(s);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "The username or password is wrong ...!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "There is field is missing ...!");
            }
        });
        grid.setStyle("-fx-background-color: linear-gradient(lightgray,gray ) ;-fx-border-color: #f6b541;-fx-border-width: 2px; -fx-border-radius: 20;-fx-padding: 10;-fx-background-radius: 20;");
        bp.setStyle("-fx-background-color: linear-gradient(gray,DimGrey ) ;-fx-padding: 70;");
        bp.setTop(hb);
        bp.setCenter(grid);

        Scene scene = new Scene(bp);

        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
