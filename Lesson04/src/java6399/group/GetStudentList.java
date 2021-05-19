package java6399.group;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class GetStudentList {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner sc = new Scanner(new File("data/StudentList.txt"));
    ArrayList<Student6399> list = new ArrayList<>();
    while (sc.hasNext()) {
      String line = sc.nextLine();
      list.add(new Student6399(line.split(" ")[1]));
    }
    System.out.println(list);
  }
}
