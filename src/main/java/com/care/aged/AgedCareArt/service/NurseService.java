package com.care.aged.AgedCareArt.service;

import com.care.aged.AgedCareArt.entity.Nurse;
import com.care.aged.AgedCareArt.jpa.NurseRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class NurseService implements GenericService<Nurse, Long> {

    private final NurseRepository nurseRepository;

    public NurseService(final NurseRepository nurseRepository) {
        this.nurseRepository = nurseRepository;
    }

    @Override
    public Long getId(Nurse entity) {
        return entity.getNurseId();
    }

    @Override
    public CrudRepository<Nurse, Long> getRepository() {
        return this.nurseRepository;
    }
}
