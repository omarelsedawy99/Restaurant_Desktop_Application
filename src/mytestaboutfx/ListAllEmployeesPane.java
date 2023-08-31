package mytestaboutfx;

import A.Employee;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ListAllEmployeesPane extends Application {

    @Override
    public void start(Stage primaryStage) {

    }

    public static ObservableList<Employee> setData() {
        Employee x = new Employee();
        ArrayList<Employee> allEmp = new ArrayList();
        allEmp = (ArrayList<Employee>) x.list();
        ObservableList<Employee> Data = FXCollections.observableArrayList();
        for (int i = 0; i < allEmp.size(); i++) {
            Data.add(allEmp.get(i));
        }
        return Data;
    }

    public static VBox ListAllEmployeesPane() throws FileNotFoundException {

        Image imageList = new Image(new FileInputStream("src/Icons/icons8_List_70px.png"));
        ImageView imageViewList = new ImageView(imageList);
        Label Title = new Label(" List ALL Employee", imageViewList);
        Title.setFont(Font.font("Italic", FontWeight.NORMAL, 40));
        Title.setPadding(new Insets(0, 10, 30, 0));

        TableView<Employee> table = new TableView<>();
        TableColumn<Employee, String> FNameCol = new TableColumn<>("First Name");
        TableColumn<Employee, String> LNameCol = new TableColumn<>("Last Name");
        TableColumn<Employee, String> IdCol = new TableColumn<>("ID");
        TableColumn<Employee, Integer> AgeCol = new TableColumn<>("Age");
        TableColumn<Employee, String> GenderCol = new TableColumn<>("Gender");
        TableColumn<Employee, Double> SalaryCol = new TableColumn<>("Salary");
        TableColumn<Employee, String> PhoneCol = new TableColumn<>("Phone");
        TableColumn<Employee, String> UsernameCol = new TableColumn<>("Username");
        TableColumn<Employee, String> PasswordCol = new TableColumn<>("Password");

        FNameCol.setCellValueFactory(new PropertyValueFactory<>("Frist_name"));
        LNameCol.setCellValueFactory(new PropertyValueFactory<>("Last_name"));
        IdCol.setCellValueFactory(new PropertyValueFactory<>("Id"));
        AgeCol.setCellValueFactory(new PropertyValueFactory<>("Age"));
        GenderCol.setCellValueFactory(new PropertyValueFactory<>("Gender"));
        SalaryCol.setCellValueFactory(new PropertyValueFactory<>("Salary"));
        PhoneCol.setCellValueFactory(new PropertyValueFactory<>("Phone"));
        UsernameCol.setCellValueFactory(new PropertyValueFactory<>("Username"));
        PasswordCol.setCellValueFactory(new PropertyValueFactory<>("Password"));

        table.setMinWidth(720);
        FNameCol.setMinWidth(83);
        LNameCol.setMinWidth(83);
        IdCol.setMinWidth(83);
        AgeCol.setMinWidth(83);
        GenderCol.setMinWidth(83);
        SalaryCol.setMinWidth(83);
        PhoneCol.setMinWidth(82);
        UsernameCol.setMinWidth(82);
        PasswordCol.setMinWidth(86);

        table.getColumns().addAll(FNameCol, LNameCol, IdCol, AgeCol, GenderCol, SalaryCol, PhoneCol, UsernameCol, PasswordCol);
        table.setItems(setData());
        table.setMinHeight(650);
        VBox root = new VBox();
        root.setPadding(new Insets(5));
        root.getChildren().add(Title);
        root.getChildren().add(table);
        return root;

    }
}
