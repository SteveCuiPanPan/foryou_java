package com.changyu.foryou.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.changyu.foryou.service.CampusService;

/**
 * 校区控制类
 * @author Rainmer
 *
 */
@Controller
@RequestMapping("/campus")
public class CampusController {
	private CampusService campusService;

	public CampusService getCampusService() {
		return campusService;
	}
	
	@Autowired
	public void setCampusService(CampusService campusService) {
		this.campusService = campusService;
	}
	
	@RequestMapping("/getAllCampus")
	public @ResponseBody Map<String,Object> getAllCampus(){
		Map<String,Object> requestMap = new HashMap<String,Object>();
		Map<String,Object> responseMap = new HashMap<String,Object>();
		
		JSONArray campuses = (JSONArray) JSONArray.toJSON(campusService.getAllCampus(requestMap));
		//String campuses = JSON.toJSONString(campusService.getAllCampus(requestMap));
		responseMap.put("campuses", campuses);
		
		return responseMap;
	}
}
