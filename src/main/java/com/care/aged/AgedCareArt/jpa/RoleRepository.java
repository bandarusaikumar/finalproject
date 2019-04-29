package com.care.aged.AgedCareArt.jpa;

import com.care.aged.AgedCareArt.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByRoleCode(String roleCode);
}
