package com.care.aged.AgedCareArt.service;

import com.care.aged.AgedCareArt.entity.Admin;
import com.care.aged.AgedCareArt.jpa.AdminRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService implements GenericService<Admin, Long> {

    private final AdminRepository adminRepository;

    public AdminService(final AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public Long getId(Admin entity) {
        return entity.getAdminId();
    }

    @Override
    public CrudRepository<Admin, Long> getRepository() {
        return this.adminRepository;
    }
}
