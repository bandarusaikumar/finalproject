package com.care.aged.AgedCareArt.service;

import com.care.aged.AgedCareArt.entity.Account;
import com.care.aged.AgedCareArt.exception.NotFoundException;

import java.util.List;

public interface IAccountService {

	Account addAccount(Account accountd);

	Account findAccount(long id) throws NotFoundException;

	List<Account> findAllAccounts();

	void deleteAccount(long id) throws NotFoundException;

	List<Account> searchAccounts(Account accountdtDto) throws NotFoundException;
	
	Account findAccountByUsername(String username) throws NotFoundException;
}
