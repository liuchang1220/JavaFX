package java6399.lesson06;

import java.util.*;
import java.util.function.BiFunction;

public class Counter6399 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入一个字符串:");
        String s=sc.nextLine();
        TreeMap<Character,Integer>treeMap=new TreeMap<>();
        char[] chars=s.toCharArray();
       treeMap=time(chars);
       add(treeMap);
    }
    private static TreeMap time(char chars[]){
        TreeMap<Character,Integer>treeMap=new TreeMap<>();
        for(int i=0;i<chars.length;i++){
            char key=chars[i];
            int value1=1;
            treeMap.merge(key, value1, new BiFunction<Integer, Integer, Integer>() {//进行merge方法对不同key的value值进行比较覆盖
                @Override
                public Integer apply(Integer integer, Integer integer2) {
                    return integer+1;
                }
            });}
        return treeMap;
    }
    private static void add(TreeMap<Character,Integer>treeMap){//stringbuilder进行拼接并输出
        StringBuilder sb=new StringBuilder();
        Set<Character> set=treeMap.keySet();
        for (Character key1:set
        ) {
            Integer value=treeMap.get(key1);
            sb.append(key1).append("(").append(value).append(")");
        }
        System.out.println("result="+sb.toString());

    }
}
