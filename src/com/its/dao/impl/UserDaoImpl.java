package com.its.dao.impl;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.its.dao.IUserDao;
import com.its.entity.User;

/**
 * 
 * @作者: KevinWu
 *
 * @日期:2015年12月15日 下午4:58:57
 *
 * @版本：Xinoman Technologies CO.,LTD.
 * 
 * @说明：用户dao实现类
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<User, Serializable> implements IUserDao {
	
	private static final Log log = LogFactory.getLog(UserDaoImpl.class);
	
	private static final String USER_LOGIN = "userLogin";
	
	@Override
	public User userLogin(User user) {		
		log.info(user.getUsername()+" - "+user.getPassword());
		User entity = this.getSqlSession().selectOne(USER_LOGIN, user);
		entity.setLastLoginTime(new Date());
		log.info(user.getUsername()+"登录时间为："+entity.getLastLoginTime()+" - "+user.getId() + " - "+entity.getUsername());
		this.update(entity);
		return this.getSqlSession().selectOne(USER_LOGIN, user);
	}
	
}
