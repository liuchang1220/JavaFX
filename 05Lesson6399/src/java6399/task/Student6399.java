package java6399.task;

import java6399.lesson05.PointDemo6399;

import java.util.Objects;

public class Student6399 implements Comparable<Student6399> {
    private String name;
    private int year;

    public Student6399(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public Student6399() {
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student6399 that = (Student6399) o;
        return year == that.year &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, year);
    }

    @Override
    public String toString() {
        return name+","+year;
    }

    public int compareTo(Student6399 o) {
    if (this.year>o.year){
        return 1;
    }
    else if (this.year<o.year){
        return -1;
    }else {
        return this.name.compareTo(o.name);
    }
    }



}
