package com.ryz.cn.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ryz.cn.service.MenuService;

@Controller
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
	private MenuService menuService ;
	
	@RequestMapping(value = "/loadMenuByUserId",method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> loadMenuByUserId(
			@RequestParam("userId") String userId,
			@RequestParam("parentId") String parentId){
		Map<String,Object> list = menuService.loadMenuByUserId(userId,parentId);
		return list;
	}
}
