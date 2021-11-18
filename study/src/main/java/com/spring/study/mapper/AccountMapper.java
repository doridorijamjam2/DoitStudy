package com.spring.study.mapper;


import org.apache.ibatis.annotations.Mapper;

import com.spring.study.vo.Account;

@Mapper
public interface AccountMapper {
	Account getAccountById(String id);
	void insertAccount(Account account);
}
