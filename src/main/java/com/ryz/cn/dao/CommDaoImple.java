package com.ryz.cn.dao;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ryz.cn.utils.TablesNamesFinder;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserManager;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.Select;

@Repository
public class CommDaoImple extends HibernateDaoSupport implements CommDao {

	  @Autowired
	  private SessionFactory sessionFactory;
	  
	public <T> void update(T obj) {
		
		 sessionFactory.getCurrentSession().update(obj);
	}

	public <T> void insert(T obj) {
		 sessionFactory.getCurrentSession().save(obj);
	}

	public <T> void delete(Class<T> clazz, Long id) {
		Object o = sessionFactory.getCurrentSession().load(clazz, id);
		sessionFactory.getCurrentSession().delete(o);
	}

	public <T> T find(Class<T> obj, Long id) {
		String sql = "from "+obj.getName()+" where id = ? ";
		@SuppressWarnings({ "deprecation", "unchecked" })
		List<T> list = sessionFactory.getCurrentSession().find(sql, id, Hibernate.LONG);
		if(list.size() == 0){
			return null;
		}else{
			return list.get(0);
		}
	}

	public List<Map<String,Object>> selectSql (String sql,String[] params){
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);  
        for(int i=0;i<params.length;i++){
        	query.setString(i, params[i]);
        }
        List<?> results = query.list();  
        String[] arr = getColumn(sql);
        Map<String,Object> map = null;
        List<Map<String,Object>> mapList = new ArrayList<Map<String,Object>>();
        for(int i=0;i<results.size();i++){
			Object[] row = (Object[])results.get(i);
			map = new HashMap<String,Object>();
			for(int j=0;j<arr.length;j++){
				map.put(arr[j], row[j]);
			}
			mapList.add(map);
		}
        
        return mapList;
	}
	
	public static String[] getColumn(String sql){
		String str1 = sql.substring(sql.indexOf("select")+7,sql.indexOf("from"));
		while(str1.indexOf(", ")!=-1||str1.indexOf(" ,")!=-1){
			str1 = str1.replace(", ", ",").replace(" ,", ",");
		}
		String[] arr = str1.split(",");
		int index;
		for(int i = 0;i<arr.length;i++){
			index = arr[i].indexOf(" ");
			if(index !=-1){
				arr[i] = arr[i].substring(arr[i].indexOf(".")+1);
				arr[i] = arr[i].substring(index).replace(" ", "");
			}
		}
		return arr;
	}
}
