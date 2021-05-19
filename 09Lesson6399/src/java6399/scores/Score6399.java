package java6399.scores;

public class Score6399 {
    private String name;
    private int Chinese;
    private int math;
    private int english;
    private int sum;

    public Score6399() {
    }

    public Score6399(String name, int chinese, int math, int english) {
        this.name = name;
        Chinese = chinese;
        this.math = math;
        this.english = english;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChinese() {
        return Chinese;
    }

    public void setChinese(int chinese) {
        Chinese = chinese;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }
    public int getsum(){
        sum=this.Chinese+this.english+this.math;
        return sum;
    }
}
