package org.bongjae.javapractice;

import org.bongjae.javapractice.controller.CustomerController;
import org.bongjae.javapractice.controller.MedicalRecordController;
import org.bongjae.javapractice.controller.PetController;
import org.bongjae.javapractice.model.Customer;
import org.bongjae.javapractice.model.MedicalRecord;
import org.bongjae.javapractice.model.Pet;
import org.bongjae.javapractice.view.ConsoleView;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MedicalRecordController medicalRecordController = new MedicalRecordController();
        PetController petController = new PetController();
        CustomerController customerController = new CustomerController(petController, medicalRecordController);

        ConsoleView view = new ConsoleView();

        boolean runApp = true;
        while(runApp){
            System.out.println("==애완동물진료시스템==");

            // 고객관리
            System.out.println("1. 신규 고객 입력.");
            System.out.println("2. 고객 조회.");
            System.out.println("3. 고객 삭제.");

            // 반려동물 관리
            System.out.println("4. 신규 반려동물 입력.");
            System.out.println("5. 반려동물 조회.");
            System.out.println("6. 반려동물 삭제.");

            // 진료기록 관리
            System.out.println("7. 신규 진료기록 입력.");
            System.out.println("8. 진료기록 조회");
            System.out.println("9. 진료기록 삭제");

            System.out.println("10. 종료");
            System.out.println("원하는 기능을 선택해주세요.");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice){
                // 신규 고객
                case 1:
                    Customer newCustomer = view.getCustomerInfo();
                    String phoneNumber = newCustomer.getPhone();
                    if(customerController.isPhoneNumberExists(phoneNumber)){
                        view.printMessage("이미 등록된 전화번호입니다.");
                        continue;
                    }
                    customerController.addCustomer(newCustomer);
                    view.printMessage("고객 저장 완료.");
                    break;
                // 고객 조회
                case 2:
                    phoneNumber = view.getPhoneNumber();
                    Customer customer = customerController.getCustomer(phoneNumber);
                    if(customer == null){
                        view.printMessage("등록된 고객정보가 없습니다.");
                        continue;
                    }
                    view.printMessage(customer.toString());
                    break;
                // 고객 삭제
                case 3:
                    phoneNumber = view.getPhoneNumber();
                    customer = customerController.getCustomer(phoneNumber);
                    if(customer == null){
                        view.printMessage("등록된 고객정보가 없습니다.");
                        continue;
                    }
                    customerController.removeCustomer(phoneNumber);
                    view.printMessage("고객정보 삭제 완료.");
                    break;
                // 신규 반려동물
                case 4:
                    phoneNumber = view.getPhoneNumber();
                    customer = customerController.getCustomer(phoneNumber);
                    if(customer == null){
                        view.printMessage("등록된 고객정보가 없습니다.");
                        continue;
                    }
                    Pet newPet = view.getPetInfo();
                    newPet.setPhone(phoneNumber);
                    petController.addPet(newPet);
                    customer.addPet(newPet);
                    view.printMessage("반려동물 등록완료.");
                    break;
                // 반려동물 조회
                case 5:
                    phoneNumber = view.getPhoneNumber();
                    customer = customerController.getCustomer(phoneNumber);
                    if(customer == null){
                        view.printMessage("등록된 고객정보가 없습니다.");
                        continue;
                    }
                    List<Pet> petList = petController.getPetList(phoneNumber);
                    if(petList == null || petList.isEmpty()){
                        view.printMessage("등록된 반려동물이 없습니다.");
                        continue;
                    }
                    for (Pet pet:
                         petList) {
                        view.printMessage(pet.toString());
                    }
                    break;
                // 반려동물 삭제
                case 6:
                    phoneNumber = view.getPhoneNumber();
                    customer = customerController.getCustomer(phoneNumber);
                    if(customer == null){
                        view.printMessage("등록된 고객정보가 없습니다.");
                        continue;
                    }
                    petController.removeAllPet(phoneNumber);
                    customer.removeAllPet();
                    view.printMessage("등록된 모든 반려동물 삭제.");
                    break;
                // 신규 진료기록
                case 7:
                    phoneNumber = view.getPhoneNumber();
                    customer = customerController.getCustomer(phoneNumber);
                    if(customer == null){
                        view.printMessage("등록된 고객정보가 없습니다.");
                        continue;
                    }
                    MedicalRecord newMedicalRecord = view.getMedicalRecordInfo();
                    if(petController.getPetListByName(newMedicalRecord.getName()) == null){
                        view.printMessage("등록된 반려동물이 없습니다.");
                        continue;
                    }
                    newMedicalRecord.setPhone(phoneNumber);
                    medicalRecordController.addMedicalRecord(newMedicalRecord);
                    customer.addMedicalRecord(newMedicalRecord);
                    view.printMessage("진료기록 저장 완료.");
                    break;
                // 진료기록 조회
                case 8:
                    phoneNumber = view.getPhoneNumber();
                    customer = customerController.getCustomer(phoneNumber);
                    if(customer == null){
                        view.printMessage("등록된 고객정보가 없습니다.");
                        continue;
                    }
                    List<MedicalRecord> medicalRecordList = medicalRecordController.getMedicalRecord(phoneNumber);
                    if(medicalRecordList == null || medicalRecordList.isEmpty()){
                        view.printMessage("등록된 진료기록이 없습니다.");
                        continue;
                    }
                    for (MedicalRecord medicalRecord:
                            medicalRecordList) {
                        view.printMessage(medicalRecord.toString());
                    }
                    break;
                // 진료기록 삭제
                case 9:
                    phoneNumber = view.getPhoneNumber();
                    customer = customerController.getCustomer(phoneNumber);
                    if(customer == null){
                        view.printMessage("등록된 고객정보가 없습니다.");
                        continue;
                    }
                    medicalRecordList = medicalRecordController.getMedicalRecord(phoneNumber);
                    if(medicalRecordList == null || medicalRecordList.isEmpty()){
                        view.printMessage("등록된 진료기록이 없습니다.");
                        continue;
                    }
                    medicalRecordController.removeAllMedicalRecord(phoneNumber);
                    customer.removeAllMedicalRecord();
                    view.printMessage("진료기록 삭제 완료.");
                    break;
                // 프로그램 종료
                case 10:
                    view.printMessage("프로그램 종료.");
                    runApp = false;
                    return;
                default:
                    view.printMessage("잘못 입력하셨습니다.");
                    break;
            }
        }
    }
}