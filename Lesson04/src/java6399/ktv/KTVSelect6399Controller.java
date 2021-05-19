package java6399.ktv;

import com.sun.deploy.security.SelectableSecurityManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class KTVSelect6399Controller {

    @FXML
    private TextField tfNewName;

    @FXML
    private ListView<String> lvNames=new ListView<>();

    @FXML
    void initialize(){//默认方法显示歌单
        ObservableList<String> observableList= FXCollections.observableArrayList();
        observableList.add("Kill this love");
        observableList.add("Hwaa");
        observableList.add("Gee");
        observableList.add("忘记我自己");
        observableList.add("年少有为");
        lvNames.setItems(observableList);
        lvNames.getSelectionModel().select(0);
        }
        @FXML
        private static boolean adj(String s,List list,int i){//boolean方法判断合法性
            if (s.equals("")||s.contains(" ")){
                Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("KTV点歌");
                alert.setHeaderText("请注意");
                alert.setContentText("输入格式有误");
                alert.show();
                return false;

            }
            for (int i1 = 0; i1 <list.size(); i1++)  {
                if (list.get(i1).equals(s)){//判断list中是否有传入的相同元素，如果有则弹窗并删除添加元素
                    Alert alert=new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("KTV点歌");
                    alert.setHeaderText("请注意");
                    alert.setContentText(list.get(i1)+"已在歌单中");
                    alert.show();
                    list.remove(list.get(i1));
                    return false;
                }
            }
            return true;
        }

    @FXML
    void addClick(ActionEvent event) {//向listvivw添加元素
        int i=lvNames.getSelectionModel().getSelectedIndex();
        List<String>list=new ArrayList<>();
        list.addAll(lvNames.getItems());
        String s= tfNewName.getText();

        if(adj(s,list,i)){
            list.add(i,tfNewName.getText());
            ObservableList<String> observableList = FXCollections.observableList(list);
            lvNames.setItems(observableList);
        }

    }

    @FXML
    void downClick(ActionEvent event) {
        String s=lvNames.getSelectionModel().getSelectedItem();
        int i=lvNames.getSelectionModel().getSelectedIndex();
        List<String>list=new ArrayList<>();
        list.addAll(lvNames.getItems());
        Collections.swap(list,i,i+1);//用自带的swap方法进行交换
        ObservableList<String> observableList= FXCollections.observableList(list);
        lvNames.setItems(observableList);//点击按钮改变listview的元素
    }

    @FXML
    void topClick(ActionEvent event) {
        String s=lvNames.getSelectionModel().getSelectedItem();
        List<String>list=new ArrayList<>();
        list.addAll(lvNames.getItems());
        list.remove(s);//先进行删除，后进行置顶添加
        list.add(0,s);
        ObservableList<String> observableList= FXCollections.observableList(list);
        lvNames.setItems(observableList);
    }

    @FXML
    void upClick(ActionEvent event) {//和down同理
        int i=lvNames.getSelectionModel().getSelectedIndex();
        List<String>list=new ArrayList<>();
        list.addAll(lvNames.getItems());
        Collections.swap(list,i,i-1);
        ObservableList<String> observableList= FXCollections.observableList(list);
        lvNames.setItems(observableList);
    }

}
