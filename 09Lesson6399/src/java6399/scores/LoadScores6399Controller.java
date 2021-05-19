package java6399.scores;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LoadScores6399Controller {

    @FXML
    private Label lblFilename;

    @FXML
    private TableView<Score6399> tvScores;

    @FXML
    private TableColumn<Score6399, String> colName;

    @FXML
    private TableColumn<Score6399,String> colChinese;

    @FXML
    private TableColumn<Score6399,String> colMath;

    @FXML
    private TableColumn<Score6399,String> colEnglish;

    @FXML
    private TableColumn<Score6399,String> colSum;

    @FXML
    private void initialize() {//对不同列进行初始化设置
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colChinese.setCellValueFactory(new PropertyValueFactory<>("Chinese"));
        colMath.setCellValueFactory(new PropertyValueFactory<>("Math"));
        colEnglish.setCellValueFactory(new PropertyValueFactory<>("English"));
        colSum.setCellValueFactory(new PropertyValueFactory<>("sum"));
    }

    @FXML
    void openFile(ActionEvent event) {
        List<Score6399>list=new ArrayList<>();
        Stage stage=new Stage();
        FileChooser fileChooser=new FileChooser();
        fileChooser.setTitle("请选择学生文件");
        fileChooser.setInitialDirectory(new File("D://"));
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("文本文件","*.txt"),
                new FileChooser.ExtensionFilter("所有","*.*"));//文件过滤
         File file =fileChooser.showOpenDialog(stage);
         if(file==null){
             return;
         }
        if (!file.isDirectory()) {//确定输入的源文件，并确保源文件已经存在
            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));){
                //创建指向文件的带缓冲的字符输入流
                String line;
                while ((line = br.readLine()) != null) {//循环读数据，每次读一行
                    try {
                        Score6399 score6399=new Score6399();
                    String []s=line.split(",");
                    score6399.setName(s[0]);
                    int a=Integer.parseInt(s[1]);
                    score6399.setChinese(a);
                    int b=Integer.parseInt(s[2]);
                    score6399.setMath(b);
                   int c= Integer.parseInt(s[3]);
                    score6399.setEnglish(c);
                    int sum=score6399.getsum();
                    score6399.setSum(sum);
                    list.add(score6399);
                }
            catch (Exception e){//输入异常直接下一个
                    continue;
                }}}
            catch (FileNotFoundException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }}
            list.sort(Comparator.comparing(Score6399::getSum,(s1,s2)->{
                return s2.compareTo(s1); }).thenComparing(Score6399::getMath,(s3,s4)->{
                    return s4.compareTo(s3);
            }));//利用正则表达式排序
         lblFilename.setText(list.size()+"条学生成绩数据："+file.getAbsolutePath());
        ObservableList<Score6399> observableList = FXCollections.observableList(list);
        tvScores.setItems(observableList);


}}
