package java6399.lesson09;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;

public class ReadFile6399Controller {

    @FXML
    private TextField tfFilename;

    @FXML
    private TextArea taText;

    @FXML
    void readFile(ActionEvent event) throws IOException {
        String s = tfFilename.getText();
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File(s);
        if (!file.isDirectory()) {//确定输入的源文件，并确保源文件已经存在
            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));){
                //创建指向文件的带缓冲的字符输入流
                String line;
                while ((line = br.readLine()) != null) {//循环读数据，每次读一行
                    stringBuilder.append(line+"\n");
                }
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }
            taText.setText(stringBuilder.toString());//将读到的数据显示在多行文本框中
        }
    }

}


