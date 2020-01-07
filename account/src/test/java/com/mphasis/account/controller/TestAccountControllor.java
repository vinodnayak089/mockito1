package com.mphasis.account.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mphasis.account.model.AccountModel;
import com.mphasis.account.service.AccountService;

@WebMvcTest(AccountController.class)
@RunWith(SpringRunner.class)

public class TestAccountControllor {

    @Mock
	AccountService accountservice;

	@Autowired
	private MockMvc mvc;
	
     public TestAccountControllor()
     {
           MockitoAnnotations.initMocks(this);
     }

	@Test
	public void findall() throws Exception 
	{
		mvc.perform( MockMvcRequestBuilders
				.get("/aacount/findall")
				.accept(MediaType.APPLICATION_JSON))
		.andDo(MockMvcResultHandlers.print()) 
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.account").exists())
		.andExpect(MockMvcResultMatchers.jsonPath("$.account[*].acc").isNotEmpty());
	}

	@Test
	public void findById() throws Exception 
	{
		mvc.perform( MockMvcRequestBuilders
				.get("/account/findById/{id}", 1)
				.accept(MediaType.APPLICATION_JSON))
		.andDo(MockMvcResultHandlers.print())
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.acc").value(1));
	}

    @Test
	public void insert() throws Exception 
	{
		mvc.perform( MockMvcRequestBuilders
				.post("/account/insert")
				.content(asJsonString(new AccountModel( "1", "vinod", "hyd")))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isCreated())
		.andExpect(MockMvcResultMatchers.jsonPath("$.acc").exists());
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Test
	public void update() throws Exception 
	{
		mvc.perform( MockMvcRequestBuilders
				.put("/account/update/{id}", 2)
				.content(asJsonString(new AccountModel( "1", "vinod", "hyd")))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.acc").value("1"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("vinod"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.branch").value("hyd"));
	}


}
