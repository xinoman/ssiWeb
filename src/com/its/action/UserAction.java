package com.its.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.its.entity.User;
import com.its.service.IUserService;
import com.its.util.CryptoUtil;
import com.its.util.PageResults;

/**
 * 
 * @作者: KevinWu
 *
 * @日期:2015年12月17日 下午4:51:56
 *
 * @版本：Xinoman Technologies CO.,LTD.
 * 
 * @说明：如果 Web 应用程序采用了经典的三层分层结构的话，最好在持久层、业务层和控制层分别采用上述注解对分层中的类进行注释。
 * @Service 用于标注业务层组件
 * @Controller 用于标注控制层组件（如struts中的action）
 * @Repository 用于标注数据访问组件，即DAO组件
 * @Component 泛指组件，当组件不好归类的时候，我们可以使用这个注解进行标注。
 */
@Controller
@Scope("prototype")
public class UserAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4215408481251313821L;
	
	private static final Log log = LogFactory.getLog(UserAction.class);
	
	@Autowired
	private IUserService userService;
	
	private User user;
	private PageResults<User> pageResults;	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}	

	/**
	 * @return the pageResults
	 */
	public PageResults<User> getPageResults() {
		return pageResults;
	}

	/**
	 * @param pageResults the pageResults to set
	 */
	public void setPageResults(PageResults<User> pageResults) {
		this.pageResults = pageResults;
	}

	public String addUI() {
		return "addUser";
	}
	
	public String add() throws Exception {
		//MD5加密
		String password = CryptoUtil.doDigest(user.getUsername()+user.getPassword());
		user.setPassword(password);
		userService.addUser(user);
		return SUCCESS;
	}

	public String updateUI() {
		user = userService.findUserById(user.getId());
		return "updateUser";
	}
	
	public String update() throws Exception {
		//MD5加密
		String password = CryptoUtil.doDigest(user.getUsername()+user.getPassword());
		user.setPassword(password);
		userService.updateUser(user);
		return SUCCESS;
	}

	public String delete() {
		userService.deleteUser(user.getId());
		return SUCCESS;
	}
	

	public String queryAllUser() {
		pageResults = userService.getUserPageList(this.getPageNo(), this.getPageSize());
		for(User entity:pageResults.getResults()) {
			log.info(entity.getLastLoginTime());
		}
		return "userList";
	}
	
	public String execute() throws Exception {
		return null;
	}

}
