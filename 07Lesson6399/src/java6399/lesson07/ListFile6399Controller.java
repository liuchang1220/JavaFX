package java6399.lesson07;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.File;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ListFile6399Controller {

    @FXML
    private ListView<String> lvFiles;

    @FXML
    private TextField tfDir;

    @FXML
    private Label lblCount;

    @FXML
    void listAll(ActionEvent event) {
        String s = tfDir.getText();
        File file = new File("");
        List<String> list = new ArrayList<>();

        if (!s.contains(" ")) {
            file = new File(s);
        }//不为空添加路径
        else {
            file = new File(".");//若为空串返回当前目录
        }
        File[] files = file.listFiles();
        if (file.isDirectory()) {//判断是否是目录
            for (File f : files
            ) {
                long time = f.lastModified();
                Instant instant = Instant.ofEpochMilli(time);//通过instandt转化long类型再通过dateformatter格式化输出
                ZoneId zoneId = ZoneId.systemDefault();
                LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zoneId);
                DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String date = dtf3.format(localDateTime);
                StringBuilder stringBuilder = new StringBuilder();
                if (!f.isFile()) {//判断是否是文件
                    stringBuilder.append("文件夹，" + f.getName() + ",  ");
                    stringBuilder.append(date);
                    list.add(stringBuilder.toString());
                } else {
                    list.add(f.getName() + ", " + date + " " + (f.length() / 1024+1) + "KB");
                }
                Collections.sort(list, new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o2.compareTo(o1);
                    }
                });

            }
        }
        ObservableList<String> observableList = FXCollections.observableList(list);
        lvFiles.setItems(observableList);


    }

}
