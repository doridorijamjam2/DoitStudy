package com.spring.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.study.mapper.AccountMapper;
import com.spring.study.vo.Account;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountMapper accountMapper;
	
	@Override
	public void join(Account account) {
		accountMapper.insertAccount(account);
	}
	
}
