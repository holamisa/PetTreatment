package org.bongjae.javapractice.model;

import java.util.List;

public class Pet {
    private String phone;
    private String name;
    private String type;
    private String age;

    public Pet(){

    }

    public Pet(String phone, String name, String type, String age) {
        this.phone = phone;
        this.name = name;
        this.type = type;
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
        return "휸대폰 번호='" + phone + '\'' +
                ", 이름='" + name + '\'' +
                ", 종류='" + type + '\'' +
                ", 나이='" + age + '\'';
    }
}
