package com.care.aged.AgedCareArt.jpa;

import com.care.aged.AgedCareArt.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    @Query(value = "select * from DOCTOR a where a.DOCTOR_NAME =:name", nativeQuery = true)
    Doctor findByName(@Param("name") String name);
}
