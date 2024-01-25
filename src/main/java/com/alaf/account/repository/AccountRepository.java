package com.alaf.account.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.alaf.account.model.Account;

@Repository

public interface AccountRepository extends CrudRepository<Account, Long> { 
	
	@Query(nativeQuery = true,
		value = "select * from m_konto t where t.name like CONCAT('%', :name, '%')") 
	List<Account> findByName(@Param("name") String name); 
}

