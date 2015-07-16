package com.changyu.foryou.service;

import java.util.List;
import java.util.Map;

import com.changyu.foryou.model.Campus;

public interface CampusService {
	public List<Campus> getAllCampus(Map<String,Object> requestMap);
}
