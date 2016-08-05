package com.ohdoking.sample;

import static org.junit.Assert.*;

import java.sql.Connection;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MybatisTest {
	
	
	@Inject
	private SqlSessionFactory factory;

	@Test
	public void testFactory(){
		System.out.println(factory);
	}
	
	
	@Test
	public void testSession() {
		try(SqlSession session = factory.openSession()){
			System.out.println(session);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
