package com.course.dao;

import java.util.List;

import com.course.entity.Choosemess;

public interface ChoosemessMapper {
	//退课
    int deleteChooseMess(Choosemess choosemess);

    //保存选课信息
    int insertChooseMess(Choosemess choosemess);
    
    //查询已选课程数
    int selectCourseNoByStuNo(Choosemess choosemess);

    int insertSelective(Choosemess record);

    //查询已选课程信息
    List<Choosemess> selectChoosed(String stuNo);
    
    //查询学生学号信息
    List<Choosemess> selectStuNoForTeacher(String courseNo);
    
    int selectStuNoSumForTeacher(String courseNo);

    int updateByPrimaryKeySelective(Choosemess record);

    int updateByPrimaryKey(Choosemess record);
}