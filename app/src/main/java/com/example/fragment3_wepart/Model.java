package com.example.fragment3_wepart;

import java.io.Serializable;

public class Model implements Serializable {
    private String name;
    private int age;
    private String grade;
    private String percentage;

    public Model(String name, int age, String grade, String percentage) {

        this.name = name;
        this.age = age;
        this.grade = grade;
        this.percentage = percentage;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGrade() {
        return grade;
    }

    public String getPercentage() {
        return percentage;
    }
}
