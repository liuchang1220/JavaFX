package java6399.lesson04;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.util.*;

public class ListFilter6399Controller {

    @FXML
    private ListView<Integer> lvAll=new ListView<>();
    @FXML
    private Label lbl5;
    @FXML
    private ListView<Integer> lv5=new ListView<>();
    @FXML
    void buttonClick(ActionEvent event) {
        ObservableList<Integer> observableList = FXCollections.observableList(createList6399(60,100));//利用可观察集合存储集合
        lvAll.setItems(observableList);
        ObservableList<Integer> observableList1=FXCollections.observableList( findList6399(observableList));//利用可观察集合存储满足数据
        lv5.setItems(observableList1);
        int size=findList6399(observableList).size();//获得满足题意集合大小
        String s=String.valueOf(size);
        lbl5.setText("其中：5的倍数有"+s+"个");
        lbl5.setLabelFor(lv5);//列表返回
    }
   private List createList6399(int m,int n){//进行随机数生成，放入list集合
       List<Integer> list=new ArrayList<>();
       for(int i=0;i<20;i++){
           int t=m+(int)(Math.random()*(n+1-m));
           list.add(t);
       }
       return  list;
    }
    private  List findList6399(List list){//生成list集合存储满足题意的元素
        List<Integer> list5=new ArrayList<>();

        Integer[] a=new Integer[list.size()];
        list.toArray(a);
        for (int i = 0; i <a.length ; i++) {
            if(a[i]%5==0){
                list5.add(a[i]);
            }
        }
        return list5;
    }
    }

