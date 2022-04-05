import controller.CookingClassController;
import controller.SubscriptionController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import repository.CookingClassFileRepository;
import repository.CookingClassRepository;
import repository.SubscriptionFileRepository;
import repository.SubscriptionRepository;
import service.Service;
import service.ServiceException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class MainFX extends Application {

    Stage window;
    Scene scene1, scene2, scene3;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        window = primaryStage;
        Label label1 = new Label("What do you want to do?");
        Button button1 = new Button("See the cooking classes");
        Button button2 =new Button("See the subscriptions");
        button1.setOnAction(e -> window.setScene(scene2));
        button2.setOnAction(e -> window.setScene(scene3));

        BackgroundFill background_fill = new BackgroundFill(Color.LIGHTSALMON, CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(background_fill);

        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, button1, button2);
        scene1 = new Scene(layout1, 400, 150);
        layout1.setBackground(background);

        Button button3 =new Button("Back to the Menu");
        Button button4 =new Button("Back to the Menu");
        button3.setOnAction(e -> window.setScene(scene1));
        button4.setOnAction(e -> window.setScene(scene1));


        Parent root1;
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("CookingClass.fxml"));
            root1=loader.load();
            VBox layout = new VBox();
            layout.getChildren().addAll(root1, button3);
            scene2= new Scene(layout);
            CookingClassController ctrl=loader.getController();
            ctrl.setService(getService());
        } catch (Exception e) {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error ");
            alert.setContentText("Error while starting app "+e);
            alert.showAndWait();
        }

        Parent root2;
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("Subscription.fxml"));
            root2=loader.load();
            VBox layout = new VBox();
            layout.getChildren().addAll(root2, button4);
            scene3= new Scene(layout);
            SubscriptionController ctrl=loader.getController();
            ctrl.setService(getService());
        } catch (Exception e) {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error ");
            alert.setContentText("Error while starting app "+e);
            alert.showAndWait();
        }

        window.setScene(scene1);
        window.setTitle("Cooking Classes");
        window.show();

    }
    static Service getService() throws ServiceException {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("App.properties"));
            String class1FileName=properties.getProperty("CCFile");
            if (class1FileName==null){
                class1FileName="CookingClass.txt";
                System.err.println("File not found. Using default "+class1FileName);
            }
            String class2FileName=properties.getProperty("SubscriptionFile");
            if (class2FileName==null){
                class2FileName="Subscription.txt";
                System.err.println("File not found. Using default "+class2FileName);
            }
            CookingClassRepository cRepo = new CookingClassFileRepository(class1FileName);
            SubscriptionRepository oRepo = new SubscriptionFileRepository(class2FileName, cRepo);
            return new Service(cRepo, oRepo);
        }catch (IOException ex){
            throw new ServiceException("Error starting app "+ex);
        }
    }

}
