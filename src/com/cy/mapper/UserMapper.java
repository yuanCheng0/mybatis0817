package com.cy.mapper;

import java.util.List;

import com.cy.pojo.CustomOrders;
import com.cy.pojo.Orders;
import com.cy.pojo.QueryVo;
import com.cy.pojo.User;

public interface UserMapper {
	public User findUserById(Integer id);
	//动态代理形式中，如果返回结果集为list，那么mybatis会在生成实现类的时候会自动调用selectList方法
	public List<User> findUserName(String username);
	public void insertUser(User user);
	public List<User> findUserByVo(QueryVo vo);
	public Integer findUserCount();
	public List<User> findUserByUserNameandSex(User user);
	public List<User> findUserByIds(QueryVo vo);
	public List<CustomOrders> findOrdersAndUser1();
	public List<Orders> findOrdersAndUser2();
	public List<User> findUserAndOrders();
}
