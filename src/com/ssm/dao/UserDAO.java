package com.ssm.dao;

import java.util.List;

import com.ssm.entity.User;

public interface UserDAO {
	//添加用户
	public int addUser(User user);
	//修改用户
	public int updateUser(User user);
	//删除用户
	public int deleteUser(int id);
	//通过id查询
	public User findUserById(int id);
	//查询所有用户
	public List<User> findAllUsers();
}
