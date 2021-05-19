package java6399.lesson08;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class ListSort6399Controller {
    List<Course6399> list=new ArrayList<>();
    @FXML
    private RadioButton rb1;

    @FXML
    private ToggleGroup tg;

    @FXML
    private ListView<Course6399> lvCourse;
    @FXML
    void initialize(){//初始化代码 加入数据
        list.add(new Course6399("操作系统",3,80,"2下","B001"));
        list.add(new Course6399("Pthyon程序基础",2,85,"1下","B002"));
        list.add(new Course6399("高等数学",4,85,"1下","0002"));
        list.add(new Course6399("Java程序高级开发",4,83,"3下","C001"));
        list.add(new Course6399("大学英语",3,96,"1下","0001"));
        list.add(new Course6399("C程序设计基础",4,80,"1上","A001"));
        list.add(new Course6399("面向对象程序设计",4,78,"2上","A002"));
        list.add(new Course6399("数据库原理",3,78,"2上","A003"));
        list.add(new Course6399("网络基础",3,75,"3上","B003"));
        list.add(new Course6399("软件工程与UML",3,75,"3下","C002"));
        ObservableList<Course6399> observableList = FXCollections.observableList(list);
        lvCourse.setItems(observableList);
        tg.selectToggle(rb1);

        tg.selectedToggleProperty().addListener(this::changed);
    }
    public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue){
        RadioButton rb=(RadioButton)newValue;
        switch (rb.getText()){//comparingInt方法
            case "按成绩降序":
                Collections.sort(list, Comparator.comparingInt(Course6399::getScore).reversed());
                ObservableList<Course6399> observableList = FXCollections.observableList(list);
                lvCourse.setItems(observableList);
                break;
            case "按学期升序":
                Collections.sort(list,Comparator.comparing(//comparing 方法引用和lambda表达式
                        Course6399::getTerm,(s1,s2)->{
                            return s1.compareTo(s2);
                        }
                ));
                ObservableList<Course6399> observableList1 = FXCollections.observableList(list);
                lvCourse.setItems(observableList1);
                break;
            case "按学分升序":
                list.sort((s1,s2)->s1.getCredit()-s2.getCredit());//普通lambda表达式
                ObservableList<Course6399> observableList2 = FXCollections.observableList(list);
                lvCourse.setItems(observableList2);
                break;
            case "按学期升序、学分降序":
                list.sort(Comparator.comparing(Course6399::getTerm,(s1,s2)->{//多关键字排序
                    return s1.compareTo(s2);}).
                        thenComparing(Course6399::getCredit,(s3,s4)->{
                            return s4.compareTo(s3);
                        }));
                ObservableList<Course6399> observableList3 = FXCollections.observableList(list);
                lvCourse.setItems(observableList3);
                break;
        }
    }

}
