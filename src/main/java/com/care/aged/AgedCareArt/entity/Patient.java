package com.care.aged.AgedCareArt.entity;

import javax.persistence.*;

@Entity
public class Patient {

    @Id
    @GeneratedValue
    @Column(name = "PATIENT_ID")
    private Long patientId;
    @Column(name = "PATIENT_NAME")
    private String patientName;
    @Column(name = "PATIENT_PASSWORD")
    private String patientPassword;
    @Column(name = "PATIENT_ADDRESS")
    private String patientaddress;
    @Column(name = "PATIENT_EMAIL")
    private String patientemail;
    @Column(name = "PATIENT_AGE")
    private String patientage;
    @Column(name = "PATIENT_DISEASE")
    private String patientdisease;
    @Column(name = "PATIENT_CONTACTNUMBER")
    private String patientContactnumber;
    @ManyToOne
    private Doctor doctor;
    @ManyToOne
    private Nurse nurse;
    @OneToOne
    private HealthRecord healthRecord;

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientPassword() {
        return patientPassword;
    }

    public void setPatientPassword(String patientPassword) {
        this.patientPassword = patientPassword;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Nurse getNurse() {
        return nurse;
    }

    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
    }

    public HealthRecord getHealthRecord() {
        return healthRecord;
    }

    public void setHealthRecord(HealthRecord healthRecord) {
        this.healthRecord = healthRecord;
    }
}
