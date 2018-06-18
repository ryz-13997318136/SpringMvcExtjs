package com.ryz.cn.dao;

import java.util.List;
import java.util.Map;

public interface CommDao {
	<T> void update(T obj);
	
	<T> void insert(T obj);
	
	<T> void delete(Class<T> clazz,Long id);
	
	<T> T find(Class<T> clazz ,Long id);
	
	List<Map<String,Object>> selectSql (String sql,String[] params);
}
