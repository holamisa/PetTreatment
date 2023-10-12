package org.bongjae.javapractice;

import org.bongjae.javapractice.controller.CustomerController;
import org.bongjae.javapractice.controller.MedicalRecordController;
import org.bongjae.javapractice.model.Customer;
import org.bongjae.javapractice.model.MedicalRecord;
import org.bongjae.javapractice.view.ConsoleView;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MedicalRecordController medicalRecordController = new MedicalRecordController();
        CustomerController customerController = new CustomerController(medicalRecordController);

        ConsoleView view = new ConsoleView();

        boolean runApp = true;
        while(runApp){
            System.out.println("==애완동물진료시스템==");
            System.out.println("1. 신규 고객 입력.");
            System.out.println("2. 진료 기록 저장");
            System.out.println("3. 진료 기록 조회");
            System.out.println("4. 진료 기록 삭제");
            System.out.println("5. 종료");
            System.out.println("원하는 기능을 선택해주세요.");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice){
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
                case 2:
                    phoneNumber = view.getPhoneNumber();
                    Customer customer = customerController.getCustomer(phoneNumber);
                    if(customer == null){
                        view.printMessage("등록된 고객정보가 없습니다.");
                        continue;
                    }
                    MedicalRecord newMedicalRecord = view.getMedicalRecordInfo();
                    newMedicalRecord.setPhone(phoneNumber);
                    medicalRecordController.addMedicalRecord(newMedicalRecord);
                    customer.addMedicalRecord(newMedicalRecord);

                    view.printMessage("진료기록 저장 완료.");
                    break;
                case 3:
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
                    view.printMessage(medicalRecordList.toString());
                    break;
                case 4:
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
                    customer.removeMedicalRecord();
                    view.printMessage("진료기록 삭제 완료.");
                    break;
                case 5:
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