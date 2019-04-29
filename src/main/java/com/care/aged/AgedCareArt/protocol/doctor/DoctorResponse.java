package com.care.aged.AgedCareArt.protocol.doctor;

import com.care.aged.AgedCareArt.entity.Patient;

import java.util.List;

public class DoctorResponse {

    private String name;
    private List<Patient> patients;

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
