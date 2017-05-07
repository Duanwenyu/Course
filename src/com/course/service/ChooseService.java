package com.course.service;

import java.util.List;

import com.course.entity.Choosemess;

public interface ChooseService {

	//保存选课信息
	public String insertChooseMess(Choosemess choosemess);
	
	//退课
	public String deleteChooseMess(Choosemess choosemess);
	
	//查询已选课程信息
	public List<Choosemess> selectChoosed(String stuNo);
	
	//查询学生学号信息
	public List<String> selectStuNoForTeacher(String courseNo);
	
	//查询已选课程数
	public int selectCourseNoByStuNo(Choosemess choosemess);
}
