package com.care.aged.AgedCareArt.jpa;

import com.care.aged.AgedCareArt.entity.HealthRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface HealthRecordRepository extends JpaRepository<HealthRecord, Long> {
}
