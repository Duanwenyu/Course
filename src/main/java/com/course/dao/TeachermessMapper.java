package com.course.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.course.entity.Teachermess;

public interface TeachermessMapper {
	// ��¼
	Teachermess checkTeacher(Teachermess teachermess);

	int deleteByPrimaryKey(String techNo);

	int insert(Teachermess record);

	int insertSelective(Teachermess record);

	Teachermess selectByPrimaryKey(String techNo);

	int updateByPrimaryKeySelective(Teachermess record);

	int updateByPrimaryKey(Teachermess record);

	List<Teachermess> selectByRowBounds(RowBounds rowBounds);

	int selectCount();
}