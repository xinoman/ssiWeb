/**
 * 
 */
package com.its.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;

/**
 * @author KevinWu
 *
 */
public class RestfulStrutsPrepareAndExecuteFilter extends StrutsPrepareAndExecuteFilter {
	
	private static final Log log = LogFactory.getLog(RestfulStrutsPrepareAndExecuteFilter.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
		String path = req.getRequestURI();
		if (path.contains("/rest/")) {
			log.debug("跳过struts");
			chain.doFilter(request, response);
		} else {
			log.debug("进入struts");
			super.doFilter(request, response, chain);
		}
	}	

}
