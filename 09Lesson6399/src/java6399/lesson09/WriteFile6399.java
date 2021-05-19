package java6399.lesson09;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class WriteFile6399 {
     static StringBuilder stringBuilder=new StringBuilder();
    public static void main(String[] args) {
        System.out.print("请输入文件名：");
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        System.out.println("请逐行输入要写入文件的内容，直到输入end结束");

        while (true){
           String string=sc.nextLine();
            stringBuilder.append(string+"\n");
            if(string.equalsIgnoreCase("end")){
                break;
            }
        }
       long a= write6399(s);// 调用write6399()向文件中输出字符串，并返回字节数
        System.out.println("已向文件"+s+"中写入"+a+"字节");
    }
    private  static  long write6399(String s){
        byte []a=new byte[s.length()*4];
        try {
            File file=new File(s);// 步骤1：确定输出的文件（目的地）
            Writer out=new FileWriter(file);// 步骤2：创建指向文件的字符输出流
            out.write(stringBuilder.toString());// 步骤3：写数据
            a=stringBuilder.toString().getBytes();
            out.close();// 返回文件的字节数
        } catch (IOException e) {
            e.printStackTrace();
        }
        return a.length;
    }
}
