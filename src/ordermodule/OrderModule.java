package ordermodule;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;
import mytestaboutfx.login;

public class OrderModule extends Application {

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        Stage window;
        window = primaryStage;
        VBox MakeOrderModule = OrderModuleClass.getOrderModule();
        VBox SearchOrderModule = OrderModuleDeleteClass.getOrderDeleteModule();
        //Horizontal Box--------------------------------------------------------
        HBox H = new HBox();
        Scene scene = new Scene(H, 1280, 720);
        //Vertical Box to the Left----------------------------------------------
        VBox Left = new VBox();
        //Vertical Box to the Right---------------------------------------------
        VBox Right = new VBox();
        //Put Vertical Boxes into Horizontal Box--------------------------------
        H.getChildren().addAll(Left, Right);
        //Icon as Image put into image------------------------------------------
        Image image = new Image(new FileInputStream("src/Icons/icons8_Purchase_Order_48px_1.png"));
        //imageview in order to show the image----------------------------------
        ImageView imageView = new ImageView(image);
        Label Order = new Label();
        //setGraphic to get imageview to be shown in the label------------------
        Order.setGraphic(imageView);
        Order.setPadding(new Insets(10, 10, 10, 90));
        Left.getChildren().add(Order);
        //Background fill of the left vertical box------------------------------
        BackgroundFill background_fill = new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(background_fill);
        Left.setBackground(background);
        Left.setMinWidth(190);
        //----------------------------------------------------------------------
        //----------------Make Order--------------------------------------------
        Left.setPadding(new Insets(20));
        //---------ImageView for Icon of Make Order-----------------------------
        Image ImageMakeOrder = new Image(new FileInputStream("src/Icons/icons8_Create_Document_48px.png"));
        ImageView imageViewMakeOrder = new ImageView(ImageMakeOrder);
        //----------Label Contains Icon and Text--------------------------------
        Label LMakeOrder = new Label("Make Order", imageViewMakeOrder);
        LMakeOrder.setPadding(new Insets(20, 5, 0, 0));
        LMakeOrder.setTextFill(Color.WHITE);
        ChangeFont(LMakeOrder);
        Left.getChildren().add(LMakeOrder);
        Right.getChildren().add(MakeOrderModule);
        //---------Hovers-------------------------------------------------------
        LMakeOrder.setOnMouseEntered(e -> {
            SetColor(LMakeOrder);
        });

        LMakeOrder.setOnMouseExited(e -> {
            ResetColor(LMakeOrder);
        });
        LMakeOrder.setOnMouseClicked(e -> {
            Right.getChildren().clear();
            Right.getChildren().add(MakeOrderModule);

        });
        //----------------------------------------------------------------------
        //----------------Search Delete Order-----------------------------------
        Left.setPadding(new Insets(20));
        //---------ImageView for Icon of Make Order-----------------------------
        Image ImageSearchDelete = new Image(new FileInputStream("src/Icons/icons8_Delete_Document_48px.png"));
        ImageView imageViewSearchDelete = new ImageView(ImageSearchDelete);
        //----------Label Contains Icon and Text--------------------------------
        Label LSearchDelete = new Label("Search/\nDelete Order", imageViewSearchDelete);
        LSearchDelete.setPadding(new Insets(20, 5, 0, 0));
        LSearchDelete.setTextFill(Color.WHITE);
        ChangeFont(LSearchDelete);
        Left.getChildren().add(LSearchDelete);
        //---------Hovers-------------------------------------------------------
        LSearchDelete.setOnMouseEntered(e -> {
            SetColor(LSearchDelete);
        });

        LSearchDelete.setOnMouseExited(e -> {
            ResetColor(LSearchDelete);
        });
        LSearchDelete.setOnMouseClicked(e -> {
            Right.getChildren().clear();
            Right.getChildren().add(SearchOrderModule);
        });
        //----------------------------------------------------------------------
        //----------------List all Orders-----------------------------------
        Left.setPadding(new Insets(20));
        //---------ImageView for Icon of List Orders-----------------------------
        Image ImageListAllOrder = new Image(new FileInputStream("src/Icons/icons8_Report_Card_48px.png"));
        ImageView imageViewListAllOrder = new ImageView(ImageListAllOrder);
        //----------Label Contains Icon and Text--------------------------------
        Label LListOrders = new Label("List All Orders", imageViewListAllOrder);
        LListOrders.setPadding(new Insets(20, 5, 0, 0));
        LListOrders.setTextFill(Color.WHITE);
        ChangeFont(LListOrders);
        Left.getChildren().add(LListOrders);
        //---------Hovers-------------------------------------------------------
        LListOrders.setOnMouseEntered(e -> {
            SetColor(LListOrders);
        });

