/**
 * 
 */
package com.its.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.its.dao.BaseDao;
import com.its.util.PageResults;

/**
 * @作者: KevinWu
 *
 * @日期:2015年12月16日 下午5:20:28
 *
 * @版本：Xinoman Technologies CO.,LTD.
 */
public class BaseDaoImpl<T, ID extends Serializable> extends SqlSessionDaoSupport implements BaseDao<T, ID> {
	private static final Log log = LogFactory.getLog(BaseDaoImpl.class);
	
	public static final String SQL_INSERT = "insert";  
	public static final String SQL_UPDATE = "update";  
	public static final String SQL_GETBYID = "getById";
	public static final String SQL_COUNT = "count";
	public static final String SQL_DELETEBYID = "deleteById";
	public static final String SQL_DELETEBYIDS = "deleteByIds";
	public static final String SQL_FINDPAGEBY = "findPageBy";  
	public static final String SQL_FINDLISTBY = "findListBy";
	public static final String SQL_GETCOUNTBY = "getCountBy"; 
	public static final String SQL_FIND_RESULT_FOR_PAGE = "findResultForPage";
	
	protected Class<T> entityClass;
	
	@SuppressWarnings("unchecked")
	public Class<T> getEntityClass() {        
        if (entityClass==null) {  
        	entityClass=(Class<T>)(((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);  
        } 
        log.info("DAO的真实实现类是：" + this.entityClass.getName()); 
        return entityClass;
    }

	@Override
	public void save(T t) {
		this.getSqlSession().insert(SQL_INSERT, t);
	}
	
	@Override
	public T get(ID id) {
		return getSqlSession().selectOne(SQL_GETBYID, id);
	}	

	@Override
	public void update(T t) {
		getSqlSession().update(SQL_UPDATE, t);
	}	

	@Override
	public List<T> list() {
		return getSqlSession().selectList(SQL_FINDLISTBY);
	} 
	
	@Override
	public void delete(ID id) {
		getSqlSession().delete(SQL_DELETEBYID, id);
	}

	@Override
	public PageResults<T> findPageResult(int pageNo, int pageSize) {
		 PageResults<T> pageResults = new PageResults<T>();		 
		 int currentPage = pageNo > 1 ? pageNo : 1;
         pageResults.setCurrentPage(currentPage);
         pageResults.setPageSize(pageSize);
         log.info("count = "+findCount());
         pageResults.setTotalCount(findCount());
         pageResults.resetPageNo();
         
         Map<String, Object> params = new HashMap<String, Object>();
         if (currentPage != -1 && pageSize != -1) {
 			params.put("currentPage", ((currentPage - 1) * pageSize) + 1);
 			params.put("maxResult", (currentPage * pageSize));
 		} 
 		List<T> results = this.getSqlSession().selectList(SQL_FIND_RESULT_FOR_PAGE, params);
 		pageResults.setResults(results);
         
		return pageResults;
	}

	@Override
	public int findCount() {
		Integer count = this.getSqlSession().selectOne(SQL_COUNT);
		if(count == 0) {
			return 0;
		}
		return count.intValue();
	}

}
