package java6399.task;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class NoRepeatStudent6399 extends Application {


    public void start(Stage primaryStage)throws IOException {
        URL url=getClass().getResource("NoRepeatStudent6399View.fxml");
        Parent root= FXMLLoader.load(url);
        Scene scene=new Scene(root,600,400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ListView与集合对象");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }}