package com.care.aged.AgedCareArt.converters;

import com.care.aged.AgedCareArt.entity.Doctor;
import com.care.aged.AgedCareArt.protocol.doctor.DoctorRequest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DoctorRequestToDoctor implements Converter<DoctorRequest, Doctor> {

    @Override
    public Doctor convert(DoctorRequest request) {
        Doctor doctor = new Doctor();
        doctor.setDoctorName(request.getName());
        doctor.setInfo(request.getInfo());
        return doctor;
    }
}
