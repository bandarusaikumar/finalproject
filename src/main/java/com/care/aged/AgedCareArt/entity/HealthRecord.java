package com.care.aged.AgedCareArt.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class HealthRecord {

    @Id
    @GeneratedValue
    private Long healthId;
    private String healthInfo;
    private String healthSummary;
    private String claims;
    private String medicare;
    private Integer age;
    private Integer emergencyContact;
    @JsonIgnore
    @OneToOne(targetEntity=Patient.class, mappedBy="healthRecord", fetch= FetchType.EAGER)
    private Patient patient;

    public Long getHealthId() {
        return healthId;
    }

    public void setHealthId(Long healthId) {
        this.healthId = healthId;
    }

    public String getHealthInfo() {
        return healthInfo;
    }

    public void setHealthInfo(String healthInfo) {
        this.healthInfo = healthInfo;
    }

    public String getHealthSummary() {
        return healthSummary;
    }

    public void setHealthSummary(String healthSummary) {
        this.healthSummary = healthSummary;
    }

    public String getClaims() {
        return claims;
    }

    public void setClaims(String claims) {
        this.claims = claims;
    }

    public String getMedicare() {
        return medicare;
    }

    public void setMedicare(String medicare) {
        this.medicare = medicare;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(Integer emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

}
