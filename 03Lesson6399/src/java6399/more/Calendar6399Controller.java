package java6399.more;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.time.LocalDate;
import java.time.YearMonth;

public class Calendar6399Controller {
    private int Year;
    private int Mouth;
    private final String[] monthNames={"","一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月",
    "十二月",};//构造数组先进行存放label的显示数据
    @FXML
    private DatePicker dpSelect;

    @FXML
    private Label lblMonth;

    @FXML
    private GridPane gpDayList;

    @FXML
    private void initialize(){
        for(int row=1;row<7;row++){
            for(int col=0;col<7;col++){//初始话表格存储日期
                Label label=new Label();
                GridPane.setValignment(label, VPos.CENTER);
                GridPane.setHalignment(label,HPos.CENTER);
                gpDayList.add(label,col,row);
            }
        }
        dpSelect.setValue(LocalDate.now());//默认日期在DatePicker为当前时间
        onClick(null);
    }
    @FXML
    void onClick(ActionEvent event) {
        if(dpSelect.getValue()==null){
            dpSelect.setValue(LocalDate.now());
        }
        int newyear=dpSelect.getValue().getYear();
        int newmouth=dpSelect.getValue().getMonthValue();
        if(Year==newyear&&Mouth==newmouth){

        }else{
            Year=newyear;
            Mouth=newmouth;
            fill(newyear,newmouth);
            lblMonth.setText(newyear+"年"+monthNames[newmouth]+"的日历");//获得选中的年月在label中返回
        }
    }

    private void fill(int year, int mouth) {
        ObservableList<Node>list=gpDayList.getChildren();
        int gpStarIndex=8;
        YearMonth yearMonth=YearMonth.of(year,mouth);
        LocalDate start=yearMonth.atDay(1);
        int weekstart=start.getDayOfWeek().getValue();
        int i=0;
        for(;i<weekstart;i++){
            ((Label)list.get(i+gpStarIndex)).setText("");//清空一号之前的表格
        }
        int days=yearMonth.lengthOfMonth();
        int day=1;
        for(;i<weekstart+days;i++){//利用i++来遍历表格数据
            ((Label)list.get(i+gpStarIndex)).setText(""+day++);
        }
        for(;i<list.size()-gpStarIndex;i++){
            ((Label)list.get(i+gpStarIndex)).setText("");
        }
    }

}
