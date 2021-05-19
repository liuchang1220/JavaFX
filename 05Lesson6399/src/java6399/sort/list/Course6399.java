package java6399.sort.list;

import java.util.Objects;

public class Course6399  {
     private String name;
     private int credit;
     private int score;
     private  String term;
     private String no;

    public Course6399(String name, int credit, int score, String term, String no) {
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

    public Course6399() {
    }

    @Override
    public String toString() {
        return "成绩："+score+", "+term+", "+credit+"学分"+"【"+no+" "+name+"】";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course6399 that = (Course6399) o;
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
}
