package java6399.task;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.time.Year;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NoRepeatStudent6399Controller {
    @FXML
    private TextField tfName;
    @FXML
    static int i;//记录鼠标点击的行号
    @FXML
    private TextField tfAge;
    @FXML
    private ListView<Student6399> lvStudent = new ListView<>();
    @FXML
    void initialize() {
        List<Student6399> list = new ArrayList<>();//初始化信息
        list.add((new Student6399("刘java", 21)));
        list.add((new Student6399("林c++", 18)));
        list.add((new Student6399("陈ruby", 31)));
        list.add((new Student6399("陈Python", 21)));
        list.add((new Student6399("刘java", 21)));
        list.add(new Student6399("陈php", 19));
        ObservableList<Student6399> observableList = FXCollections.observableList(list);
        lvStudent.setItems(observableList);
        lvStudent.getSelectionModel().select(0);//定位刀第一个，并初始化
        tfName.setText(list.get(0).getName());
        tfAge.setText(list.get(0).getYear() + "");
        lvStudent.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Student6399>() {
            @Override
            public void changed(ObservableValue<? extends Student6399> observable, Student6399 oldValue, Student6399 newValue) {
                tfName.setText(newValue.getName());//在定位的行中修改元素的值
                tfAge.setText(newValue.getYear() + "");
            }
        });
        lvStudent.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override

            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                i = newValue.intValue();//获取定位的行数
            }

        });
    }

    @FXML
    private static boolean judgment(String name, String year) {//boolean方法判断输入合法性

        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher matcher = pattern.matcher(year);//为数字
if(!matcher.matches()){
    Alert alert = new Alert(Alert.AlertType.INFORMATION);//弹窗警告
    alert.setTitle("Warning");
    alert.setHeaderText("请注意");
    alert.setContentText("年龄处请输入数字");
    alert.show();
    return false;
}

        if (name.equals("") || name.contains(" ") || (year.equals("") || year.contains(" "))) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);//弹窗警告
            alert.setTitle("Warning");
            alert.setHeaderText("请注意");
            alert.setContentText("输入格式有误");
            alert.show();
            return false;

        }
        return true;
    }

    @FXML
    void addClick(ActionEvent event) {
        List<Student6399> list = new ArrayList<Student6399>();
        if (judgment(tfName.getText(), tfAge.getText())) {
            list.addAll(lvStudent.getItems());
            list.add(list.size(), new Student6399(tfName.getText(), Integer.parseInt(tfAge.getText())));//在最后一个对象下添加
            ObservableList<Student6399> observableList = FXCollections.observableList(list);
            lvStudent.setItems(observableList);
        }
    }

    @FXML
    void changeClick(ActionEvent event) {
        List<Student6399> list = new ArrayList<Student6399>();
        if (judgment(tfName.getText(), tfAge.getText())) {
            list.addAll(lvStudent.getItems());
            list.remove(i);//先删除定位元素后添加
            list.add(i, new Student6399(tfName.getText(), Integer.parseInt(tfAge.getText())));
            System.out.println(i);
            ObservableList<Student6399> observableList = FXCollections.observableList(list);
            lvStudent.setItems(observableList);
        }
    }

    @FXML
    void clearClick(ActionEvent event) {
        ArrayList<Student6399>list=new ArrayList<Student6399>();
        list.addAll(lvStudent.getItems());
        ArrayList<Student6399>list1=new ArrayList<Student6399>();//创建新集合并遍历
        Iterator it=list.iterator();
        while (it.hasNext()){
            Student6399 s=(Student6399)it.next();
            if(!list1.contains(s)){//如果不在集合中则加入新集合
                list1.add(s);
            }
        }
        ObservableList<Student6399> observableList = FXCollections.observableList(list1);
        lvStudent.setItems(observableList);
    }
}