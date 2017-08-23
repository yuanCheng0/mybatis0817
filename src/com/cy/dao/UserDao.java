package com.cy.dao;

import java.util.List;

import com.cy.pojo.User;

public interface UserDao {
	public User findUserById(Integer id);
	
	public List<User> findUserByUserName(String username);
	
}
