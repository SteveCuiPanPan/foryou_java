package com.changyu.foryou.mapper;

import java.util.List;
import java.util.Map;

import com.changyu.foryou.model.Campus;

public interface CampusMapper {
    int deleteByPrimaryKey(Integer campusId);

    int insert(Campus record);

    int insertSelective(Campus record);

    Campus selectByPrimaryKey(Integer campusId);

    int updateByPrimaryKeySelective(Campus record);

    int updateByPrimaryKey(Campus record);
    
    List<Campus> selectAllCampus(Map<String,Object> requestMap);
}