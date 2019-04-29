package com.care.aged.AgedCareArt.service;

import com.care.aged.AgedCareArt.entity.Role;
import com.care.aged.AgedCareArt.entity.User;
import com.care.aged.AgedCareArt.exception.ServiceException;
import com.care.aged.AgedCareArt.jpa.RoleRepository;
import com.care.aged.AgedCareArt.jpa.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.care.aged.AgedCareArt.util.UtilContants.ROLE_CODE_ADMIN;
import static com.care.aged.AgedCareArt.util.UtilContants.ROLE_CODE_USER;

@Service
public class RoleService implements IRoleService {

	@Autowired
	private RoleRepository repo;

	@Autowired
	private UserRepository userRepository;

	@Override
	public Role findRoleByUsername(String username) throws ServiceException {
		User user = userRepository.findByAccountUsername(username);
		if (user == null)
			throw new ServiceException("INVALID.USERNAME", "Invalid username");

		return user.getRole();
	}

	@Override
	public Role findById(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public List<Role> findAll() {
		return repo.findAll();
	}

	@Override
	public Role getRoleUser() {
		return repo.findByRoleCode(ROLE_CODE_USER);
	}

	@Override
	public Role getRoleAdmin() {
		return repo.findByRoleCode(ROLE_CODE_ADMIN);
	}

	@Override
	public Role createRole(Role role) {
		if (repo.findByRoleCode(role.getRoleCode()) == null)
			return repo.save(role);
		return null;
	}

}
