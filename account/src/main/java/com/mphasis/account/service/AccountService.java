package com.mphasis.account.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.account.model.AccountModel;
import com.mphasis.account.repository.AccountRepository;
@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	public AccountRepository getAccountRepository() {
		return accountRepository;
	}

	public void setAccountRepository(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	public List<AccountModel> findAll() {
		return (List<AccountModel>) accountRepository.findAll();
	}

	public AccountModel add(AccountModel accountModel) {
		return accountRepository.save(accountModel);
		
	}

	public AccountModel update(AccountModel accountModel, String acc) {
		return accountRepository.save(accountModel);
	
	}

	public void delete(AccountModel acc) {

		accountRepository.delete(acc);
	}

	public Optional<AccountModel> findId(String acc) {
		return accountRepository.findById(acc);
	}

}
