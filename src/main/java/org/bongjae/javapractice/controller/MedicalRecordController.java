package org.bongjae.javapractice.controller;

import org.bongjae.javapractice.model.MedicalRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MedicalRecordController {
    private List<MedicalRecord> medicalRecordList;

    public MedicalRecordController() {
        this.medicalRecordList = new ArrayList<>();
    }

    // 진료기록 등록
    public void addMedicalRecord(MedicalRecord medicalRecord){
        this.medicalRecordList.add(medicalRecord);
    }

    // 진료기록 삭제
    public void removeAllMedicalRecord(String phone){
        this.medicalRecordList.removeIf(p -> p.getPhone().equals(phone));
    }

    // 진료기록 조회
    public List<MedicalRecord> getMedicalRecord(String phone){
        return this.medicalRecordList.stream()
                .filter(e -> e.getPhone().equals(phone))
                .collect(Collectors.toList());
    }
}
