/**
 * 
 */
package com.its.interceptor;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * @author KevinWu
 *
 */
public class CheckLoginInterceptor implements Interceptor {
	/**
	 * 
	 */
	private static final long serialVersionUID = -132702678329109898L;
	
	private static final Log log = LogFactory.getLog(CheckLoginInterceptor.class);

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.interceptor.Interceptor#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		log.info("CheckLogin.destroy()");

	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.interceptor.Interceptor#init()
	 */
	@Override
	public void init() {
		// TODO Auto-generated method stub
		log.info("CheckLogin.init()");

	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.interceptor.Interceptor#intercept(com.opensymphony.xwork2.ActionInvocation)
	 */
	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		log.info("CheckLogin.intercept()");
		Map<String, Object> session =  ActionContext.getContext().getSession();
		if(session.get("user.username") != null) {
			log.info(session.get("user.username")+"：用户已登录过！");
			return arg0.invoke();
		}
		return "checkLoginFail";
	}

}
