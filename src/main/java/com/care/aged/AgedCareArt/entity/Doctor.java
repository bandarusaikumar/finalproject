package com.care.aged.AgedCareArt.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Doctor {

    @Id
    @GeneratedValue
    @Column(name = "DOCTOR_ID")
    private Long doctorId;
    @Column(name = "DOCTOR_NAME")
    private String doctorName;
    @Column(name = "INFO")
    private String info;
    @OneToMany(targetEntity=Patient.class, mappedBy="doctor", fetch= FetchType.EAGER)
    @Column(name = "PATIENTS")
    private List<Patient> patients;

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
}
