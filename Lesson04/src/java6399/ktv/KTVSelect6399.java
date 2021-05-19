package java6399.ktv;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class KTVSelect6399 extends Application {


    public void start(Stage primaryStage)throws IOException {
        URL url=getClass().getResource("KTVSelect6399View.fxml");
        Parent root= FXMLLoader.load(url);
        Scene scene=new Scene(root,600,400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("模拟KTV点歌");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }}

