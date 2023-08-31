package mytestaboutfx;

import A.Admin;
import A.Employee;
import A.validation;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class UpdateEmployeePane extends Application {

    @Override
    public void start(final Stage primaryStage) {

    }

    public static VBox UpdateEmployeePane() throws FileNotFoundException {
        Image imageUpdate = new Image(new FileInputStream("src/Icons/icons8_Available_Updates_80px.png"));
        ImageView imageViewUpdate = new ImageView(imageUpdate);
        Label Title = new Label("Update / Delete ", imageViewUpdate);
        Title.setFont(Font.font("Italic", FontWeight.NORMAL, 40));
        Title.setPadding(new Insets(0, 10, 30, 0));
        HBox Icon = new HBox();
        Icon.setAlignment(Pos.CENTER);
        Icon.getChildren().add(Title);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.BASELINE_CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 25, 25, 25));

        Label FristName = new Label(" Frist Name:");
        FristName.setFont(Font.font("fatoma", FontPosture.ITALIC, 20));
        grid.add(FristName, 0, 1);
        final TextField Fname = new TextField();
        grid.add(Fname, 1, 1);

        Label LastName = new Label(" Last Name:");
        LastName.setFont(Font.font("fatoma", FontPosture.ITALIC, 20));
        grid.add(LastName, 0, 2);
        final TextField Lname = new TextField();
        grid.add(Lname, 1, 2);

        Label UserName = new Label(" User Name:");
        UserName.setFont(Font.font("fatoma", FontPosture.ITALIC, 20));
        grid.add(UserName, 0, 3);
        final TextField Uname = new TextField();
        grid.add(Uname, 1, 3);

        Label Password = new Label(" Password:");
        Password.setFont(Font.font("fatoma", FontPosture.ITALIC, 20));
        grid.add(Password, 0, 4);
        final PasswordField Pasword = new PasswordField();
        grid.add(Pasword, 1, 4);

        Label age = new Label(" Age:");
        age.setFont(Font.font("fatoma", FontPosture.ITALIC, 20));
        grid.add(age, 0, 5);
        final TextField Age = new TextField();
        grid.add(Age, 1, 5);

        Label salary = new Label(" Salary:");
        salary.setFont(Font.font("fatoma", FontPosture.ITALIC, 20));
        grid.add(salary, 0, 6);
        final TextField Salary = new TextField();
        grid.add(Salary, 1, 6);

        Label phone = new Label(" Phone:");
        phone.setFont(Font.font("fatoma", FontPosture.ITALIC, 20));
        grid.add(phone, 0, 7);
        final TextField Phone = new TextField();
        grid.add(Phone, 1, 7);

        Label gender = new Label(" Gender:");
        gender.setFont(Font.font("fatoma", FontPosture.ITALIC, 20));
        grid.add(gender, 0, 8);

        ComboBox<String> c = new ComboBox<>();
        c.getItems().addAll("Male", "Female");
        c.setPromptText("Gender");
        grid.add(c, 1, 8);

        Button btnU = new Button("Update");
        btnU.setFont(Font.font("fatoma", FontPosture.ITALIC, 20));
        btnU.setStyle("-fx-background-radius: 15");
        grid.add(btnU, 3, 13);

        btnU.setStyle("-fx-background-radius:15 ;-fx-border-width: 2px;-fx-border-color: grey;-fx-text-fill: grey;-fx-border-radius: 15;-fx-background-color:white");
        btnU.setOnMouseExited(e -> {

            btnU.setStyle("-fx-background-radius:15 ;-fx-border-width: 2px;-fx-border-color: grey;-fx-text-fill: grey;-fx-border-radius: 15;-fx-background-color:white");
        });
        btnU.setOnMouseMoved(e -> {
            btnU.setStyle("-fx-border-color:black ;-fx-text-fill:black;-fx-border-width: 2px;-fx-background-radius:15 ;-fx-border-radius: 15;-fx-background-color:white");
        });

        Button btnD = new Button("Delete ");
        btnD.setFont(Font.font("fatoma", FontPosture.ITALIC, 20));
        btnD.setStyle("-fx-background-radius: 15");
        grid.add(btnD, 0, 13);

        btnD.setStyle("-fx-background-radius:15 ;-fx-border-width: 2px;-fx-border-color: grey;-fx-text-fill: grey;-fx-border-radius: 15;-fx-background-color:white");
        btnD.setOnMouseExited(e -> {

            btnD.setStyle("-fx-background-radius:15 ;-fx-border-width: 2px;-fx-border-color: grey;-fx-text-fill: grey;-fx-border-radius: 15;-fx-background-color:white");
        });
        btnD.setOnMouseMoved(e -> {
            btnD.setStyle("-fx-border-color:black ;-fx-text-fill:black;-fx-border-width: 2px;-fx-background-radius:15 ;-fx-border-radius: 15;-fx-background-color:white");
        });

        GridPane grid2 = new GridPane();
        grid2.setPadding(new Insets(50, 50, 50, 50));
        grid2.setAlignment(Pos.TOP_CENTER);

        Label Id = new Label("Enter ID: ");
        Id.setFont(Font.font("fatoma", FontPosture.ITALIC, 25));
        grid2.add(Id, 0, 0);
        final TextField Search = new TextField();
        Search.setFont(Font.font("fatoma", FontPosture.ITALIC, 15));
        Search.setStyle("-fx-background-radius: 20");
        Search.setMaxHeight(10);
        Search.setPromptText("Enter ID ");
        grid2.add(Search, 1, 0);

        Button btnS = new Button("Search");
        btnS.setFont(Font.font("fatoma", FontPosture.ITALIC, 20));

        btnS.setStyle("-fx-background-radius:15 ;-fx-border-width: 2px;-fx-border-color: grey;-fx-text-fill: grey;-fx-border-radius: 15;-fx-background-color:white");
        btnS.setOnMouseExited(e -> {

            btnS.setStyle("-fx-background-radius:15 ;-fx-border-width: 2px;-fx-border-color: grey;-fx-text-fill: grey;-fx-border-radius: 15;-fx-background-color:white");
        });
        btnS.setOnMouseMoved(e -> {
            btnS.setStyle("-fx-border-color:black ;-fx-text-fill:black;-fx-border-width: 2px;-fx-background-radius:15 ;-fx-border-radius: 15;-fx-background-color:white");
        });
        btnS.setOnAction(e -> {
            if (!Search.getText().equals("")) {
                Admin Adn = new Admin();
                Employee Emp = Adn.searchEmployee(Search.getText());
                if (Emp != null) {
                    Fname.setText(Emp.getFrist_name());
                    Lname.setText(Emp.getLast_name());
                    Uname.setText(Emp.getUsername());
                    Pasword.setText(Emp.getPassword());
                    Age.setText(Integer.toString(Emp.getAge()));
                    Salary.setText(Double.toString(Emp.getSalary()));
                    Phone.setText(Emp.getPhone());
                    if (Emp.getGender().equals("Male")) {
                        c.setValue("Male");
                    } else {
                        c.setValue("Female");
                    }
                } else {
                    Search.setText("");
                    JOptionPane.showMessageDialog(null, "Not Found ...!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please, entre the id ...!");
            }
        });
        btnD.setOnAction(e -> {
            if (!Search.getText().equals("") && !Fname.getText().equals("") && !Lname.getText().equals("")
                    && !Phone.getText().equals("") && !Password.getText().equals("") && !Age.getText().equals("")
                    && !Salary.getText().equals("") && !Uname.getText().equals("") && !c.getSelectionModel().isEmpty()) {
                Admin Adn = new Admin();
                Adn.deleteEmployee(Search.getText());
                Fname.setText("");
                Lname.setText("");
                Uname.setText("");
                Pasword.setText("");
                Age.setText("");
                Salary.setText("");
                Phone.setText("");
                Search.setText("");
                c.getSelectionModel().clearSelection();
                JOptionPane.showMessageDialog(null, "Done ...!");
            } else {
                JOptionPane.showMessageDialog(null, "There is field is missing ...!");
            }
        });
        btnU.setOnAction(e -> {
            if (!Search.getText().equals("") && !Fname.getText().equals("") && !Lname.getText().equals("")
                    && !Phone.getText().equals("") && !Password.getText().equals("") && !Age.getText().equals("")
                    && !Salary.getText().equals("") && !Uname.getText().equals("") && !c.getSelectionModel().isEmpty()) {

                validation v = new validation();
                if (v.CheckName(Fname.getText())) {
                    if (v.CheckName(Lname.getText())) {
                        if (v.checkAge(Age.getText())) {
                            if (v.checkPhone(Phone.getText())) {
                                if (v.checkSalary(Salary.getText())) {
                                    if (v.checkUsername(Uname.getText())) {
                                        if (v.checkPassword(Pasword.getText())) {

                                            Admin Adn = new Admin();
                                            Employee Emp = new Employee();
                                            Emp.setFrist_name(Fname.getText());
                                            Emp.setLast_name(Lname.getText());
                                            Emp.setUsername(Uname.getText());
                                            Emp.setPassword(Pasword.getText());
                                            Emp.setAge(Integer.parseInt(Age.getText()));
                                            Emp.setSalary(Double.parseDouble(Salary.getText()));
                                            Emp.setPhone(Phone.getText());
                                            Emp.setGender(c.getValue());
                                            Emp.setId(Search.getText());
                                            Adn.updateEmployee(Search.getText(), Emp);
                                            Search.setText("");
                                            Fname.setText("");
                                            Lname.setText("");
                                            Uname.setText("");
                                            Pasword.setText("");
                                            Age.setText("");
                                            Salary.setText("");
                                            Phone.setText("");
                                            c.getSelectionModel().clearSelection();

                                        } else {
                                            JOptionPane.showMessageDialog(null, "The Password Is Wrong");
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "The Username Is Wrong");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "The Salary Is Wrong");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "The Phone Is Wrong");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "The Age Is Wrong");
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "The Last Name Is Wrong");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "The First Name Is Wrong");
                }

            } else {
                JOptionPane.showMessageDialog(null, "There is field is missing ...!");
            }
        });

        HBox hb = new HBox();

        hb.setPadding(
                new Insets(20, 20, 20, 20));
        hb.getChildren()
                .add(btnS);
        grid2.add(hb,
                3, 0);

        //grid2.setStyle("-fx-background-color: linear-gradient(gray, lightgray)");
        //grid.setStyle("-fx-background-color:linear-gradient(lightgray, rosybrown)");
        BorderPane bp = new BorderPane();

        bp.setTop(grid2);

        bp.setCenter(grid);

        VBox box = new VBox();

        box.getChildren()
                .addAll(Icon, bp);

        return box;
    }

}
