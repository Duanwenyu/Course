package com.course.service;

import com.course.entity.Studentmess;
import com.course.entity.Teachermess;

public interface LoginService {
	//ѧ����¼
	public Studentmess checkStudent(Studentmess studentmess);
	
	//��ʦ��¼
	public Teachermess checkTeacher(Teachermess teachermess);

}
