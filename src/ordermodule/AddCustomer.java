package ordermodule;

import A.Customer;
import A.Employee;
import A.validation;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class AddCustomer extends Application implements Serializable {

    @Override
    public void start(Stage primaryStage) {
    }

    public static VBox getAddCustomerModule() throws FileNotFoundException {

        //gridPane code
        GridPane customer = new GridPane();
        customer.setVgap(30);
        customer.setHgap(30);
        customer.setPadding(new Insets(0, 0, 0, 30));
        //VBox code
        VBox addall = new VBox();
        addall.setSpacing(30);
        addall.setAlignment(Pos.CENTER);
        addall.setLayoutX(90);
        //Icon + Label----------------------------------------------------------
        Image ImageAddCustomer = new Image(new FileInputStream("src/Icons/icons8_Add_User_Male_96px.png"));
        ImageView imageViewAddCustomer = new ImageView(ImageAddCustomer);
        Label icon = new Label("", imageViewAddCustomer);
        icon.setPadding(new Insets(0, 0, 60, 0));
        //----------------------------------------------------------------------
        //ID of customer
        Text id = new Text("Customer Id:");
        id.setFont(Font.font("Tahoma", FontWeight.BOLD, FontPosture.ITALIC, 20));
        customer.add(id, 0, 0);
        TextField Id = new TextField();
        Id.setPrefWidth(150);
        Id.setPrefHeight(40);
        customer.add(Id, 1, 0);
        //Node of First name
        Text fname = new Text("First Name :");
        fname.setFont(Font.font("Tahoma", FontWeight.BOLD, FontPosture.ITALIC, 20));
        customer.add(fname, 0, 1);
        TextField fName = new TextField();
        fName.setPrefWidth(150);
        fName.setPrefHeight(40);
        customer.add(fName, 1, 1);

        //node of LastName
        Text lname = new Text("Last Name :");
        lname.setFont(Font.font("Tahoma", FontWeight.BOLD, FontPosture.ITALIC, 20));
        customer.add(lname, 0, 2);
        TextField lName = new TextField();
        lName.setPrefWidth(150);
        lName.setPrefHeight(40);
        customer.add(lName, 1, 2);
        //node of Gender
        Text gender = new Text("Gender :");
        gender.setFont(Font.font("Tahoma", FontWeight.BOLD, FontPosture.ITALIC, 20));
        customer.add(gender, 0, 3);
        RadioButton male = new RadioButton("MALE");
        male.setFont(Font.font("Fatoma", FontPosture.ITALIC, 20));
        RadioButton female = new RadioButton("FEMALE");
        female.setFont(Font.font("Fatoma", FontPosture.ITALIC, 20));
        ToggleGroup Sex = new ToggleGroup();
        male.setToggleGroup(Sex);
        female.setToggleGroup(Sex);
        HBox hb = new HBox();
        hb.setSpacing(50);
        hb.getChildren().addAll(male, female);
        customer.add(hb, 1, 3);
        //Button For ADD Cudtomer
        VBox vb = new VBox();
        Button add = new Button("Add Customer!");
        HoverAndStyle(add);
        add.setPrefWidth(400);
        add.setPrefHeight(40);
        add.setLayoutX(-100);
        add.setFont(Font.font("Tahoma", FontWeight.BOLD, FontPosture.ITALIC, 21));
        vb.setPadding(new Insets(-20, 0, 0, 30));
        vb.getChildren().add(add);
        add.setOnAction(e -> {
            if (!fName.getText().equals("") && !lName.getText().equals("") && Sex.getSelectedToggle().isSelected()) {
                validation v = new validation();
                if (v.CheckName(fName.getText())) {
                    if (v.CheckName(lName.getText())) {
                        if (v.checkId(Id.getText())) {
                            Employee Emp = new Employee();
                            Customer x = new Customer();
                            if (Emp.searchCustomer(Id.getText()) == null) {
                                x.setId(Id.getText());
                                x.setFrist_name(fName.getText());
                                x.setLast_name(lName.getText());
                                if (male.isSelected()) {
                                    x.setGender("Male");
                                } else {
                                    x.setGender("Female");
                                }
                                Emp.addCustomer(x);
                                fName.setText("");
                                lName.setText("");
                                Sex.selectToggle(null);
                                JOptionPane.showMessageDialog(null, "Done ...!");
                            } else {
                                JOptionPane.showMessageDialog(null, "The id is used before ...!");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Id is Wrong");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Last Name is Wrong");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "First Name is Wrong");
                }
            } else {
                JOptionPane.showMessageDialog(null, "There is something is missing ...!");
            }
        });
        //addall add node
        addall.getChildren().addAll(icon, customer, vb);
        addall.setPadding(new Insets(40, 0, 0, 250));
        return addall;
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
}
