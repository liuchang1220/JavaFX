package java6399.sort.list;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class ListSort6399 extends Application {


    public void start(Stage primaryStage)throws IOException {
        URL url=getClass().getResource("ListSort6399View.fxml");
        Parent root= FXMLLoader.load(url);
        Scene scene=new Scene(root,600,400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("对象排序（list）");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }}