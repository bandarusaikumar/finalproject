package com.care.aged.AgedCareArt.jpa;

import com.care.aged.AgedCareArt.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query(value = "select * from patient a where a.PATIENT_NAME =:name", nativeQuery = true)
    Patient findByName(@Param("name") String name);
}
