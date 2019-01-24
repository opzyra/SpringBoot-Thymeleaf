package com.app.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;

import com.app.config.Slave;
import com.app.security.Account;

@Mapper
public interface AccountMapper {
	
	@Slave
	public Account selectByEmail(String email) throws DataAccessException;
	
}
