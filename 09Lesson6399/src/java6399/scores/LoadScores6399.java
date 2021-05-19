package java6399.scores;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class LoadScores6399 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage)throws IOException {
        URL url=getClass().getResource("LoadScores6399View.fxml");
        Parent root= FXMLLoader.load(url);
        Scene scene=new Scene(root,600,500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("加载学生成绩文件");
        primaryStage.show();
    }}