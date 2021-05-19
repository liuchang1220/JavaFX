package java6399.genric;

public class DemoMyMath6399 {
    public static void main(String[] args) {
        MyMath6399<Integer> a = new MyMath6399<>(1, 2);
        System.out.println("两个整形输出");
        System.out.println("max: "+a.max6399()+" "+"min: "+a.min6399());
        MyMath6399<String> a2=new MyMath6399<>("waaa","geee");
        System.out.println("两个字符串输出");
        System.out.println("max: "+a2.max6399()+" "+"min: "+a2.min6399());
        MyMath6399<Character>a3=new MyMath6399<>('a','b');
        System.out.println("两个字符输出");
        System.out.println("max: "+a3.max6399()+" "+"min: "+a3.min6399());
        //MyMath6399<StringBuffer>a3=new MyMath6399<StringBuffer>();
        //基本数据类型的封装类中都实现了Comparable接口故可以进行比较，而StringBuffer类没有实现

    }
}
