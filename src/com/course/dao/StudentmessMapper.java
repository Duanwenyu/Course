package com.course.dao;

import com.course.entity.Studentmess;

public interface StudentmessMapper {
	//登录
	Studentmess checkStudent(Studentmess studentmess);
	
    int deleteByPrimaryKey(String stuNo);

    int insert(Studentmess record);

    int insertSelective(Studentmess record);

    //查询个人信息
    Studentmess selectByStuno(Studentmess studentmess);
    Studentmess selectByStuno2(String stuNo);

    int updateByPrimaryKeySelective(Studentmess record);

    int updateByPrimaryKey(Studentmess record);
}