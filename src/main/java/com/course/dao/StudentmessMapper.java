package com.course.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.course.entity.Studentmess;

public interface StudentmessMapper {
	// ��¼
	Studentmess checkStudent(Studentmess studentmess);

	int deleteByPrimaryKey(String stuNo);

	int insert(Studentmess record);

	int insertSelective(Studentmess record);

	// ��ѯ������Ϣ
	Studentmess selectByStuno(Studentmess studentmess);

	Studentmess selectByStuno2(String stuNo);

	int updateByPrimaryKeySelective(Studentmess record);

	int updateByPrimaryKey(Studentmess record);

	List<Studentmess> selectByRowBounds(RowBounds rowBounds);

	int selectCount();
}