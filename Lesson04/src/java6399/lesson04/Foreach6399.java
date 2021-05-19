package java6399.lesson04;

import java.util.*;

public class Foreach6399 {
    public static void main(String[] args) {
        Student6399 student1=new Student6399("liu", 18);
        Student6399 student2=new Student6399("liu1", 20);
        Student6399 student3=new Student6399("liu2", 21);
        Collection <Student6399> c=new ArrayList<>();
        c.add(student1);
        c.add(student2);
        c.add(student3);
        useIterator6399(c);
        useForeach6399(c);
        useList6399(c);
        useList6399(c);
        useArray6399(c);
    }
public static class Student6399{
        private String name;//姓名变量
        private int age;//年龄变量
        Student6399(){}

    public Student6399(String name,int age) {
        this.age = age;
        this.name=name;
    }//有参构造

    @Override
    public String toString() {
        return name +":"+ age;
    }}
    private static  void useIterator6399(Collection c){
        Iterator it=c.iterator();
        System.out.println("用迭代器遍历：");//迭代器遍历
        while (it.hasNext()){
            Object object=it.next();
            System.out.println(object.toString());
        }

    }
    public  static  void useForeach6399(Collection c){
        System.out.println("用foreach方法遍历：");
        for (Object s:c
             ) {//加强for进行遍历
            System.out.println(s.toString());
        }
    }
    public static void useList6399(Collection c){
        List<Student6399> list=new ArrayList<>();
        list.addAll(c);//list数组下标进行遍历
        System.out.println("用数组下标遍历：");
        for (int i = 0; i <list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
    public static  void  useArray6399(Collection c){
    Student6399[] i=new Student6399[c.size()];
    c.toArray(i);//toArray方法转为数组遍历
        System.out.println("用toArray方法遍历：");
        for (int j = 0; j <i.length ; j++) {
            System.out.println(i[j].toString());

        }
    }



}
