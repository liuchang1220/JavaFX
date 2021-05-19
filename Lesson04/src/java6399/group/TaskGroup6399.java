package java6399.group;

import com.sun.deploy.security.BadCertificateDialog;
import com.sun.org.apache.bcel.internal.generic.FADD;
import com.sun.org.apache.bcel.internal.generic.IADD;
import com.sun.org.apache.bcel.internal.generic.LADD;
import java6399.lesson04.Foreach6399;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TaskGroup6399 {
    static int count = 0;//记录循环次数
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("data/StudentList.txt"));//从文件接收数据存入集合中
        ArrayList<Student6399> list = new ArrayList<>();
        int c = 0;//记录班级人数
        while (sc.hasNext()) {
            String line = sc.nextLine();
            list.add(new Student6399(line.split(" ")[1]));
            c++;
        }
        ArrayList<Integer> list1 = random1(c);
        int Student[] = new int[c];
        for (int i = 0; i < list1.size(); i++) {
            Student[i] = list1.get(i);//讲集合转化为数组进行存储每组人数
        }
        Scanner sc1 = new Scanner(new File("data/StudentList.txt"));
        ArrayList<String> list2 = new ArrayList<>();
        System.out.println("班级人数：" + c);
        System.out.println("经过"+count+"次循环，得到分组方案：分为"+list1.size()+"组"+list1);
        List<String>list3=new ArrayList<>();
        for (int i = 0; i < c; i++) {
            list3.add(sc1.nextLine());
        }
      Collections.shuffle(list3);
        int a=0;
        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < Student[i]; j++) {
                String line = list3.get(a++);
                list2.add(line);//重新进行分组并通过循环控制输出
            }
            int i1 = i + 1;
            System.out.println("第" + i1 + "组" + list2 + Student[i] + "人");
            list2.removeAll(list2);
        }


    }
    private static ArrayList<Integer> random1(int c) {
        ArrayList<Integer> list = new ArrayList<>();
        int s = 0;

        while (s != c) {
            int t = 5 + (int) (Math.random() * (3));//生成5-7之间的数字
            s += t;
            if (s <= c) {
                list.add(t);
            } else {
                list.removeAll(list);//不满足条件清零，继续循环
                s = 0;
            }
            count++;
        }
        return list;

    }
}


