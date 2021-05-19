package java6399.sort.list;

import java6399.sort.list.Course6399;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.util.*;

public class ListSort6399Controller {
    @FXML
    private RadioButton rb2=new RadioButton();

    @FXML
    private RadioButton rb3=new RadioButton();
    @FXML
    private RadioButton rb1=new RadioButton();
    @FXML
    private RadioButton rb4=new RadioButton();

    @FXML
    private ToggleGroup tg=new ToggleGroup();

    @FXML
    private ListView<Course6399> lvCourse=new ListView<Course6399>();
    @FXML
    void initialize(){
        List<Course6399> list=new ArrayList<>();
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
        rb1.setToggleGroup(tg);
        rb2.setToggleGroup(tg);
        rb3.setToggleGroup(tg);
        rb4.setToggleGroup(tg);
        ObservableList<Course6399> observableList = FXCollections.observableList(list);
        lvCourse.setItems(observableList);

    }

    @FXML
    void score(ActionEvent event) {
        List<Course6399>list=new ArrayList<>();//Treesort有用compareto方法，这里用数组实现
        list.addAll(lvCourse.getItems());
        int []a=new int[list.size()];
        for (int i = 0; i <list.size() ; i++) {
            a[i]=list.get(i).getScore();
        }
        Arrays.sort(a);
        List<Course6399>list1=new ArrayList<>();//利用工具类先进行分数排序，再通过提取比较进行排序
        for (int i=a.length-1;i>=0;i--){
            for (int j=0;j<list.size();j++){
                if (list.get(j).getScore()==a[i]){
                    if (!list1.contains(list.get(j))){
                    list1.add(list.get(j));}
                }}

            ObservableList<Course6399> observableList = FXCollections.observableList(list1);
        lvCourse.setItems(observableList);

    }}

    @FXML
    void term(ActionEvent event) {
        List<Course6399>list=new ArrayList<>();
        list.addAll(lvCourse.getItems());
        Collections.sort(list, new Comparator<Course6399>() {//利用匿名内部类重写compare方法
            @Override
            public int compare(Course6399 o1, Course6399 o2) {
              return o1.getTerm().compareTo(o2.getTerm());
            }
        });
        ObservableList<Course6399> observableList = FXCollections.observableList(list);
        lvCourse.setItems(observableList);
    }
    @FXML
    void credit(ActionEvent event) {
        List<Course6399>list=new ArrayList<>();
        list.addAll(lvCourse.getItems());
        class SorterByCredit6399 implements Comparator<Course6399>{//创建内部类进行实现接口，使之可以完成工具类排序
            public int compare(Course6399 o1, Course6399 o2) {
                return o1.getCredit()-o2.getCredit();
            }
        }

        Collections.sort(list,new SorterByCredit6399());


        ObservableList<Course6399> observableList = FXCollections.observableList(list);
        lvCourse.setItems(observableList);

    }

    @FXML
    void termandcredit(ActionEvent event) {

        List<Course6399>list=new ArrayList<>();
        list.addAll(lvCourse.getItems());
        class SorterBytremandCredit6399 implements Comparator<Course6399>{
            public int compare(Course6399 o1, Course6399 o2) {
                int i=o1.getTerm().compareTo(o2.getTerm());
                int i3=i==0? o1.getCredit()-o2.getCredit():i;
                return i3;
            }
        }
        Collections.sort(list,new SorterBytremandCredit6399());//通过顺序修改完成比较器的排序先后
        ObservableList<Course6399> observableList = FXCollections.observableList(list);
        lvCourse.setItems(observableList);
    }

}
