package Java6399.newdate;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.input.MouseEvent;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class MothersDay6399Controller {

    @FXML
    private Spinner sYear=new Spinner<Integer>(0,9999,0);

    @FXML
    private Label lblMothersDay;

    @FXML
    void buttonClick(MouseEvent event) {

        DateTimeFormatter formatter1=DateTimeFormatter.ofPattern("yyyy-M");
        YearMonth ym=YearMonth.parse(sYear.getValue().toString()+"-5",formatter1);//用yearmonth进行解析
        LocalDate date=ym.atDay(1);
        TemporalAdjuster adjuster= TemporalAdjusters.dayOfWeekInMonth(2, DayOfWeek.SUNDAY);
        LocalDate date1=date.with(adjuster);
        lblMothersDay.setText(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format(date1));//默认格式输出


    }

}
