package org.bongjae.javapractice.model;

import java.util.List;

public class Pet {
    private String name;
    private String type;
    private String age;

    public Pet(){

    }

    public Pet(String name, String type, String age) {
        this.name = name;
        this.type = type;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "이름='" + name + '\'' +
                ", 종류='" + type + '\'' +
                ", 나이='" + age + '\'' +
                '}';
    }
}
