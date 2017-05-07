package com.course.service;

import com.course.entity.Studentmess;
import com.course.entity.Teachermess;

public interface LoginService {
	//学生登录
	public Studentmess checkStudent(Studentmess studentmess);
	
	//老师登录
	public Teachermess checkTeacher(Teachermess teachermess);

}
