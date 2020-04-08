package com.ssm;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ssm.dao.UserDAO;
import com.ssm.entity.User;

public class TestJdbcTemplate {
	public static void main(String[] args) {
		//初始化spring容器，加载applicationContext.xml配置
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		//通过容器，获取JdbcTemplate的实例
		JdbcTemplate jdbcTemplate = (JdbcTemplate)ctx.getBean("jdbcTemplate");
		String sql = "create table user(id int primary key auto_increment, userName varchar(20),password varchar(32))";
		//使用execute()方法执行SQL语句，创建用户表user
		jdbcTemplate.execute(sql);
		System.out.println("用户表user创建成功！");
	}
	@Test
	public void addUserTest() {
		//初始化spring容器，加载applicationContext.xml配置
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		//通过Spring容器，获取UserDAO的实例
		UserDAO userDAO = (UserDAO)ctx.getBean("userDAO");
		//创建User对象，并向User对象中添加数据
		User user=new User();
		user.setUserName("yzpc");
		user.setPassword("yzpc");
		//执行addUser（）方法，并获取返回结果
		int result=userDAO.addUser(user);
		if (result>0) {
			System.out.println("成功往数据表中插入了"+result+"条数据！ ");
		} else {
			System.out.println("往数据表中插入数据失败！");
		}
	}
	@Test
	public void updateUserTest() {
		//初始化spring容器，加载applicationContext.xml配置
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		//通过容器，获取UserDAO的实例
		UserDAO userDAO = (UserDAO)ctx.getBean("userDAO");
		//创建User对象，并向User对象中添加数据
		User user=new User();
		user.setId(1);
		user.setUserName("yzpc");
		user.setPassword("123");
		//执行updateUser()方法，并获取结果
		int result=userDAO.updateUser(user);
		if (result>0) {
			System.out.println("成功修改了"+result+"条数据");
		} else {
			System.out.println("修改操作执行失败！");
		}
	}
	@Test
	public void deleteUserTest() {
		//初始化spring容器，加载applicationContext.xml配置
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		//通过容器，获取UserDAO的实例
		UserDAO userDAO = (UserDAO)ctx.getBean("userDAO");
		//执行deleteUser()方法，并获取返回结果
		int result =userDAO.deleteUser(1);
		if (result>0) {
			System.out.println("成功删除了"+result+"条数据！");
		} else {
			System.out.println("删除操作执行失败！");
		}
	}
	@Test
	public void findUserByIdTest() {
		//初始化spring容器，加载applicationContext.xml配置
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		//通过容器，获取UserDAO的实例
		UserDAO userDAO = (UserDAO)ctx.getBean("userDAO");
		//执行findUserById()方法，获取User对象
		User user=userDAO.findUserById(1);
		System.out.println(user);
	}
	@Test
	public void findAllUserTest() {
		//初始化spring容器，加载applicationContext.xml配置
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		//通过容器，获取UserDAO的实例
		UserDAO userDAO = (UserDAO)ctx.getBean("userDAO");
		//执行findAllUser()方法，获取User对象的集合
		List<User> users = userDAO.findAllUsers();
		//循环输出集合中对象
		for (User user: users) {
			System.out.println(user);
		}
	}
}
