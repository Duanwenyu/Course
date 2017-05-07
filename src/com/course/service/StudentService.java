package com.course.service;

import com.course.entity.Studentmess;

public interface StudentService {
	
	public  Studentmess selectByStuno(Studentmess studentmess);
	public  Studentmess selectByStuno2(String stuNo);

}
