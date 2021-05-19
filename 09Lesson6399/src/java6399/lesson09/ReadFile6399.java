package java6399.lesson09;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class ReadFile6399 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage)throws IOException {
        URL url=getClass().getResource("ReadFile6399View.fxml");
        Parent root= FXMLLoader.load(url);
        Scene scene=new Scene(root,700,500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("读文本文件|字符缓冲流");
        primaryStage.show();
    }}