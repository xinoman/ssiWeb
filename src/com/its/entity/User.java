package com.its.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 类说明：用户表
 * 
 * @author 作者: KevinWu
 * @version 创建时间：2015-12-25 下午12:38:24
 */
public class User implements Serializable {
	
	private static final long serialVersionUID = -4415990281535582814L;
	
	private String id;
	private String username;
	private String password;
	private Integer age;
	private Date lastLoginTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	
}
