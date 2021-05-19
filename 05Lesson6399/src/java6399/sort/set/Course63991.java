package java6399.sort.set;

import java.util.Objects;

public class Course63991 implements Comparable<Course63991> {
    private String name;
    private int credit;
    private int score;
    private  String term;
    private String no;

    public Course63991(String name, int credit, int score, String term, String no) {
        this.name = name;
        this.credit = credit;
        this.score = score;
        this.term = term;
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Course63991() {
    }

    @Override
    public String toString() {
        return "成绩："+score+", "+term+", "+credit+"学分"+"【"+no+" "+name+"】";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course63991 that = (Course63991) o;
        return credit == that.credit &&
                score == that.score &&
                Objects.equals(name, that.name) &&
                Objects.equals(term, that.term) &&
                Objects.equals(no, that.no);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, credit, score, term, no);
    }

    @Override
    public int compareTo(Course63991 o) {
        int sort1=o.score-score;
        int sort2=sort1==0 ?credit-o.credit:sort1;
        int sort3=sort2==0?name.compareTo(o.name):sort2;
        int sort4=sort3==0?no.compareTo(o.no):sort3;
        int sort5=sort4==0?term.compareTo(o.term):sort4;
        return sort5;
    }
}


