package java6399.search;

import java6399.lesson08.Course6399;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SearchFile6399Controller {

    @FXML
    private ListView<String> lvFiles;

    @FXML
    private Button click;

    @FXML
    private TextField tfDir;
    @FXML
    private Label onb;

    @FXML
    private Label lblCount;
    @FXML
    void initialize(){
        List<String> list=new ArrayList<>();
        List<String>list1=new ArrayList<>();
        List<String>list3=new ArrayList<>();
        click.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage=new Stage();
                DirectoryChooser dc=new DirectoryChooser();
                dc.setTitle("文件选择器");//文件选择器弹窗
                dc.setInitialDirectory(new File("."));
                File file=dc.showDialog(stage);
                if(file.exists()){
                    File []file1=file.listFiles();
                    onb.setText("当前目录："+file.getPath());
                    for(File f:file1){
                        if(f.isDirectory()){
                       list.add(f.getName()+"，文件夹");
                    }else {
                           String s=f.getName();
                           int i=s.indexOf(".");
                           String s1=s.substring(i+1,s.length());
                           list.add(s+"，"+s1+"类型");//进行分离类型操作
                        }
                }}
             List<String>list2=new ArrayList<>();
                for (String s:list
                     ) {
                    if(s.contains("文件夹")){
                        list2.add(s);
                        list1.add(s);

                    }
                }
                for (String s:list
                     ) {
                    if(!s.contains("文件夹")){
                        list2.add(s);
                        list3.add(s);
                    }
                }
                lblCount.setText("子目录： "+list1.size()+"文件："+list3.size());
                ObservableList<String> observableList = FXCollections.observableList(list2);
                lvFiles.setItems(observableList);
            }
        });


    }
    @FXML
    void listAll(ActionEvent event) {
        SimpleStringProperty ssp=new SimpleStringProperty();
        ssp.addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                //动态监听更新
                tfDir.setText(newValue);
            }
        });
        String string=tfDir.getText();
        File file=new File(string);
        List<String> list=new ArrayList<>();
        List<String>list1=new ArrayList<>();
        List<String>list3=new ArrayList<>();
        if(file.exists()){//与选中目录同理
            File []file1=file.listFiles();
            onb.setText("当前目录："+file.getPath());
            for(File f:file1){
                if(f.isDirectory()){
                    list.add(f.getName()+"，文件夹");
                }else {
                    String s=f.getName();
                    int i=s.indexOf(".");
                    String s1=s.substring(i+1,s.length());
                    list.add(s+"，"+s1+"类型");
                }
            }}else {
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Warning");
            alert.setHeaderText("请注意");
            alert.setContentText("输入格式有误");
            alert.show();
        }
        List<String>list2=new ArrayList<>();
        for (String s:list
        ) {
            if(s.contains("文件夹")){
                list2.add(s);
                list1.add(s);

            }
        }
        for (String s:list
        ) {
            if(!s.contains("文件夹")){
                list2.add(s);
                list3.add(s);
            }
        }
        lblCount.setText("子目录： "+list1.size()+"文件："+list3.size());
        ObservableList<String> observableList = FXCollections.observableList(list2);
        lvFiles.setItems(observableList);
    }
}


