package com.ryz.cn.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ryz.cn.dao.CommDao;
import com.ryz.cn.entity.Role;

@Service
public class RoleService {

	@Autowired
	 private CommDao dao;
	
	 @Transactional
	 public  Map<String,Object> loadAllRole(){
		 String sql = "select id ,name   from e_role ";
		 List<Map<String,Object>> list = dao.executeQuery(sql);
		 Map<String,Object> map = new HashMap<String,Object>();
		 map.put("roles", list);
		 return map;
	 }
	 
	 @Transactional
	 public void saveRole(Role role){
		 dao.insert(role);
	 }
	 @Transactional
	 public void updateRole(Role role){
		 dao.update(role);
	 }
	 @Transactional
	 public void deleteRole(long roleId){
		 dao.delete(Role.class, roleId);
	 }
}
