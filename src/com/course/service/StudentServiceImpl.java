package com.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.dao.StudentmessMapper;
import com.course.entity.Studentmess;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentmessMapper studentmessMapper;

	public Studentmess selectByStuno(Studentmess studentmess) {
		return studentmessMapper.selectByStuno(studentmess);
	}

	public Studentmess selectByStuno2(String stuNo) {
		return studentmessMapper.selectByStuno2(stuNo);
	}

}
