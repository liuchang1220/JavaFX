package java6399.genric;

import java.util.*;
import java.util.function.BiFunction;
public class Counter6399 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入一个字符串:");
        String s=sc.nextLine();
        TreeMap<Character,Integer>treeMap=new TreeMap<>();
        char[] chars=s.toCharArray();
        for(int i=0;i<chars.length;i++){
         char key=chars[i];
         int value1=1;
        treeMap.merge(key, value1, new BiFunction<Integer, Integer, Integer>() {//进行merge方法对不同key的value值进行比较覆盖
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer+1;
            }
        });}

        List<Map.Entry<Character,Integer>>list=new ArrayList<>(treeMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {//通过匿名内部类定义规则排序
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                int i=o2.getValue()-o1.getValue();
                return i==0?o1.getKey().compareTo(o2.getKey()):i;
            }
        });
                System.out.println(list);
    }
}
