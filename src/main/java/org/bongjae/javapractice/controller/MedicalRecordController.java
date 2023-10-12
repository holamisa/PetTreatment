package org.bongjae.javapractice.controller;

import org.bongjae.javapractice.model.MedicalRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MedicalRecordController {
    private List<MedicalRecord> medicalRecordList = new ArrayList<>();

    // 진료기록 등록
    public void addMedicalRecord(MedicalRecord medicalRecord){
        medicalRecordList.add(medicalRecord);
    }

    // 진료기록 삭제
    public void removeAllMedicalRecord(String phone){
        medicalRecordList.removeIf(p -> p.getPhone().equals(phone));
    }

    // 진료기록 조회
    public List<MedicalRecord> getMedicalRecord(String phone){
        return medicalRecordList.stream()
                .filter(e -> e.getPhone().equals(phone))
                .collect(Collectors.toList());
    }
}
