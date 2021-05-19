package java6399.task;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Words6399Controller {

    @FXML
    private ListView<String> lvWords=new ListView<String>();

    @FXML
    private TextArea taWords;

    @FXML
    private Label lblCount;

    @FXML
    void buttonClick(ActionEvent event) {
    String s=taWords.getText();
    String s1=s.toLowerCase();//转换为小写
    String []words=s1.split("\\s+|\\,");//匹配正则表达式分割字符串加入数组中
    TreeSet<String> set=new TreeSet<>();//利用treeset进行添加去重并排序
    for (int i=0;i<words.length;i++) {
        String regex = "^[A-Za-z]+$";//匹配单词
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(words[i]);
        if (matcher.find()){
            set.add(words[i]);

        }
    }
        List<String> list=new ArrayList<>();
        list.addAll(set);
        ObservableList<String> observableList= FXCollections.observableList(list);
        lvWords.setItems(observableList);
        lblCount.setText("有"+set.size()+"个唯一的单词");
    }

}
