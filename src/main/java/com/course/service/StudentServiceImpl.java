package com.course.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
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

	@Override
	public boolean update(Studentmess studentmess) {
		return 0 != studentmessMapper.updateByPrimaryKeySelective(studentmess);
	}

	@Override
	public Map<String, Object> selectByPagination(int page, int rows) {
		Map<String, Object> ret = new HashMap<>();
		List<Studentmess> students = studentmessMapper.selectByRowBounds(new RowBounds((page - 1) * rows, rows));
		int total = studentmessMapper.selectCount();
		ret.put("rows", students);
		ret.put("total", total);
		return ret;
	}

}
