package org.bongjae.javapractice.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String birth;
    private String phone;
    private List<Pet> petList;
    private List<MedicalRecord> medicalRecordList;

    public Customer (){}

    public Customer(String name, String birth, String phone) {
        this.name = name;
        this.birth = birth;
        this.phone = phone;
        this.petList = new ArrayList<>();
        this.medicalRecordList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Pet> getPetList() {
        return petList;
    }

    public void addPet(Pet pet) {
        this.petList.add(pet);
    }

    public List<MedicalRecord> getMedicalRecordList() {
        return medicalRecordList;
    }

    public void addMedicalRecord(MedicalRecord medicalRecord) {
        this.medicalRecordList.add(medicalRecord);
    }

    public void removeMedicalRecord(){
        this.medicalRecordList.clear();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "이름='" + name + '\'' +
                ", 생일='" + birth + '\'' +
                ", 휴대폰 번호='" + phone + '\'' +
                ", 동물=" + petList +
                ", 진료기록=" + medicalRecordList +
                '}';
    }
}
