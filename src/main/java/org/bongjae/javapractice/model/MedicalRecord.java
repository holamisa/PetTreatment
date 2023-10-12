package org.bongjae.javapractice.model;

public class MedicalRecord {
    private String phone;
    private String date;
    private String content;

    public MedicalRecord() {
    }

    public MedicalRecord(String phone, String date, String content) {
        this.phone = phone;
        this.date = date;
        this.content = content;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "MedicalRecord{" +
                "휴대폰 번호='" + phone + '\'' +
                ", 날짜='" + date + '\'' +
                ", 진료내용='" + content + '\'' +
                '}';
    }
}
