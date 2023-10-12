package org.bongjae.javapractice.controller;

import org.bongjae.javapractice.model.MedicalRecord;
import org.bongjae.javapractice.model.Pet;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PetController {
    private List<Pet> petList;

    public PetController() {
        this.petList = new ArrayList<>();
    }

    public void addPet(Pet pet){
        this.petList.add(pet);
    }

    public void removeAllPet(String phone){
        this.petList.removeIf(p -> p.getPhone().equals(phone));
    }

    public List<Pet> getPetList(String phone){
        return this.petList.stream()
                .filter(e -> e.getPhone().equals(phone))
                .collect(Collectors.toList());
    }

    public Pet getPetListByName(String name){
        return this.petList.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
