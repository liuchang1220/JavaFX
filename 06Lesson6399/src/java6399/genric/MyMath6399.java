package java6399.genric;

import java.util.*;

class MyMath6399<T extends  Comparable<T>>   {
    private T data;
    private T data2;


    public T getData2() {
        return data2;
    }

    public void setData2(T data2) {
        this.data2 = data2;
    }

    public MyMath6399(T data, T data2) {
        this.data = data;
        this.data2 = data2;
    }

    public MyMath6399() {
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T max6399(){
        List<T> list=new ArrayList<>();
        list.add(data);
        list.add(data2);
        Collections.sort(list, new Comparator<T>() {//匿名内部类实现比较器对list排序
            @Override
            public int compare(T o1, T o2) {
               return o1.compareTo(o2);
            }
        });
        return list.get(1);
    }
    public T min6399(){
        List<T> list=new ArrayList<>();
        list.add(data);
        list.add(data2);
        Collections.sort(list, new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.compareTo(o2);
            }
        });
        return list.get(0);
    }

}
