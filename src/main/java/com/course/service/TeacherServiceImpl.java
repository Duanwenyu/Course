package com.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.dao.TeachermessMapper;
import com.course.entity.Teachermess;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeachermessMapper teachermessMapper;

	@Override
	public boolean update(Teachermess teachermess) {
		return 0 != teachermessMapper.updateByPrimaryKeySelective(teachermess);
	}

}
