package ru.sapteh.model;

import java.util.Objects;

public class Course {


    private final int id;
    private final String course;
    private final String fio;
    private String data1;
    private String data2;
    private String data3;
    private String data4;

    public Course(int id,String course, String fio, String data1, String data2, String data3, String data4) {
        this.id = id;
        this.course = course;
        this.fio = fio;
        this.data1 = data1;
        this.data2 = data2;
        this.data3 = data3;
        this.data4 = data4;
    }

    public int getId() {
        return id;
    }

    public String getFio() {
        return fio;
    }

    public String getData1() {
        return data1;
    }

    public String getData2() {
        return data2;
    }

    public String getData3() {
        return data3;
    }

    public String getData4() {
        return data4;
    }

    public void setData1(String data1) {
        this.data1 = data1;
    }

    public void setData2(String data2) {
        this.data2 = data2;
    }

    public void setData3(String data3) {
        this.data3 = data3;
    }

    public void setData4(String data4) {
        this.data4 = data4;
    }

    @Override
    public String toString(){
        return String.format("%s; %s; %s; %s; %s \n",getFio(),getData1(),getData2(),getData3(),getData4());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course1 = (Course) o;
        return id == course1.id &&
                Objects.equals(course, course1.course) &&
                Objects.equals(fio, course1.fio) &&
                Objects.equals(data1, course1.data1) &&
                Objects.equals(data2, course1.data2) &&
                Objects.equals(data3, course1.data3) &&
                Objects.equals(data4, course1.data4);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, course, fio, data1, data2, data3, data4);
    }
}
