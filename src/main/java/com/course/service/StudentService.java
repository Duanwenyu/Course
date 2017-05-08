package com.course.service;

import java.util.Map;

import com.course.entity.Studentmess;

public interface StudentService {

	public Studentmess selectByStuno(Studentmess studentmess);

	public Studentmess selectByStuno2(String stuNo);

	boolean update(Studentmess studentmess);

	Map<String, Object> selectByPagination(int page, int rows);

}
