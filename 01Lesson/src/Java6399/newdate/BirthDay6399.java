package Java6399.newdate;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class BirthDay6399 extends Application {

    @Override
    public void start(Stage primaryStage)throws IOException {
        URL url=getClass().getResource("BirthDay6399View.fxml");
        VBox root=FXMLLoader.load(url);
        Scene scene=new Scene(root,300,200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("生日计算");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }}