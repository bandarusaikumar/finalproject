package com.care.aged.AgedCareArt.converters;

import com.care.aged.AgedCareArt.entity.Patient;
import com.care.aged.AgedCareArt.protocol.patient.PatientResponse;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PatientToPatientResponse implements Converter<Patient, PatientResponse> {

    @Override
    public PatientResponse convert(Patient patient) {
        PatientResponse response = new PatientResponse();
        response.setName(patient.getPatientName());
        response.setId(patient.getPatientId());
        return response;
    }
}
