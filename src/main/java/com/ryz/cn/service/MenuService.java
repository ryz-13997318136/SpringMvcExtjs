package com.ryz.cn.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ryz.cn.dao.CommDao;

@Service
public class MenuService {

	 @Autowired
	 private CommDao dao;
	 
	@Transactional
	public Map<String,Object> loadMenuByUserId(String userId,String parentId){
		String sql = "select id id,  index1 index1 ,text text, leaf leaf,url url, parentId parentId from ( "
				+ "select m.id  id,  m.index  index1 ,m.name text, "
				+ "case when m.parent_id = 0 then false else true end   leaf,m.url url ,m.parent_id  parentId "
				+ "from e_menu m join e_role_menu rm on rm.menu_id = m.id "
				+ "where rm.role_id in (select ur.role_id from e_user_role ur "
				+ "where ur.user_id = ?) and m.parent_id=?) a ";
		List<Map<String,Object>> list = dao.selectSql(sql, new String[]{userId,parentId});
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("menu", list);
		return map;
	}
}
