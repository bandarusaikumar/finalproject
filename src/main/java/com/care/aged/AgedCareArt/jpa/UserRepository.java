package com.care.aged.AgedCareArt.jpa;

import com.care.aged.AgedCareArt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByAccountId(Long accountID);
	User findByAccountUsername(String username);


	List<User> findByRoleRoleCode(String roleCodeAdmin);

	User findByEmail(String email);
}	
