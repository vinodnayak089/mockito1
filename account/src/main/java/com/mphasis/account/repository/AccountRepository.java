package com.mphasis.account.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mphasis.account.model.AccountModel;

@Repository
public interface AccountRepository extends CrudRepository<AccountModel, String>{

	
	
}
