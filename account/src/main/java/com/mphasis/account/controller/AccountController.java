package com.mphasis.account.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.account.model.AccountModel;
import com.mphasis.account.service.AccountService;

@RestController
@RequestMapping("/account/")

public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping("/findall")
	public List<AccountModel> findall()
	{
		return accountService.findAll();
		
	}
	
	@PostMapping("/insert")
	public void insert(@RequestBody AccountModel accountModel)
	{
          accountService.add(accountModel);
	}

	@PutMapping("/update/{acc}")
	public void update(@RequestBody AccountModel accountModel,@PathVariable String acc)
	{
      accountService.update(accountModel,acc);
	}

	@DeleteMapping("/delete/{acc}")
	public void delete(@PathVariable AccountModel acc)
	{
      accountService.delete(acc);
	}
	
	@GetMapping("/findById/{acc}")
	public Optional<AccountModel> findId(@PathVariable String acc)
	{
		return accountService.findId(acc);
		
	}
	
}
