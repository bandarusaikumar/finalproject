package com.care.aged.AgedCareArt.converters;

import com.care.aged.AgedCareArt.entity.Doctor;
import com.care.aged.AgedCareArt.protocol.doctor.DoctorResponse;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DoctorToDoctorResponse implements Converter<Doctor, DoctorResponse> {

    @Override
    public DoctorResponse convert(Doctor doctor) {
        DoctorResponse response = new DoctorResponse();
        response.setName(doctor.getDoctorName());
        response.setPatients(doctor.getPatients());
        return response;
    }
}
