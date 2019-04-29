package com.care.aged.AgedCareArt.protocol.admin;

public class LinkDoctorPatientRequest {

    private String doctorName;
    private String patientName;

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
}
