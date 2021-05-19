package java6399.lesson06;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ProFile6399 {
    public static void main(String[] args) throws IOException {
        Properties properties=new Properties();
        InputStream stream=ProFile6399.class.getResourceAsStream("myProFile6399.properties");//io寻找本层文件
        properties.load(stream);//装载io流
        System.out.println(properties.getProperty("id"));
        System.out.println(properties.getProperty("name"));
        System.out.println(properties.getProperty("sex"));
        System.out.println(properties.getProperty("age"));//getResourceAsStream()与getResource()的不同点参数相同，
        // getResource后new InputStream(file)数据流的转换

    }
}
