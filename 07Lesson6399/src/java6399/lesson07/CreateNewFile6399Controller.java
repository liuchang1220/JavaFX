package java6399.lesson07;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.IOException;

public class CreateNewFile6399Controller {

    @FXML
    private TextField tfFilename;

    @FXML
    private Label lblMessage;

    @FXML
    void listAll(ActionEvent event) throws IOException {
        String filename = tfFilename.getText().trim();

        File file = new File(filename);
        if (!file.exists()) {
            File parent = file.getParentFile();//判断是否可以生成父目录
            if (parent != null && !parent.exists()) {//不使用getParent方法的话会生成文件夹而不是文件
                if (!parent.mkdirs()) {//判断parents的多层目录，若只判断一层可能会出现重名现象
                    lblMessage.setText("不能创建目录：" + parent);
                }
                lblMessage.setText("创建目录：" + parent);
            }

            file.createNewFile();
            lblMessage.setText("创建新文件：" + file.getAbsolutePath());

        } else {
            lblMessage.setText("文件已存在");
        }
    }
}


