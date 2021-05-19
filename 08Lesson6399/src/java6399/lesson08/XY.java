package java6399.lesson08;

import java.io.File;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class XY{
    String s;

    public XY(String s) {
        this.s = s;
    }
    static boolean FilterByType(File dir,String name){
        return name.endsWith(".java");
    }
    static boolean FilterBysize(File dir,String name){
        return dir.length() / 1024 > 2 * 1024;
    }
    static boolean FilterBytime(File dir,String name){
        LocalDateTime rq=LocalDateTime.now().plusDays(3);
        long m=rq.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        return dir.lastModified()<m;
    }

}