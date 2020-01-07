package com.mphasis.account.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.mphasis.account.model.AccountModel;
import com.mphasis.account.repository.AccountRepository;


@RunWith(SpringRunner.class)
public class TestAccountService {

	@InjectMocks
	AccountService accountService;

	@Mock
	AccountRepository accountRepository;


	@Test
	public void testfindall() {
		AccountModel accountModel= new AccountModel();
		accountModel.setAcc("134");
		accountModel.setName("vinod");
		accountModel.setBranch("hyde");

		List<AccountModel> account= new ArrayList<>();
		account.add(accountModel);

		Mockito.when(accountService.findAll()).thenReturn(account);

		assertEquals(account, accountService.findAll());
		//System.out.println(Version.id());
	}

	@Test
	public void testinsert(){

		AccountModel accountModel= new AccountModel();
		accountModel.setAcc("134");
		accountModel.setName("vinod");
		accountModel.setBranch("hyde");

		Mockito.when(accountRepository.save(accountModel)).thenReturn( accountModel);
		assertEquals(accountModel,accountService.add(accountModel));

	}

	@Test
	public void testfindId() {

		AccountModel accountModel = new AccountModel();
		accountModel.setAcc("134");
		accountModel.setName("vinod"); 
		accountModel.setBranch("hyde");
		//Optional<AccountModel> account= Optional.of(accountModel);

		Optional<AccountModel> accountModelOptional = Optional.of(accountModel);

		Mockito.when(accountRepository.findById("134")).thenReturn(accountModelOptional);
		assertThat(accountService.findId("134")).isEqualTo(accountModelOptional);
	}

	@Test
	public void testUpdate(){
		AccountModel accountModel= new AccountModel();
		accountModel.setAcc("134");
		accountModel.setName("vinod");
		accountModel.setBranch("hyde");

		Optional<AccountModel> accountModelOptional = Optional.of(accountModel);

		Mockito.when(accountRepository.findById("134")).thenReturn(accountModelOptional);

		accountModel.setAcc("143");
		Mockito.when(accountRepository.save(accountModel)).thenReturn(accountModel);

		assertThat(accountService.update(accountModel, "143")).isEqualTo(accountModel);

	}

	
	@Test
	public void testDelete(){
		AccountModel accountModel= new AccountModel();
		accountModel.setAcc("134");
		accountModel.setName("vinod");
		accountModel.setBranch("hyde");
		Optional<AccountModel> accountModelOptional = Optional.of(accountModel);

		Mockito.when(accountRepository.findById("134")).thenReturn(accountModelOptional);
		Mockito.when(accountRepository.existsById(accountModel.getAcc())).thenReturn(false);
		assertFalse(accountRepository.existsById(accountModel.getAcc()));
	}


}

