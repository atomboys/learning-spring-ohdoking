package com.ohdoking.sample.persistence;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ohdoking.sample.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace= "org.ohdoking.sample.mapper.MemberMapper";
	@Override
	public String readTime() throws Exception {
		Object result = sqlSession.selectOne(namespace+".getTime");
		return (String) result;
	}

	@Override
	public void createMember(MemberVO vo) throws Exception {
		sqlSession.insert(namespace+".create", vo);
	}

	@Override
	public MemberVO readMember(String userid) throws Exception {
		
		return sqlSession.selectOne(namespace+".read",userid);
	}

	@Override
	public MemberVO readWithPW(String userid, String userpw) throws Exception {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userid", userid);
		paramMap.put("userpw", userpw);
		return sqlSession.selectOne(namespace+".read",paramMap);
	}

}
