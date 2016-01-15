package com.its.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.its.dao.IUserDao;
import com.its.entity.User;
import com.its.service.IUserService;
import com.its.util.PageResults;

/**
 * 
 * @作者: KevinWu
 *
 * @日期:2015年12月17日 上午9:19:42
 *
 * @版本：Xinoman Technologies CO.,LTD.
 * 
 * @说明：类用户Service实现
 */
@Service
@Transactional
public class UserServiceImpl implements IUserService {
	private static final Log log = LogFactory.getLog(UserServiceImpl.class);

	@Autowired
	private IUserDao userDao;

	// 添加用户
	@Override
	public void addUser(User user) {
		userDao.save(user);
	}

	// 更新用户
	@Override
	public void updateUser(User user) {
		userDao.update(user);
	}
	
	@Override
	public void deleteUser(String userId) {
		userDao.delete(userId);
	}

	@Override
	public User findUserById(String userId) {
		return userDao.get(userId);
	}

	@Override
	public List<User> findAllUser() {
		return userDao.list();
	}
	
	@Override
	public PageResults<User> getUserPageList(int pageNo, int pageSize) {
		return userDao.findPageResult(pageNo, pageSize);
	}

	@Override
	public User login(User user) {
		return userDao.userLogin(user);
	}
	
}
