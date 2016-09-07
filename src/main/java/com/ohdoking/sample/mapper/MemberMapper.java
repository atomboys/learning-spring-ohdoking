package com.ohdoking.sample.mapper;

import com.ohdoking.sample.domain.MemberVO;


/*
 * Mapper 인터페이스를 활용하는 방식은 다음과 같은 장점을 가짐
 * 
 * 1. 별도의 DAO 생성 없이 사용가능
 * 2. XML로 작성된 SQL문을 그대로 활용할수 있다는 점
 * 3. 경우에 따라서는 어노테이션만으로 SQL문을 처리할수 있다는 점
 * 
 * 하지만 다음 상황은 고려해야함
 * 
 * 1. 기존의 DAO를 이용하던 코딩 방식과 차이가 크기때문에 프로젝트 내에서 개발방식의 충돌이 일어날수잇음
 * 2. DAO 내부에 많은 로직이 존재하고, 이를 처리하기 위한 코드가 많은 경우 
 */
public interface MemberMapper {

	public String readTime() throws Exception;

	public void createMember(MemberVO vo) throws Exception;
	
	public MemberVO readMember(String userid) throws Exception;
	
	public MemberVO readWithPW(String userid, String userpw) throws Exception;
}
