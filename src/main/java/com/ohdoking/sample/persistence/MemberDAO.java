package com.ohdoking.sample.persistence;

import com.ohdoking.sample.domain.MemberVO;

public interface MemberDAO {
	public String readTime() throws Exception;

	public void createMember(MemberVO vo) throws Exception;
	
	public MemberVO readMember(String userid) throws Exception;
	
	public MemberVO readWithPW(String userid, String userpw) throws Exception;
	
	
}
