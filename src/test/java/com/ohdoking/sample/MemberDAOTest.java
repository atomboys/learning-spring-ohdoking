package com.ohdoking.sample;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ohdoking.sample.domain.MemberVO;
import com.ohdoking.sample.persistence.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MemberDAOTest {

	@Inject
	private MemberDAO dao;
	
	@Test
	public void testTime() throws Exception{
		System.out.println(dao.readTime());
	}
	
	@Test
	public void testCreate() throws Exception{
		MemberVO vo = new MemberVO();
		
//		vo.setUserid("ohdoking2");
		vo.setEmail("ohdoking@naver.com");
		vo.setUsername("kenny");
		vo.setUserpw("1234");
		dao.createMember(vo);
	}
	
	@Test
	public void testRead() throws Exception{
		System.out.println(dao.readMember("ohdoking").getEmail());	
	}
	
	@Test
	public void testReadWithPW() throws Exception{
		System.out.println(dao.readWithPW("ohdoking", "1234"));
	}
}
