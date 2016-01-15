package com.its.service;

import java.util.List;

import com.its.entity.User;
import com.its.util.PageResults;

/**
 * 类说明：
 * 
 * @author 作者: KevinWu
 * @version 创建时间：2015-12-25 下午02:31:11
 */
public interface IUserService {

	// 添加用户
	public abstract void addUser(User user);

	public abstract void updateUser(User user);
	
	public abstract void deleteUser(String userId);

	public abstract User findUserById(String userId);

	public abstract List<User> findAllUser();
	
	public PageResults<User> getUserPageList(int pageNo, int pageSize);

	public abstract User login(User user);

}