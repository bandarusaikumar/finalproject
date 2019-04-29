package com.care.aged.AgedCareArt.service;

import com.care.aged.AgedCareArt.entity.Account;
import com.care.aged.AgedCareArt.exception.BadCredentialsException;
import com.care.aged.AgedCareArt.exception.NotFoundException;

public interface IAuthenticationService {

	Account authenticate(Account account) throws NotFoundException, BadCredentialsException;
}
