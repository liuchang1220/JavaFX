package java6399.genric;

import com.sun.org.apache.xpath.internal.objects.XObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;

public class MapForeach6399 {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("liu", "男");
        hashMap.put("liu1", "男");
        hashMap.put("zhao", "mian");
        hashMap.remove("liu1");
        hashMap.merge("liu", "mian", new BiFunction<String, String, String>() {
            @Override
            public String apply(String s, String s2) {
                return "面";
            }
        });
        Set<Map.Entry<String,String>> set=hashMap.entrySet();//先通过set集合存储map的Entry对象
        System.out.println("利用Key的Set集合遍历Map集合的方法:");
        print6399(hashMap);
        System.out.println("利用Set<Map.Entry<K,V>>的集合遍历Map集合:");
        print6399(set);

    }

    private static void print6399(HashMap<String, String> hashMap) {//两方法重载进行输出
        Set<String>set=hashMap.keySet();
        Iterator<String>it=set.iterator();
        while(it.hasNext()){
            System.out.println(hashMap.get(it.next())+" ");
        }
    }
    private static void print6399(Set<Map.Entry<String,String>> set){
        for( Map.Entry<String,String> set1:set){
            System.out.println(set1.getKey()+" "+set1.getValue());
        }
    }


}
