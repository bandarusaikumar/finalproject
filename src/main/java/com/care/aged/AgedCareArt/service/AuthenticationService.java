package com.care.aged.AgedCareArt.service;

import com.care.aged.AgedCareArt.entity.Account;
import com.care.aged.AgedCareArt.exception.BadCredentialsException;
import com.care.aged.AgedCareArt.exception.NotFoundException;
import com.care.aged.AgedCareArt.jpa.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements IAuthenticationService {

	@Autowired 
	private AccountRepository accountRepo;
	
	@Override
	public Account authenticate(Account credentials) throws NotFoundException, BadCredentialsException {
		Account account = accountRepo.findByUsername(credentials.getUsername());
		if(account == null || (account.getPassword() != null && !account.getPassword().equals(credentials.getPassword())))
			throw new BadCredentialsException("AUTHENTICATION.ERROR", "Bad credentials");
		return account;
	}

}
