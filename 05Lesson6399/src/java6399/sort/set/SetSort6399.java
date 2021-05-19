package java6399.sort.set;

import java6399.sort.list.Course6399;

import java.util.*;

public class SetSort6399 {

    public static void main(String[] args) {
        TreeSet<Course63991> set = new TreeSet<>();
        addset(set);
        System.out.println("______按分数降序______");
        for (Course63991 c : set
        ) {
            System.out.println(c);
        }//直接利用Treeset的compareto方法进行排序
        TreeSet<Course63991> set1 = new TreeSet<>(new Comparator<Course63991>() {
            @Override
            public int compare(Course63991 o1, Course63991 o2) {

                int sort1 = o1.getTerm().compareTo(o2.getTerm());
                if (sort1 == 0) return 1;
                return sort1;
            }
        });//匿名类重写方法进行学期排序
        addset(set1);

        System.out.println("______按学期升序______");
        for (Course63991 c : set1
        ) {
            System.out.println(c);
        }
        TreeSet<Course63991> set2 = new TreeSet<>(new Comparator<Course63991>() {
            @Override
            public int compare(Course63991 o1, Course63991 o2) {
                int sort = o1.getCredit() - o2.getCredit();
                if (sort == 0) return 1;
                return sort;
            }
        });//和学期同理
        addset(set2);
        System.out.println("______按学分升序______");
        for (Course63991 c : set2
        ) {
            System.out.println(c);
        }
        TreeSet<Course63991> set3 = new TreeSet<>(new Comparator<Course63991>() {
            @Override
            public int compare(Course63991 o1, Course63991 o2) {
                int i = o1.getTerm().compareTo(o2.getTerm());
                int i3 = i == 0 ? o1.getCredit() - o2.getCredit() : i;
                int sort3=i3==0?o1.getScore()-o2.getScore():i3;
                int sort4=sort3==0?o1.getName().compareTo(o2.getName()):sort3;
                int sort5=sort4==0?o1.getNo().compareTo(o2.getNo()):sort4;
                return sort5;
            }
        });//通过修改比较返回的顺序进行多关键字排序
        addset(set3);
        System.out.println("______多关键字排序：学期、学分______");
        for (Course63991 c : set3
        ) {
            System.out.println(c);
        }


    }

    private static void addset(TreeSet set) {

        set.add(new Course63991("操作系统", 3, 80, "2下", "B001"));
        set.add(new Course63991("Pthyon程序基础", 2, 85, "1下", "B002"));
        set.add(new Course63991("高等数学", 2, 85, "1下", "0002"));
        set.add(new Course63991("Java程序高级开发", 2, 83, "3上", "C001"));
        set.add(new Course63991("大学英语", 3, 96, "1上", "0001"));
        set.add(new Course63991("C程序设计基础", 4, 80, "1上", "A001"));
        set.add(new Course63991("面向对象程序设计", 4, 78, "2上", "A002"));
        set.add(new Course63991("数据库原理", 3, 78, "2上", "A003"));
        set.add(new Course63991("网络基础", 3, 75, "3上", "B003"));
        set.add(new Course63991("软件工程与UML", 3, 75, "3下", "C002"));
    }


}

