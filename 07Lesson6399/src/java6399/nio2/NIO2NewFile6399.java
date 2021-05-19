package java6399.nio2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class NIO2NewFile6399 {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        String fliename=sc.nextLine();
        Path path= Paths.get(fliename);
        if(!Files.exists(path)){
            File parent=path.toFile().getParentFile();
            if(parent!=null&&!parent.exists()){
                if(!parent.mkdirs()){
                    System.out.println("no set up");
            }

            }
            if((path.getRoot() == null)){
                    Files.createFile(path);

                System.out.println(path.isAbsolute());
        }else {
                System.out.println("无此盘");
            }
    }else{
            System.out.println("文件已存在");
        }
}}
