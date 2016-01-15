/**
 * 
 */
package com.its.action;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;

import com.its.entity.User;
import com.its.service.IUserService;
import com.its.util.CryptoUtil;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author KevinWu
 *
 * 如果 Web 应用程序采用了经典的三层分层结构的话，最好在持久层、业务层和控制层分别采用上述注解对分层中的类进行注释。
 * @Service 用于标注业务层组件
 * @Controller 用于标注控制层组件（如struts中的action）
 * @Repository 用于标注数据访问组件，即DAO组件
 * @Component 泛指组件，当组件不好归类的时候，我们可以使用这个注解进行标注。
 */

@Controller
public class LoginAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2650322052323238909L;

	private static final Log log = LogFactory.getLog(LoginAction.class);
	
	private User user;	
	
	private String msg;
	
	@Resource
	private IUserService userService;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}	

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String execute() throws Exception {
		//MD5加密
		String password = CryptoUtil.doDigest(user.getUsername()+user.getPassword());
		user.setPassword(password);
		if(userService.login(user) != null) {
			msg = "登录成功,用户名="+user.getUsername();
			ActionContext actionContext = ActionContext.getContext();
			Map<String, Object> session=ActionContext.getContext().getSession();
			session.put("user.username", user.getUsername());
			if(actionContext != null && actionContext.getSession().containsKey(user.getUsername())){
				 msg = user.getUsername() + "：已经登录!";
			} else {
				actionContext.put(user.getUsername(), user.getUsername());
			}
			log.info(msg);
			return Action.SUCCESS;
		} else {
			msg = "登录失败,用户名="+user.getUsername();
			log.info(msg);
			
			//界面错误提示信息
			this.addFieldError("user.error", "用户名或密码错误!");
			return "fail";
		}
		
	}

}
