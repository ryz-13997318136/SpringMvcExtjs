package com.ryz.cn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ryz.cn.dao.CommDao;
import com.ryz.cn.entity.User;

@Service
public class UserService {
	 @Autowired
	 private CommDao dao;
	 
	 @Transactional
	 public void saveUser(User user){
	        dao.insert(user);
	        
	    }
	 
	 @Transactional
	 public User find(Long id){
	        return dao.find(User.class,id);
	        
	    }
	 
	 @Transactional
	 public void delete(Long id){
	        dao.delete(User.class,id);
	        
	    }
	 
	 @Transactional
	 public void update(User user){
	        dao.update(user);
	        
	    }
}
