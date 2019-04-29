package com.care.aged.AgedCareArt.service;

import com.care.aged.AgedCareArt.entity.Doctor;
import com.care.aged.AgedCareArt.jpa.DoctorRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService implements GenericService<Doctor, Long> {

    private final DoctorRepository doctorRepository;

    public DoctorService(final DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public Long getId(Doctor entity) {
        return entity.getDoctorId();
    }

    @Override
    public CrudRepository<Doctor, Long> getRepository() {
        return this.doctorRepository;
    }

    public Doctor search(String name) {
        return doctorRepository.findByName(name);
    }



    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }
}
