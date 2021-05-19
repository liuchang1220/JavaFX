package java6399.lesson08;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.swing.*;
import java.io.File;
import java.io.FilenameFilter;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileFilter6399Controller {
    @FXML
    private TextField tfDir;
    @FXML
    private Label lblMsg;
    @FXML
    private ListView<String> lvFiles;
    @FXML
    private RadioButton rb1;
    @FXML
    private ToggleGroup tg;
    @FXML
    private RadioButton rb2;
    @FXML
    private RadioButton rb3;
    @FXML
    void listFile(ActionEvent event) {
        String s = tfDir.getText();
        List<String> list1 = new ArrayList<>();//初始化代码
        List<String> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();
        List<String> list4 = new ArrayList<>();
        list1 = list(s, (name, dir) -> dir.endsWith(".java"));
        list2.add("后缀名为.java的文件：" + list1.size());
        list2.addAll(list1);
        list3=list(s,(name,dir) -> new File(name, dir).length()/1024>2*1024);
        list2.add("大于2K的文件："+list3.size());
        list2.addAll(list3);
        LocalDateTime rq=LocalDateTime.now().plusDays(3);
        long m=rq.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        list4=list(s, (name,dir)->new File(name, dir).lastModified()<m);
        list2.add("三天前到现在修改过的文件："+list4.size());
        list2.addAll(list4);
        ObservableList<String> observableList = FXCollections.observableList(list2);
        lvFiles.setItems(observableList);
        tg.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                if (tg.getSelectedToggle() == rb1){//inner方法 运用匿名内部类
                    List<String> list2 = new ArrayList<>();
                    FilenameFilter filter1=new FilenameFilter() {
                        @Override
                        public boolean accept(File dir, String name) {
                            return name.endsWith(".java");
                        }
                    };
                    List<String>list1=list(s,filter1);
                    list2.add("法一: ");
                    list2.add("后缀名为.java的文件：" + list1.size());
                    list2.addAll(list1);
                    FilenameFilter filter2=new FilenameFilter() {
                        @Override
                        public boolean accept(File dir, String name) {
                            return dir.length() / 1024 > 2 * 1024;
                        }
                    };
                    List<String>list3=list(s,filter2);
                    list2.add("大于2K的文件："+list3.size());
                    list2.addAll(list3);
                    LocalDateTime rq=LocalDateTime.now().plusDays(3);
                    long m=rq.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
                    FilenameFilter filter3=new FilenameFilter() {
                        @Override

                        public boolean accept(File dir, String name) {
                            return dir.lastModified()<m;
                        }
                    };
                    List<String>list4=list(s,filter3);
                    list2.add("三天前到现在修改过的文件："+list4.size());
                    list2.addAll(list4);
                    ObservableList<String> observableList = FXCollections.observableList(list2);
                    lvFiles.setItems(observableList);
                }
                if (tg.getSelectedToggle() == rb2) {//lambda方法 表达式筛选
                    List<String> list1 = new ArrayList<>();
                    List<String> list2 = new ArrayList<>();
                    List<String> list3 = new ArrayList<>();
                    List<String> list4 = new ArrayList<>();
                    list1 = list(s, (name, dir) -> dir.endsWith(".java"));
                    list2.add("法二: ");
                    list2.add("后缀名为.java的文件：" + list1.size());
                    list2.addAll(list1);
                    list3=list(s,(name,dir) -> new File(name, dir).length()/1024>2*1024);
                    list2.add("大于2K的文件："+list3.size());
                    list2.addAll(list3);
                    LocalDateTime rq=LocalDateTime.now().plusDays(3);
                    long m=rq.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
                    list4=list(s, (name,dir)->new File(name, dir).lastModified()<m);
                    list2.add("三天前到现在修改过的文件："+list4.size());
                    list2.addAll(list4);
                    ObservableList<String> observableList = FXCollections.observableList(list2);
                    lvFiles.setItems(observableList);
                }
                if (tg.getSelectedToggle() == rb3){//reference方法 方法引用进行筛选
                    List<String>list=new ArrayList<>();
                    List<String>list2=new ArrayList<>();
                    List<String>list3=new ArrayList<>();
                    List<String>list4=new ArrayList<>();
                    File file = new File(s);
                    String[] a = file.list(XY::FilterByType);
                    for (String s:a
                         ) {
                        list.add(tfDir.getText()+"\\"+s);
                    }
                    list2.add("法三：");
                    list2.add("后缀名为.java的文件：" + list.size());
                    list2.addAll(list);
                    String[] b=file.list(XY::FilterBysize);
                    for (String s:b
                    ) {
                        list3.add(tfDir.getText()+"\\"+s);
                    }
                    list3.add("大于2K的文件："+list3.size());
                    list2.addAll(list3);
                    String[] c=file.list(XY::FilterBytime);
                    for (String s:c
                    ) {
                        list4.add(tfDir.getText()+"\\"+s);
                    }
                    list2.add("三天前到现在修改过的文件："+list4.size());
                    list2.addAll(list4);
                    ObservableList<String> observableList = FXCollections.observableList(list2);
                    lvFiles.setItems(observableList);
                }
            }
        });
    }
    private static List<String> list(String dir, FilenameFilter filter) {//定义方法判断和传参加入集合
        File file = new File(dir);
        if(!file.isDirectory()){
             file=new File(".");
        }
        List<String> list1 = new ArrayList<>();
        File[] files = file.listFiles(filter);
            for (File f : files
            ) {
                list1.add(f + "");
            }
        return list1;
    }

}