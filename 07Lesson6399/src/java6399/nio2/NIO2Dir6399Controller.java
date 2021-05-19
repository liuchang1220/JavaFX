package java6399.nio2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.String.format;
import static java.nio.file.Files.size;


public class NIO2Dir6399Controller {

    @FXML
    private TextField tfDir;

    @FXML
    private Label lblCount;

    @FXML
    private TableView<Myfile6399> tableFiles;

    @FXML
    private TableColumn<Myfile6399, String> colName;

    @FXML
    private TableColumn<Myfile6399, String> colTime;

    @FXML
    private TableColumn<Myfile6399, String> colType;

    @FXML
    private TableColumn<Myfile6399, String> colSize;

    @FXML
    private void initialize() {
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colSize.setCellValueFactory(new PropertyValueFactory<>("size"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colTime.setCellValueFactory(new PropertyValueFactory<>("modifiedTime"));
    }

    @FXML
    void doubleClick(MouseEvent event) throws IOException {//判断是否双击
        if (event.getClickCount() == 2) {
            Myfile6399 selectedItem = tableFiles.getSelectionModel().getSelectedItem();
            if (selectedItem.getType() != null) {
                Path dir = Paths.get(selectedItem.getName());
                tfDir.setText(tfDir.getText() + "\\" + dir.toString());//更改目录进行listall的操作
                List<Myfile6399> list1 = new ArrayList<>();
                List<Myfile6399> list2 = new ArrayList<>();
                Path path = Paths.get(tfDir.getText());
                Stream<Path> list = Files.list(path);
                list.forEach(p -> {//通过foreach进行遍历path
                    if (Files.isDirectory(p)) {
                        Myfile6399 s = new Myfile6399();
                        s.setName(p.getFileName().toString());
                        s.setType("文件夹");
                        try {
                            s.setSize("");
                            FileTime a = Files.getLastModifiedTime(p);
                            Instant instant = Instant.ofEpochMilli(a.toMillis());//通过instandt转化long类型再通过dateformatter格式化输出
                            ZoneId zoneId = ZoneId.systemDefault();
                            LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zoneId);
                            DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                            String date = dtf3.format(localDateTime);
                            s.setModifiedTime(date);
                            list1.add(s);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    } else {
                        Myfile6399 s = new Myfile6399();
                        s.setName(p.getFileName().toString());
                        s.setType("");
                        try {
                            String size = String.valueOf(Files.size(p) / 1024 + 1);
                            s.setSize(size + "kb");
                            FileTime a = Files.getLastModifiedTime(p);
                            Instant instant = Instant.ofEpochMilli(a.toMillis());//改变长度
                            ZoneId zoneId = ZoneId.systemDefault();
                            LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zoneId);
                            DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                            String date = dtf3.format(localDateTime);
                            s.setModifiedTime(date);
                            list2.add(s);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                });
                Collections.sort(list1, new Comparator<Myfile6399>() {
                    @Override
                    public int compare(Myfile6399 o1, Myfile6399 o2) {
                        return o2.getType().compareTo(o1.getType());
                    }
                });
                lblCount.setText("子目录：" + list1.size() + "文件：" + list2.size());//更新tableview
                list1.addAll(list2);
                ObservableList<Myfile6399> observableList = FXCollections.observableList(list1);
                tableFiles.setItems(observableList);
            }
        }
    }

    @FXML
    void listAll(ActionEvent event) throws IOException {
        List<Myfile6399> list1 = new ArrayList<>();
        List<Myfile6399> list2 = new ArrayList<>();
        Path path = Paths.get(tfDir.getText());
        if (tfDir.getText().equals("")) {
            path = Paths.get(".");
        }

        Stream<Path> list = Files.list(path);
        list.forEach(p -> {//通过foreach进行遍历path
            if (Files.isDirectory(p)) {
                Myfile6399 s = new Myfile6399();
                s.setName(p.getFileName().toString());
                s.setType("文件夹");
                try {
                    s.setSize("");
                    FileTime a = Files.getLastModifiedTime(p);
                    Instant instant = Instant.ofEpochMilli(a.toMillis());
                    ZoneId zoneId = ZoneId.systemDefault();
                    LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zoneId);
                    DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    String date = dtf3.format(localDateTime);
                    s.setModifiedTime(date);
                    list1.add(s);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else {
                Myfile6399 s = new Myfile6399();
                s.setName(p.getFileName().toString());
                s.setType("");
                try {
                    String size = String.valueOf(Files.size(p) / 1024 + 1);
                    s.setSize(size + "kb");
                    FileTime a = Files.getLastModifiedTime(p);
                    Instant instant = Instant.ofEpochMilli(a.toMillis());//通过instandt转化long类型再通过dateformatter格式化输出
                    ZoneId zoneId = ZoneId.systemDefault();
                    LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zoneId);
                    DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    String date = dtf3.format(localDateTime);
                    s.setModifiedTime(date);
                    list2.add(s);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });
        Collections.sort(list1, new Comparator<Myfile6399>() {
            @Override
            public int compare(Myfile6399 o1, Myfile6399 o2) {
                return o2.getType().compareTo(o1.getType());
            }
        });
        lblCount.setText("子目录：" + list1.size() + "文件：" + list2.size());
        list1.addAll(list2);
        ObservableList<Myfile6399> observableList = FXCollections.observableList(list1);
        tableFiles.setItems(observableList);

    }

}