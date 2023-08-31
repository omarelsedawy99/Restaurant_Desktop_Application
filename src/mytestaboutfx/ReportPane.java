package mytestaboutfx;

import A.Admin;
import A.Customer;
import A.Employee;
import A.Report;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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

public class ReportPane extends Application {

    @Override
    public void start(Stage primaryStage) {
    }

    public static VBox ReportPane() throws FileNotFoundException {
        Image imageReport = new Image(new FileInputStream("src/Icons/icons8_Hand_With_Pen_80px.png"));
        ImageView imageViewReport = new ImageView(imageReport);
        Label Title = new Label("Report", imageViewReport);
        Title.setFont(Font.font("Italic", FontWeight.NORMAL, 40));
        Title.setPadding(new Insets(0, 10, 30, 0));
        HBox Icon = new HBox();
        Icon.setAlignment(Pos.CENTER);
        Icon.getChildren().add(Title);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(100, 25, 25, 25));

        Label Position = new Label(" Position:");
        Position.setFont(Font.font("fatoma", FontPosture.ITALIC, 20));
        grid.add(Position, 0, 1);

        ComboBox<String> c = new ComboBox<>();
        c.getItems().addAll("Empolyee", "Customer");
        c.setPromptText("Position");
        c.setMaxWidth(200);
        c.setStyle("-fx-background-radius:15;-fx-border-radius: 15");
        grid.add(c, 1, 1);

        Label ID = new Label(" ID: ");
        ID.setFont(Font.font("fatoma", FontPosture.ITALIC, 20));
        grid.add(ID, 0, 2);
        final TextField Id = new TextField();
        Id.setStyle("-fx-background-radius: 20");
        Id.setPromptText("Enter ID ");
        grid.add(Id, 1, 2);

        GridPane grid2 = new GridPane();
        grid2.setPadding(new Insets(20, 25, 25, 25));
        grid2.setAlignment(Pos.BASELINE_CENTER);
        final TextArea Report = new TextArea();
        Label Comment = new Label(" Comments: ");
        Comment.setFont(Font.font("fatoma", FontPosture.ITALIC, 20));
        grid2.add(Comment, 0, 1);
        Report.setStyle("-fx-background-radius: 20;");
        grid2.add(Report, 0, 3);

        Button btnS = new Button("submit");
        btnS.setFont(Font.font("fatoma", FontPosture.ITALIC, 20));
        btnS.setStyle("-fx-background-radius:15 ;-fx-border-width: 2px;-fx-border-color: grey;-fx-text-fill: grey;-fx-border-radius: 15;-fx-background-color:white");
        btnS.setOnMouseExited(e -> {

            btnS.setStyle("-fx-background-radius:15 ;-fx-border-width: 2px;-fx-border-color: grey;-fx-text-fill: grey;-fx-border-radius: 15;-fx-background-color:white");
        });
        btnS.setOnMouseMoved(e -> {
            btnS.setStyle("-fx-border-color:black ;-fx-text-fill:black;-fx-border-width: 2px;-fx-background-radius:15 ;-fx-border-radius: 15;-fx-background-color:white");
        });
        btnS.setOnAction(e -> {
            Admin Adn = new Admin();
            Report report = new Report();
            if (!Id.getText().equals("") && !c.getSelectionModel().isEmpty()) {
                report.setContent(Report.getText());
                if (c.getValue().equals("Customer")) {
                    int exist = new Customer().search(Id.getText());
                    if (exist != -1) {
                        report.setCustomer_id(Id.getText());
                        Adn.addReport(report);
                        Id.setText("");
                        Report.setText("");
                        c.getSelectionModel().clearSelection();
                        JOptionPane.showMessageDialog(null, "Done ...!");
                    } else {
                        JOptionPane.showMessageDialog(null, "The id of customer is wrong ...!");
                    }
                }
                if (c.getValue().equals("Empolyee")) {
                    int exist = new Employee().search(Id.getText());
                    if (exist != -1) {
                        report.setEmployee_id(Id.getText());
                        Adn.addReport(report);
                        Id.setText("");
                        Report.setText("");
                        c.getSelectionModel().clearSelection();
                        JOptionPane.showMessageDialog(null, "Done ...!");
                    } else {
                        JOptionPane.showMessageDialog(null, "The id of employee is wrong ...!");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "There is field is missing ...!");
            }
        });
        btnS.setPadding(new Insets(5, 50, 5, 50));
        HBox hb = new HBox();
        hb.setPadding(new Insets(20, 300, 20, 300));
        hb.getChildren().add(btnS);

        //grid.setStyle("-fx-background-color: linear-gradient(lightslategrey, lightgray)");
        //grid2.setStyle("-fx-background-color:linear-gradient(lightgray, lightslategrey)");
        BorderPane bp = new BorderPane();
        bp.setTop(grid);
        bp.setCenter(grid2);
        bp.setBottom(hb);
        //Scene scene = new Scene(bp, 800, 600);
        VBox vb = new VBox();
        vb.getChildren().addAll(Icon, bp);
        return vb;

    }

}
