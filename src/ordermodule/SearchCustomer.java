package ordermodule;

import A.Customer;
import A.Employee;
import A.Order;
import A.validation;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
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

public class SearchCustomer extends Application {

    @Override
    public void start(Stage primaryStage) {
    }

    public static VBox getSearchCustomer() throws FileNotFoundException {
        GridPane gpane = new GridPane();
        VBox root = new VBox();
        gpane.setVgap(30);
        gpane.setHgap(30);
        gpane.setPadding(new Insets(0, 0, 0, 30));
        root.setSpacing(30);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(0, 0, 0, 30));
        //----------hbox for search ------------
        VBox search = new VBox();
        search.setSpacing(15);
        Image ImageUpdateCustomer = new Image(new FileInputStream("src/Icons/icons8_Change_User_96px.png"));
        ImageView imageViewUpdateCustomer = new ImageView(ImageUpdateCustomer);
        Label title = new Label("", imageViewUpdateCustomer);
        title.setFont(Font.font("Tahoma", FontWeight.BLACK, FontPosture.ITALIC, 20));
        title.setLayoutX(10);
        title.setPadding(new Insets(0, 0, 0, 150));
        search.setPadding(new Insets(0, 0, 0, 30));
        HBox vb = new HBox();
        vb.setLayoutX(35);
        vb.setSpacing(30);
        TextField searchT = new TextField();
        searchT.setPromptText("Enter ID");
        Button searchB = new Button("Search");
        searchB.setPrefWidth(120);
        searchB.setPrefHeight(20);
        HoverAndStyle(searchB);

        searchT.setPrefWidth(250);
        vb.getChildren().addAll(searchB, searchT);
        search.getChildren().addAll(title, vb);

        //------------//Node of First name//------
        Text fname = new Text("First Name :");
        fname.setFont(Font.font("Tahoma", FontWeight.BOLD, FontPosture.ITALIC, 20));
        gpane.add(fname, 0, 0);
        TextField fName = new TextField();
        fName.setPrefWidth(250);
        gpane.add(fName, 1, 0);

        //-------------//node of LastName//-------
        Text lname = new Text("Last Name :");
        lname.setFont(Font.font("Tahoma", FontWeight.BOLD, FontPosture.ITALIC, 20));
        gpane.add(lname, 0, 1);
        TextField lName = new TextField();
        lName.setPrefWidth(250);
        gpane.add(lName, 1, 1);

        //------------//node of gender//-----------
        Text gender = new Text("Gender :");
        gender.setFont(Font.font("Tahoma", FontWeight.BOLD, FontPosture.ITALIC, 20));
        gpane.add(gender, 0, 2);
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
        gpane.add(hb, 1, 2);
        //Text Array For Order and gist 
        VBox order = new VBox();
        order.setPadding(new Insets(0, 0, 0, 30));
        Text tx = new Text("Order :-  ");
        tx.setFont(Font.font("Fatoma", FontPosture.ITALIC, 20));
        TextArea ta = new TextArea();
        ta.setMaxWidth(420);
        ta.setMinHeight(200);
        ta.setPrefHeight(150);
        order.getChildren().addAll(tx, ta);

        HBox v = new HBox();
        v.setSpacing(180);
        v.setPadding(new Insets(0, 0, 0, 30));
        Button update = new Button("Update");
        update.setPrefWidth(120);
        update.setPrefHeight(30);
        update.setFont(Font.font("Fatoma", FontWeight.BOLD, FontPosture.ITALIC, 20));
        HoverAndStyle(update);
        Button delet = new Button("Delete");
        delet.setPrefWidth(120);
        delet.setPrefHeight(30);
        delet.setFont(Font.font("Fatoma", FontWeight.BOLD, FontPosture.ITALIC, 20));
        HoverAndStyle(delet);
        v.getChildren().addAll(update, delet);
        searchB.setOnAction(e -> {
            if (!searchT.getText().equals("")) {
                Employee Emp = new Employee();
                Customer customer = Emp.searchCustomer(searchT.getText());
                if (customer != null) {
                    fName.setText(customer.getFrist_name());
                    lName.setText(customer.getLast_name());
                    if (customer.getGender().equals("Male")) {
                        Sex.selectToggle(male);
                    } else {
                        Sex.selectToggle(female);
                    }
                    ArrayList<Order> list = Emp.getOrdersIndexse(searchT.getText());
                    if (list == null) {
                        list = new ArrayList();
                    }
                    if (!list.isEmpty()) {
                        ta.setText(convertToString(list));
                    }
                    ta.setText("");
                    ta.setEditable(false);
                } else {
                    JOptionPane.showMessageDialog(null, "This customer not found ...!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please, entre the id ...!");
            }
        });
        update.setOnAction(e -> {
            if (!fName.getText().equals("") && !lName.getText().equals("") && Sex.getSelectedToggle().isSelected()) {
                validation val = new validation();
                if (val.CheckName(fName.getText())) {
                    if (val.CheckName(lName.getText())) {
                        Employee Emp = new Employee();
                        Customer customer = new Customer();
                        customer.setFrist_name(fName.getText());
                        customer.setLast_name(lName.getText());
                        if (male.isSelected()) {
                            customer.setGender("Male");
                        } else {
                            customer.setGender("Female");
                        }
                        Emp.updateCustomer(searchT.getText(), customer);
                        fName.setText("");
                        lName.setText("");
                        ta.setText("");
                        Sex.selectToggle(null);

                    } else {
                        JOptionPane.showMessageDialog(null, "Last Name is Wrong");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "First Name is Wrong");
                }

            } else {
                JOptionPane.showMessageDialog(null, "There is field is missing ...!");
            }
        });
        delet.setOnAction(e -> {
            if (!fName.getText().equals("") && !lName.getText().equals("") && Sex.getSelectedToggle().isSelected()) {
                Employee Emp = new Employee();
                Emp.deleteCustomer(searchT.getText());
                fName.setText("");
                lName.setText("");
                Sex.selectToggle(null);
                ta.setText("");
                JOptionPane.showMessageDialog(null, "Done ...!");
            } else {
                JOptionPane.showMessageDialog(null, "There is field is missing ...!");
            }
        });

        root.getChildren().addAll(search, gpane, order, v);
        root.setPadding(new Insets(50, 100, 100, 250));
        return root;
    }

    public static String convertToString(ArrayList<Order> x) {
        String str = "";
        for (int i = 0; i < x.size(); i++) {
            str = "Order id : " + x.get(i).getId() + "\n";
            for (int y = 0; y < x.get(i).getMealArrayList().size(); y++) {
                str += x.get(i).getMealArrayList().get(i).getId() + "    "
                        + x.get(i).getMealArrayList().get(i).getMealName() + "    "
                        + x.get(i).getMealArrayList().get(i).getMealPrice() + "\n";
            }
            str += "\n\n";
        }
        return str;
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
