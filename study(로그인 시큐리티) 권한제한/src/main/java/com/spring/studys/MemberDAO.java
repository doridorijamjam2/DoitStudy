package com.spring.studys;

import java.util.ArrayList;

public interface MemberDAO {
	public UserDetailsVO selectUser(String username);
	public ArrayList<String> getAuthList(String username);
}