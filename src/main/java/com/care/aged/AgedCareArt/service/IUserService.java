package com.care.aged.AgedCareArt.service;

import com.care.aged.AgedCareArt.entity.User;
import com.care.aged.AgedCareArt.exception.NotFoundException;
import com.care.aged.AgedCareArt.exception.ServiceException;

import java.util.List;

public interface IUserService {
	
	User addUser(User user, boolean b) throws ServiceException;

	User findUser(long id) throws NotFoundException;

	List<User> findAllUsers();

	void deleteUser(long id) throws NotFoundException;

	List<User> searchUsers(User userDto) throws NotFoundException;

	User updateUser(User user) throws NotFoundException;
	
	User findUserByUsername(String username) throws NotFoundException;

	List<User> getAdminUser();

	User getByEmail(String email);
}
