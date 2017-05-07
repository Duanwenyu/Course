package com.course.dao;

import com.course.entity.Teachermess;
public interface TeachermessMapper {
	//µÇÂ¼
	Teachermess checkTeacher(Teachermess teachermess);
	
    int deleteByPrimaryKey(String techNo);

    int insert(Teachermess record);

    int insertSelective(Teachermess record);

    Teachermess selectByPrimaryKey(String techNo);

    int updateByPrimaryKeySelective(Teachermess record);

    int updateByPrimaryKey(Teachermess record);
}