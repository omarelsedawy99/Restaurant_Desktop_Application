package mytestaboutfx;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;

public class AdminPane extends Application {

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {

        HBox Main = new HBox();
        VBox Left = new VBox();

        Left.setMinWidth(280);
        Left.setPadding(new Insets(20));

        VBox Right = new VBox();
        Right.setMinWidth(770);

        Image image = new Image(new FileInputStream("src/Icons/icons8_Administrator_Male_96px_1.png"));
        ImageView imageView = new ImageView(image);
        Label Admin = new Label();
        Admin.setGraphic(imageView);
        Admin.setPadding(new Insets(10, 10, 10, 60));
        Left.getChildren().add(Admin);

        BackgroundFill background_fill = new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(background_fill);
        Left.setBackground(background);

        //////Left Part Add Employee
        Image ImageAdEmp = new Image(new FileInputStream("src/Icons/icons8_Add_User_Male_40px.png"));
        ImageView imageViewAdEmp = new ImageView(ImageAdEmp);
        Label LAddEmployee = new Label("Add Employee", imageViewAdEmp);
        LAddEmployee.setPadding(new Insets(20, 5, 0, 0));
        LAddEmployee.setTextFill(Color.WHITE);
        ChangeFont(LAddEmployee);
        Left.getChildren().add(LAddEmployee);

        ///// Search /////
        Image ImageSearch = new Image(new FileInputStream("src/Icons/icons8_Search_Property_40px.png"));
        ImageView imageViewSearch = new ImageView(ImageSearch);
        Label LSearch = new Label("Update/Delete", imageViewSearch);
        LSearch.setPadding(new Insets(20, 5, 0, 0));
        LSearch.setTextFill(Color.WHITE);
        ChangeFont(LSearch);
        Left.getChildren().add(LSearch);

        /////// List All Employess ////
        Image ImageList = new Image(new FileInputStream("src/Icons/icons8_List_40px_2.png"));
        ImageView imageViewList = new ImageView(ImageList);
        Label LList = new Label("List Employess", imageViewList);
        LList.setPadding(new Insets(20, 5, 0, 0));
        LList.setTextFill(Color.WHITE);
        ChangeFont(LList);
        Left.getChildren().add(LList);

        ///// ManageMeals/////
        Image ImageManageMeals = new Image(new FileInputStream("src/Icons/icons8_Meal_40px.png"));
        ImageView imageViewManageMeals = new ImageView(ImageManageMeals);
        Label LMangeMeals = new Label("Manage Meals", imageViewManageMeals);
        LMangeMeals.setPadding(new Insets(20, 5, 0, 0));
        LMangeMeals.setTextFill(Color.WHITE);
        ChangeFont(LMangeMeals);
        Left.getChildren().add(LMangeMeals);

        /////////Update Info///
        Image ImageUpdateInfo = new Image(new FileInputStream("src/Icons/icons8_More_Info_40px.png"));
        ImageView imageViewUpdateInfo = new ImageView(ImageUpdateInfo);
        Label LUpdateInfo = new Label("Update Info", imageViewUpdateInfo);
        LUpdateInfo.setPadding(new Insets(20, 5, 0, 0));
        LUpdateInfo.setTextFill(Color.WHITE);
        ChangeFont(LUpdateInfo);
        Left.getChildren().add(LUpdateInfo);

        ////////Gifts/////
        Image ImageGifts = new Image(new FileInputStream("src/Icons/icons8_Gift_40px.png"));
        ImageView imageViewGifts = new ImageView(ImageGifts);
        Label LGifts = new Label("Gifts", imageViewGifts);
        LGifts.setPadding(new Insets(20, 5, 0, 0));
        LGifts.setTextFill(Color.WHITE);
        ChangeFont(LGifts);
        Left.getChildren().add(LGifts);

        ///////Reward Programs//////
        Image ImageReward = new Image(new FileInputStream("src/Icons/icons8_Trophy_40px_1.png"));
        ImageView imageViewReward = new ImageView(ImageReward);
        Label LReward = new Label("Reward Program", imageViewReward);
        LReward.setPadding(new Insets(20, 5, 0, 0));
        LReward.setTextFill(Color.WHITE);
        ChangeFont(LReward);
        Left.getChildren().add(LReward);

        ///////reports////
        Image ImageReport = new Image(new FileInputStream("src/Icons/icons8_Graph_Report_40px.png"));
        ImageView imageViewReport = new ImageView(ImageReport);
        Label LReport = new Label("Reports", imageViewReport);
        LReport.setPadding(new Insets(20, 5, 0, 0));
        LReport.setTextFill(Color.WHITE);
        ChangeFont(LReport);
        Left.getChildren().add(LReport);

        ///////Offers////
        Image ImageOffer = new Image(new FileInputStream("src/Icons/icons8_Discount_40px.png"));
        ImageView imageViewOffer = new ImageView(ImageOffer);
        Label LOffer = new Label("Offers", imageViewOffer);
        LOffer.setPadding(new Insets(20, 5, 0, 0));
        LOffer.setTextFill(Color.WHITE);
        ChangeFont(LOffer);
        Left.getChildren().add(LOffer);

        ////////Log Out////////
        Image ImageLogOut = new Image(new FileInputStream("src/Icons/icons8_Logout_Rounded_Left_40px.png"));
        ImageView imageViewLogOut = new ImageView(ImageLogOut);
        Label LLogOut = new Label("Log Out", imageViewLogOut);
        LLogOut.setPadding(new Insets(20, 5, 0, 0));
        LLogOut.setTextFill(Color.WHITE);
        ChangeFont(LLogOut);
        Left.getChildren().add(LLogOut);

        ///////Panes From Classes////
        GridPane RootAdd = AddEmployeePane.AddEmployeePane();
        VBox RootMeals = ManageMeals.ManageMealsPane();
        VBox RootGifts = GiftsPane.GiftPane();
        VBox RootUpdateInfo = UpdateInfoPane.UpdaeInfoPane();
        VBox RootReport = ReportPane.ReportPane();
        VBox RootRewardProgram = RewardProgramPane.RewardProgramPane();
        VBox RootUpdeteEmployee = UpdateEmployeePane.UpdateEmployeePane();
        VBox RootOffers = OfferPane.OfferPane();

        /////Set Add Employee At First of Admin Jobs
        Right.getChildren().add(RootAdd);
        SetColor(LAddEmployee);
        ///////Actions////

        LAddEmployee.setOnMousePressed(e -> {
            Right.getChildren().clear();
            resetAllLabelsColor(LAddEmployee, LSearch, LList, LMangeMeals, LUpdateInfo, LGifts, LReward, LReport, LOffer);
            Right.getChildren().add(RootAdd);
            SetColor(LAddEmployee);

        });
        LSearch.setOnMousePressed(e -> {
            Right.getChildren().clear();
            resetAllLabelsColor(LAddEmployee, LSearch, LList, LMangeMeals, LUpdateInfo, LGifts, LReward, LReport, LOffer);
            Right.getChildren().add(RootUpdeteEmployee);
            SetColor(LSearch);
        });
        LList.setOnMousePressed(e -> {
            Right.getChildren().clear();
            VBox RootList;
            try {
                RootList = ListAllEmployeesPane.ListAllEmployeesPane();
                resetAllLabelsColor(LAddEmployee, LSearch, LList, LMangeMeals, LUpdateInfo, LGifts, LReward, LReport, LOffer);
                Right.getChildren().add(RootList);
                SetColor(LList);

            } catch (FileNotFoundException ex) {
                Logger.getLogger(AdminPane.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        LMangeMeals.setOnMousePressed(e -> {
            Right.getChildren().clear();
            resetAllLabelsColor(LAddEmployee, LSearch, LList, LMangeMeals, LUpdateInfo, LGifts, LReward, LReport, LOffer);
            Right.getChildren().add(RootMeals);
            SetColor(LMangeMeals);

        });
        LUpdateInfo.setOnMousePressed(e -> {
            Right.getChildren().clear();
            resetAllLabelsColor(LAddEmployee, LSearch, LList, LMangeMeals, LUpdateInfo, LGifts, LReward, LReport, LOffer);
            Right.getChildren().add(RootUpdateInfo);
            SetColor(LUpdateInfo);

        });
        LGifts.setOnMousePressed(e -> {
            Right.getChildren().clear();
            resetAllLabelsColor(LAddEmployee, LSearch, LList, LMangeMeals, LUpdateInfo, LGifts, LReward, LReport, LOffer);
            Right.getChildren().add(RootGifts);
            SetColor(LGifts);

        });
        LReward.setOnMousePressed(e -> {
            Right.getChildren().clear();
            resetAllLabelsColor(LAddEmployee, LSearch, LList, LMangeMeals, LUpdateInfo, LGifts, LReward, LReport, LOffer);
            Right.getChildren().add(RootRewardProgram);
            SetColor(LReward);
        });
        LReport.setOnMousePressed(e -> {
            Right.getChildren().clear();
            resetAllLabelsColor(LAddEmployee, LSearch, LList, LMangeMeals, LUpdateInfo, LGifts, LReward, LReport, LOffer);
            Right.getChildren().add(RootReport);
            SetColor(LReport);

        });

        LOffer.setOnMousePressed(e -> {
            Right.getChildren().clear();
            resetAllLabelsColor(LAddEmployee, LSearch, LList, LMangeMeals, LUpdateInfo, LGifts, LReward, LReport, LOffer);
            Right.getChildren().add(RootOffers);
            SetColor(LOffer);

        });
        LLogOut.setOnMousePressed(e -> {
            primaryStage.close();
            Stage s = new Stage();
            login x = new login();
            x.start(s);
        });
        /////////////////
        Right.setAlignment(Pos.TOP_CENTER);
        Right.setPadding(new Insets(30, 5, 10, 5));
        Main.getChildren().addAll(Left, Right);
        Scene scene = new Scene(Main, 1050, 800);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Admin");
        primaryStage.show();

    }

    public void SetColor(Label l) {
        l.setTextFill(Color.BLUE);
    }

    public void ResetColor(Label l) {
        l.setTextFill(Color.WHITE);
    }

    public void ChangeFont(Label l) {
        l.setFont(Font.font("fatoma", FontPosture.ITALIC, 25));
    }

    public void resetAllLabelsColor(Label L1, Label L2, Label L3, Label L4, Label L5, Label L6, Label L7, Label L8, Label L9) {
        ResetColor(L1);
        ResetColor(L2);
        ResetColor(L3);
        ResetColor(L4);
        ResetColor(L5);
        ResetColor(L6);
        ResetColor(L7);
        ResetColor(L8);
        ResetColor(L9);

    }

}
