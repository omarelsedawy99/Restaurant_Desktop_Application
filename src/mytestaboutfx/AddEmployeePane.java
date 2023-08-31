package mytestaboutfx;

import A.Admin;
import A.Employee;
import A.validation;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class AddEmployeePane extends Application {

    static GridPane g = new GridPane();

    @Override
    public void start(Stage primaryStage) {

    }

    public static GridPane AddEmployeePane() throws FileNotFoundException {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Image imageAdd = new Image(new FileInputStream("src/Icons/icons8_Add_User_Male_80px.png"));
        ImageView imageViewAdd = new ImageView(imageAdd);
        Label Title = new Label(" Adding Employee", imageViewAdd);
        Title.setFont(Font.font("Italic", FontWeight.NORMAL, 40));
        Title.setPadding(new Insets(0, 10, 30, 0));
        grid.add(Title, 0, 0, 2, 1);

        Label FName = new Label("First Name:");
        grid.add(FName, 0, 1);
        TextField SFName = new TextField();
        grid.add(SFName, 1, 1);
        ChangeFont(FName, SFName);

        Label LName = new Label("Last Name:");
        grid.add(LName, 0, 2);
        TextField SLName = new TextField();
        grid.add(SLName, 1, 2);
        ChangeFont(LName, SLName);

        Label Id = new Label("ID:");
        grid.add(Id, 0, 3);
        TextField SId = new TextField();
        grid.add(SId, 1, 3);
        ChangeFont(Id, SId);

        Label Age = new Label("Age:");
        grid.add(Age, 0, 4);
        TextField SAge = new TextField();
        grid.add(SAge, 1, 4);
        ChangeFont(Age, SAge);

        Label Phone = new Label("Phone:");
        grid.add(Phone, 0, 5);
        TextField SPhone = new TextField();
        grid.add(SPhone, 1, 5);
        ChangeFont(Phone, SPhone);

        Label Salary = new Label("Salary:");
        grid.add(Salary, 0, 6);
        TextField SSalary = new TextField();
        grid.add(SSalary, 1, 6);
        ChangeFont(Salary, SSalary);

        Label Gender = new Label("Gender:");
        Gender.setFont(Font.font("fatoma", FontPosture.ITALIC, 25));
        grid.add(Gender, 0, 7);
        ComboBox<String> CGender = new ComboBox<>();
        CGender.getItems().addAll(
                "Male", "Female"
        );
        CGender.setPromptText("Gender");
        grid.add(CGender, 1, 7);

        Label Username = new Label("Username:");
        grid.add(Username, 0, 8);
        TextField SUsername = new TextField();
        grid.add(SUsername, 1, 8);
        ChangeFont(Username, SUsername);

        Label Password = new Label("Password:");
        grid.add(Password, 0, 9);
        TextField SPassword = new TextField();
        grid.add(SPassword, 1, 9);
        ChangeFont(Password, SPassword);

        Image image1 = new Image(new FileInputStream("src/Icons/icons8_Save_48px.png"));
        ImageView imageView1 = new ImageView(image1);
        Label SavaEmp = new Label("Add", imageView1);
        SavaEmp.setTextFill(Color.web("#0076a3"));
        SavaEmp.setFont(Font.font("Italic", FontWeight.BOLD, 40));
        grid.add(SavaEmp, 1, 11);

        SavaEmp.setOnMouseEntered(e -> {
            SavaEmp.setTextFill(Color.BLACK);
        });

        SavaEmp.setOnMouseExited(e -> {
            SavaEmp.setTextFill(Color.web("#0076a3"));
        });

        SavaEmp.setOnMouseClicked(e -> {
            if (!SFName.getText().equals("") && !SLName.getText().equals("") && !SAge.getText().equals("") && !SPhone.getText().equals("")
                    && !SId.getText().equals("") && !SPassword.getText().equals("") && !SUsername.getText().equals("") && !SSalary.getText().equals("")
                        && !CGender.getSelectionModel().isEmpty()) {

                validation v = new validation();
                if (v.CheckName(SFName.getText())) {
                    if (v.CheckName(SLName.getText())) {
                        if (v.checkId(SId.getText())) {
                            if (v.checkAge(SAge.getText())) {
                                if (v.checkPhone(SPhone.getText())) {
                                    if (v.checkSalary(SSalary.getText())) {
                                        if (v.checkUsername(SUsername.getText())) {
                                            if (v.checkPassword(SPassword.getText())) {
                                                Admin Adn = new Admin();
                                                if (Adn.searchEmployee(SId.getText()) == null) {
                                                    Employee New_Emp = new Employee();
                                                    New_Emp.setFrist_name(SFName.getText());
                                                    New_Emp.setLast_name(SLName.getText());
                                                    New_Emp.setAge(Integer.parseInt(SAge.getText()));
                                                    New_Emp.setId(SId.getText());
                                                    New_Emp.setPassword(SPassword.getText());
                                                    New_Emp.setPhone(SPhone.getText());
                                                    New_Emp.setSalary(Double.parseDouble(SSalary.getText()));
                                                    New_Emp.setUsername(SUsername.getText());
                                                    New_Emp.setGender(CGender.getValue());

                                                    Adn.addEmployee(New_Emp);

                                                    SFName.setText("");
                                                    SLName.setText("");
                                                    SId.setText("");
                                                    SAge.setText("");
                                                    SUsername.setText("");
                                                    SPassword.setText("");
                                                    SPhone.setText("");
                                                    SSalary.setText("");
                                                    JOptionPane.showMessageDialog(null, "Saved");
                                                } else {
                                                    JOptionPane.showMessageDialog(null, "This id is exist before");
                                                }
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
                            JOptionPane.showMessageDialog(null, "The ID Is Wrong");
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

        g = grid;
        return g;
    }

    public static void ChangeFont(Label l, TextField f) {
        f.setFont(Font.font("Fatoma", FontWeight.THIN, 15));
        l.setFont(Font.font("fatoma", FontPosture.ITALIC, 25));

    }

}
