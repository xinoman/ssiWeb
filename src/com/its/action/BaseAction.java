/**
 * 
 */
package com.its.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @作者: KevinWu
 *
 * @日期:2015年12月16日 下午5:00:01
 *
 * @版本：Xinoman Technologies CO.,LTD.
 */
public class BaseAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4433247553717009362L;
	
	private int pageNo = 1; //第几页 
	private int pageSize = 5; //每页显示数量

	/**
	 * @return the pageNo
	 */
	public int getPageNo() {
		return pageNo;
	}

	/**
	 * @param pageNo the pageNo to set
	 */
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}	
	
}
