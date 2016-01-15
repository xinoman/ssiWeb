/**
 * 
 */
package com.its.api.bean;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.its.entity.User;

/**
 * @author KevinWu
 *
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class UserResult extends BaseResult {
	
	private List<User> users;

	/**
	 * @param users
	 */
	public UserResult() {
		users = new ArrayList<User>();;
	}

	/**
	 * @return the users
	 */
	public List<User> getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	

}
