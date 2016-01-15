package com.its.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.its.entity.User;
import com.its.service.IUserService;

/**
 * 类说明：
 * 
 * @author 作者: KevinWu
 * @version 创建时间：2012-3-25 下午02:32:50
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/applicationContext.xml")
public class UserServiceImplTest {
	@Autowired
	private IUserService iUserService;

	@Test
	public void testAddUser() {
		User user = new User();
		user.setUsername("admin");
		user.setPassword("1234");
		iUserService.addUser(user);
	}

	@Test
	public void testUpdateUser() {
		User user = new User();
		user.setId("1");
		user.setUsername("admin");
		user.setPassword("1234456");
		iUserService.updateUser(user);
	}

	@Test
	public void testDeleteUser() {
		iUserService.deleteUser("1");
	}

	@Test
	public void testFindUserById() {
		User user = iUserService.findUserById("2");
		System.out.println(user);
	}

	@Test
	public void testFindAllUser() {
		List<User> users = iUserService.findAllUser();
		for (User user : users) {
			System.out.println(user);
		}
	}

	@Test
	public void testUserLogin() {
		User user = new User();
		user.setUsername("admin");
		user.setPassword("1234");
		System.out.println(iUserService.login(user));
	}
}
