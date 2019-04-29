package com.care.aged.AgedCareArt.jpa;

import com.care.aged.AgedCareArt.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface AdminRepository extends JpaRepository<Admin, Long> {
}
