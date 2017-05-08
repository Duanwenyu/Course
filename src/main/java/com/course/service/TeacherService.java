package com.course.service;

import java.util.Map;

import com.course.entity.Teachermess;

public interface TeacherService {
	boolean update(Teachermess teachermess);

	Map<String, Object> selectByPagination(int page, int rows);
}