        LListOrders.setOnMouseExited(e -> {
            ResetColor(LListOrders);
        });
        LListOrders.setOnMouseClicked(e
                -> {
            Right.getChildren().clear();
            try {
                Right.getChildren().add(ListAllOrders.getListOrders());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(OrderModule.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        );
        //----------------------------------------------------------------------

        //----------------Add Customer-----------------------------------
        Left.setPadding(new Insets(20));
        //---------ImageView for Icon of Make Order-----------------------------
        Image ImageAddCustomer = new Image(new FileInputStream("src/Icons/icons8_Add_User_Male_48px.png"));
        ImageView imageViewAddCustomer = new ImageView(ImageAddCustomer);
        //----------Label Contains Icon and Text--------------------------------
        Label LAddCustomer = new Label("Add Customer", imageViewAddCustomer);
        LAddCustomer.setPadding(new Insets(20, 5, 0, 0));
        LAddCustomer.setTextFill(Color.WHITE);
        ChangeFont(LAddCustomer);
        Left.getChildren().add(LAddCustomer);
        //---------Hovers-------------------------------------------------------
        LAddCustomer.setOnMouseEntered(e -> {
            SetColor(LAddCustomer);
        });

        LAddCustomer.setOnMouseExited(e -> {
            ResetColor(LAddCustomer);
        });
        LAddCustomer.setOnMouseClicked(e
                -> {
            Right.getChildren().clear();
            try {
                Right.getChildren().addAll(AddCustomer.getAddCustomerModule());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(OrderModule.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        //----------------------------------------------------------------------
        //----------------Update/Delete Customer--------------------------------
        Left.setPadding(new Insets(20));
        //---------ImageView for Icon of Update/Delete Customer-----------------
        Image ImageUpdateCustomer = new Image(new FileInputStream("src/Icons/icons8_Change_User_48px.png"));
        ImageView imageViewUpdateCustomer = new ImageView(ImageUpdateCustomer);
        //----------Label Contains Icon and Text--------------------------------
        Label LUpdateCustomer = new Label("Update/\nDelete Customer", imageViewUpdateCustomer);
        LUpdateCustomer.setPadding(new Insets(20, 5, 0, 0));
        LUpdateCustomer.setTextFill(Color.WHITE);
        ChangeFont(LUpdateCustomer);
        Left.getChildren().add(LUpdateCustomer);
        //---------Hovers-------------------------------------------------------
        LUpdateCustomer.setOnMouseEntered(e -> {
            SetColor(LUpdateCustomer);
        });

        LUpdateCustomer.setOnMouseExited(e -> {
            ResetColor(LUpdateCustomer);
        });
        LUpdateCustomer.setOnMouseClicked(e
                -> {
            Right.getChildren().clear();
            try {
                Right.getChildren().add(SearchCustomer.getSearchCustomer());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(OrderModule.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
        //----------------------------------------------------------------------
        //----------------List all Customer-------------------------------------
        Left.setPadding(new Insets(20));
        //---------ImageView for Icon of List All Customer-----------------
        Image ImageListCustomer = new Image(new FileInputStream("src/Icons/icons8_User_Menu_Male_48px.png"));
        ImageView imageViewListAllCustomer = new ImageView(ImageListCustomer);
        //----------Label Contains Icon and Text--------------------------------
        Label LListCustomers = new Label("List All Customers", imageViewListAllCustomer);
        LListCustomers.setPadding(new Insets(20, 5, 0, 0));
        LListCustomers.setTextFill(Color.WHITE);
        ChangeFont(LListCustomers);
        Left.getChildren().add(LListCustomers);
        //---------Hovers-------------------------------------------------------
        LListCustomers.setOnMouseEntered(e -> {
            SetColor(LListCustomers);
        });

        LListCustomers.setOnMouseExited(e -> {
            ResetColor(LListCustomers);
        });
        LListCustomers.setOnMouseClicked(e
                -> {
            Right.getChildren().clear();
            try {
                Right.getChildren().add(ListAllCustomers.getListCustomers());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(OrderModule.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        //----------------------------------------------------------------------
        //----------------Logout Button-----------------------------------------
        Left.setPadding(new Insets(20));
        //---------ImageView for Icon of List All Customer-----------------
        Image ImageBack = new Image(new FileInputStream("src/Icons/icons8_Go_Back_48px.png"));
        ImageView imageViewBackButton = new ImageView(ImageBack);
        //----------Label Contains Icon and Text--------------------------------
        Label LBack = new Label("Logout", imageViewBackButton);
        LBack.setPadding(new Insets(20, 5, 0, 0));
        LBack.setTextFill(Color.WHITE);
        ChangeFont(LBack);
        Left.getChildren().add(LBack);
        //---------Hovers-------------------------------------------------------
        LBack.setOnMouseEntered(e -> {
            SetColor(LBack);
        });

        LBack.setOnMouseExited(e -> {
            ResetColor(LBack);
        });
        LBack.setOnMouseClicked(e -> {
            //Right.getChildren().clear();
            primaryStage.close();
            Stage s = new Stage();
            login x = new login();
            x.start(s);
        });
        //----------------------------------------------------------------------
        window.setResizable(false);
        window.setTitle("Orders");
        window.setScene(scene);
        window.show();

    }

    /*public static void main(String[] args) {
        launch(args);
    }*/
    public void SetColor(Label l) {
        l.setTextFill(Color.BLUE);
    }

    public void ResetColor(Label l) {
        l.setTextFill(Color.WHITE);
    }

    public void ChangeFont(Label l) {
        l.setFont(Font.font("fatoma", FontPosture.ITALIC, 25));
    }
}
