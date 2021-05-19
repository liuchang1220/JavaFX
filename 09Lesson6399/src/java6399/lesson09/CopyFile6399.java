package java6399.lesson09;

import java.io.*;
import java.util.Scanner;


public class CopyFile6399 {
  public static void main(String[] args) throws Exception {
    Scanner input = new Scanner(System.in);
    System.out.print("请输入要拷贝的源文件名：");
    String source = input.nextLine();
    System.out.print("请输入目标文件名：");
    String target = input.nextLine();
    //调用checkFile6399()方法检查两个文件名是否可用
    if(checkFile6399(source,target)){
      long beginTime=System.currentTimeMillis();//调用System.currentTimeMillis()记下开始时间-->beginTime
      long a=copy6399(source,target); //如果两个文件名可用，调用copy6399()方法完成文件拷贝，并返回文件的字节数
      long overTime=System.currentTimeMillis();
      long s=overTime-beginTime;
      System.out.println("拷贝"+a+"字节，"+"用时："+s+"毫秒"); //输出拷贝文件的字节数和用时
    }else {
      System.out.println("文件名不可用");
    }
  }

  private static boolean checkFile6399(String sourceName, String targetName) {
    File file=new File(sourceName);
    File file1=new File(targetName);
    if(file.exists()){
      File file2=file1.getParentFile();
     if(!file2.exists()){
       file2.mkdirs();
     }
     return true;
    }
    return false;
    //确保源文件已经存在
    //调用File的getParentFile()，得到目标文件名所包含的路径
    //判断目标路径是否已经存在，如果不存在，创建
  }

  private static long copy6399(String sourceName, String targetName) throws IOException {
    BufferedReader br=new BufferedReader(new FileReader(sourceName));//针对源文件，创建带缓冲的输入流
    BufferedWriter bw=new BufferedWriter(new FileWriter(targetName));//针对目标文件，创建带缓冲的输出流
    char []c=new  char[1024];// 定义一个字节数组，作为缓冲区-->buff
    int len=0;
    long s=0;
    while((len=br.read(c))!=-1){ //循环执行下列步骤，直到文件结束
      bw.write(c,0,len);
      bw.flush();
      s+=len;
    }
    br.close();
    bw.close();
    return s;
    //关闭输入流和输出流
    //返回字节数
  }
}