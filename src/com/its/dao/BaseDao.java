/**
 * 
 */
package com.its.dao;

import java.io.Serializable;
import java.util.List;

import com.its.util.PageResults;

/**
 * @作者: KevinWu
 *
 * @日期:2015年12月16日 下午5:07:08
 *
 * @版本：Xinoman Technologies CO.,LTD.
 */
public interface BaseDao<T, ID extends Serializable> {
	
	public void save(T t);
	
	public T get(ID t);
	
	public void update(T t);
	
	public List<T> list();

	public void delete(ID id);	
	
	public int findCount();
	
	public PageResults<T> findPageResult(int pageNo, int pageSize);

}
