package com.care.aged.AgedCareArt.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Nurse {

    @Id
    @GeneratedValue
    private Long nurseId;
    private String name;
    @OneToMany(targetEntity=Patient.class, mappedBy="nurse", fetch= FetchType.EAGER)
    private List<Patient> patients;

    public Long getNurseId() {
        return nurseId;
    }

    public void setNurseId(Long nurseId) {
        this.nurseId = nurseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
}
