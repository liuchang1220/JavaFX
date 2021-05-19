package java6399.nio2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class NIO2Dir6399 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage)throws IOException {
        URL url=getClass().getResource("NIO2Dir6399View.fxml");
        Parent root= FXMLLoader.load(url);
        Scene scene=new Scene(root,600,400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("NIO2与TableView显示目录内容");
        primaryStage.show();
    }}
