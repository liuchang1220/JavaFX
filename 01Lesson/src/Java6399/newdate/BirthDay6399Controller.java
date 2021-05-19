package Java6399.newdate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class BirthDay6399Controller {

    @FXML
    private DatePicker dpBirthDay=new DatePicker();

    @FXML
    private Label lblResult;

    @FXML
    void change(ActionEvent event) {
        LocalDate date=LocalDate.now();
        LocalDate date1= dpBirthDay.getValue();
        Period period=Period.between(date1,date);//用Period进行日期加减
        int a2=period.getYears();
        int a1=date.until(date1).getDays();
        if(a1>0){//判断天数在当前时间之前还是之后
        lblResult.setText("还有"+a1+"天,"+a2+"岁生日，有惊喜");}
         if(a1==0){
            lblResult.setText("今天是你,"+a2+"岁生日，有惊喜");}
          if(a2<=0&&a1<0) {
            lblResult.setText("已过"+-a1+"天,"+a2+"岁生日，有惊喜");}

         if(a2<=0&&a1>0){
            lblResult.setText("");
    }


    }}


