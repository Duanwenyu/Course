package com.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.dao.StudentmessMapper;
import com.course.dao.TeachermessMapper;
import com.course.entity.Studentmess;
import com.course.entity.Teachermess;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	StudentmessMapper studentmessMapper;
	@Autowired
	TeachermessMapper teachermessMapper;
	//ѧ����¼
	public Studentmess checkStudent(Studentmess studentmess) {
		return studentmessMapper.checkStudent(studentmess);
	}
	//��ʦ��¼
	public Teachermess checkTeacher(Teachermess teachermess) {
		return teachermessMapper.checkTeacher(teachermess);
	}

}
