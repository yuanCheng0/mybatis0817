package com.cy.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.cy.pojo.User;

public class UserDaoImpl implements UserDao {
	private SqlSessionFactory sqlSessionFactory;

	//通过构造方法注入
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public User findUserById(Integer id) {
		//sqlSession是线程不安全的，所以它的最佳使用范围在方法体内
		SqlSession openSession = sqlSessionFactory.openSession();
		User user = openSession.selectOne("test.findUserById",id);
		return user;
	}

	@Override
	public List<User> findUserByUserName(String username) {
		SqlSession openSession = sqlSessionFactory.openSession();
		List<User> list = openSession.selectList("test.findUserName", username);
		return list;
	}
	
	
}
