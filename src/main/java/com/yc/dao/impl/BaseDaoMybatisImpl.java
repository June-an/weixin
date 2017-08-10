package com.yc.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.yc.dao.BaseDao;

/**
 * sqlId:全是调用的各个mapper文件中的 方法名
 * 
 * @param <T>
 */
@Repository(value = "baseDao")
public class BaseDaoMybatisImpl<T> extends SqlSessionDaoSupport implements BaseDao<T> {

	private final String MAPPERPATH = "com.yc.bean.";

	// 重写了父类 SqlSessionDaoSupport 方法实现注入 sqlSessionTemplate
	// 为什么要重写? 如果不重写的话，则需要 xml配置spring
	@Resource(name = "sqlSession")
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}

	public void save(T t, String sqlId) {
		super.getSqlSession().insert(MAPPERPATH + t.getClass().getSimpleName() + "Mapper." + sqlId, t);
	}

	public void save(Class<T> clazz, String sqlId, Map<String, Object> parameterMap) {
		super.getSqlSession().insert(MAPPERPATH + clazz.getSimpleName() + "Mapper." + sqlId, parameterMap);
	}
	
	public void save(Class<T> clazz, String sqlId, List<T> list) {
		super.getSqlSession().insert(MAPPERPATH + clazz.getSimpleName() + "Mapper." + sqlId, list);
	}

	public void update(Class<T> clazz, String sqlId) {
		super.getSqlSession().update(MAPPERPATH + clazz.getSimpleName() + "Mapper." + sqlId);
	}
	
	public void update(T t, String sqlId) {
		super.getSqlSession().update(MAPPERPATH + t.getClass().getSimpleName() + "Mapper." + sqlId, t);
	}

	public void update(Class<T> clazz, String sqlId, Map<String, Object> parameterMap) {
		super.getSqlSession().update(MAPPERPATH + clazz.getSimpleName() + "Mapper." + sqlId, parameterMap);
	}
	
	public void update(Class<T> clazz, String sqlId, List<T> list) {
		super.getSqlSession().update(MAPPERPATH + clazz.getSimpleName() + "Mapper." + sqlId, list);
	}

	public void del(Class<T> clazz, String sqlId, String id) {
		super.getSqlSession().delete(MAPPERPATH + clazz.getSimpleName() + "Mapper." + sqlId,id);
	}
	public void del(T t, String sqlId) {
		super.getSqlSession().delete(MAPPERPATH + t.getClass().getSimpleName() + "Mapper." + sqlId,t);
	}

	public void del(Class<T> clazz, String sqlId, Map<String, Object> parameterMap) {
		super.getSqlSession().delete(MAPPERPATH + clazz.getSimpleName() + "Mapper." + sqlId, parameterMap);
	}

	public void del(Class<T> clazz, String sqlId, List<Object> ids) {
		super.getSqlSession().delete(MAPPERPATH + clazz.getSimpleName() + "Mapper." + sqlId, ids);
	}

	public List<T> findAll(Class<T> clazz, String sqlId) {
		return super.getSqlSession().selectList(  MAPPERPATH + clazz.getSimpleName() + "Mapper." + sqlId );
	}

	public List<T> findAll(T t, String sqlId) {
		return super.getSqlSession().selectList(  MAPPERPATH + t.getClass().getSimpleName() + "Mapper." + sqlId ,t);
	}

	public List<T> findAll(Class<T> clazz, String sqlId, Map<String, Object> parameterMap) {
		return super.getSqlSession().selectList(  MAPPERPATH + clazz.getSimpleName() + "Mapper." + sqlId ,parameterMap);
	} 

	public double getFunc(Class<T> clazz, String sqlId) {
		return super.getSqlSession().selectOne(MAPPERPATH+clazz.getSimpleName()+ "Mapper." + sqlId );
	}

	public double getFunc(T t, String sqlId) {
		return super.getSqlSession().selectOne(MAPPERPATH+t.getClass().getSimpleName()+ "Mapper." + sqlId ,t);
	}

	public double getFunc(Class<T>clazz, String sqlId, Map<String, Object> parameterMap) {
		return new Double(super.getSqlSession().selectOne(MAPPERPATH+clazz.getSimpleName()+ "Mapper." + sqlId ,parameterMap).toString());
	}
	
	


}