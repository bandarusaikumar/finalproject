package com.care.aged.AgedCareArt.jpa;

import com.care.aged.AgedCareArt.entity.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface NurseRepository extends JpaRepository<Nurse, Long> {
}
