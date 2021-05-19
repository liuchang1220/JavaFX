package java6399.search;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class SearchFile6399 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage)throws IOException {
        URL url=getClass().getResource("SearchFile6399l.fxml");
        Parent root= FXMLLoader.load(url);
        Scene scene=new Scene(root,900,500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("列出文件的内容");
        primaryStage.show();
    }}
