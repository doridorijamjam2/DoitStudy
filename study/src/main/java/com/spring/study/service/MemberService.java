package com.spring.study.service;

import com.spring.study.vo.MemberVO;

public interface MemberService {

	public void register(MemberVO vo) throws Exception;
	
	
	public void memberUpdate(MemberVO vo) throws Exception;
	
	public void memberDelete(MemberVO vo) throws Exception;
	
	public int passChk(MemberVO vo) throws Exception;
	
	public int idChk(MemberVO vo) throws Exception;
}