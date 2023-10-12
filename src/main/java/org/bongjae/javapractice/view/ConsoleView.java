package org.bongjae.javapractice.view;

import org.bongjae.javapractice.model.Customer;
import org.bongjae.javapractice.model.MedicalRecord;
import org.bongjae.javapractice.model.Pet;

import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    private Scanner scanner = new Scanner(System.in);

    // 전화번호 입력
    public String getPhoneNumber(){
        System.out.print("전화번호 입력하세요: ");
        return scanner.nextLine();
    }

    // 고객정보 입력
    public Customer getCustomerInfo(){
        System.out.println("신규 고객 정보 입력하세요.");
        System.out.print("전화번호: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("이름: ");
        String name = scanner.nextLine();
        System.out.print("생일: ");
        String birth = scanner.nextLine();

        return new Customer(name,birth,phoneNumber);
    }

    // 동물정보 입력
    public Pet getPetInfo(){
        System.out.println("신규 반려동물 정보 입력하세요.");
        System.out.print("이름: ");
        String name = scanner.nextLine();
        System.out.print("종류: ");
        String type = scanner.nextLine();
        System.out.print("나이: ");
        String age = scanner.nextLine();

        return new Pet(name, type, age);
    }

    // 진료기록 입력
    public MedicalRecord getMedicalRecordInfo(){
        System.out.println("신규 진료기록 정보 입력하세요.");
        System.out.print("날짜: ");
        String date = scanner.nextLine();
        System.out.print("내용: ");
        String content = scanner.nextLine();

        return new MedicalRecord(null, date, content);
    }

    // 동물정보 조회
    public void printPetInfo(Customer customer){
        List<Pet> petList = customer.getPetList();
        for (Pet pet:
             petList) {
            System.out.println(pet);
        }
    }

    public void printMedicalRecordInfo(Customer customer){
        List<MedicalRecord> medicalRecordList = customer.getMedicalRecordList();
        for (MedicalRecord medicalRecord:
             medicalRecordList) {
            System.out.println(medicalRecord);
        }
    }

    // 메세지 출력
    public void printMessage(String message){
        System.out.println(message);
    }
}
