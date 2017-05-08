package com.course.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
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

	@Override
	public Map<String, Object> selectByPagination(int page, int rows) {
		Map<String, Object> ret = new HashMap<>();
		List<Teachermess> teachers = teachermessMapper.selectByRowBounds(new RowBounds((page-1)*rows, rows));
		int total = teachermessMapper.selectCount();
		ret.put("rows", teachers);
		ret.put("total", total);
		return ret;
	}

}
