package org.bongjae.javapractice.controller;

import org.bongjae.javapractice.model.Customer;
import org.bongjae.javapractice.model.MedicalRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerController {
    private List<Customer> customerList;
    private MedicalRecordController medicalRecordController;
    private PetController petController;

    public CustomerController(PetController petController, MedicalRecordController medicalRecordController) {
        this.customerList = new ArrayList<>();
        this.petController = petController;
        this.medicalRecordController = medicalRecordController;
    }

    // 고객 등록
    public void addCustomer(Customer customer){
        this.customerList.add(customer);
    }

    // 고객 삭제
    public void removeCustomer(String phone) {
        this.customerList.removeIf(p -> p.getPhone().equals(phone));
        this.petController.removeAllPet(phone);
        this.medicalRecordController.removeAllMedicalRecord(phone);
    }

    // 고객 조회
    public Customer getCustomer(String phone){
        return this.customerList.stream()
                .filter(x -> x.getPhone().equals(phone))
                .findAny()
                .orElse(null);
    }

    public boolean isPhoneNumberExists(String phone){
        return this.customerList.stream()
                .anyMatch(x -> x.getPhone().equals(phone));
    }
}
