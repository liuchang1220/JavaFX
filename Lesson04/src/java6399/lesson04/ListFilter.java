package java6399.lesson04;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class ListFilter extends Application {


        public void start(Stage primaryStage)throws IOException {
            URL url=getClass().getResource("ListFilter6399View.fxml");
            Parent root= FXMLLoader.load(url);
            Scene scene=new Scene(root,800,500);
            primaryStage.setScene(scene);
            primaryStage.setTitle("筛选随机数");
            primaryStage.show();
        }


        public static void main(String[] args) {
            launch(args);
        }}

