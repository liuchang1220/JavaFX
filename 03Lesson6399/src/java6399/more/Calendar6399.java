package java6399.more;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Calendar6399 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage)throws IOException {
        URL url=getClass().getResource("Calendar6399View.fxml");
        Parent root= FXMLLoader.load(url);
        Scene scene=new Scene(root,600,400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("显示日历");
        primaryStage.show();
    }}
