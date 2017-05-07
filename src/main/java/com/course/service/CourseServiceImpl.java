package com.course.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.dao.CoursemessMapper;
import com.course.entity.Coursemess;
import com.course.entity.Studentmess;
import com.course.entity.Teachermess;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	CoursemessMapper coursemessMapper;
		
	public List<Coursemess> selectAll(Studentmess studentmess,RowBounds rowBounds) {
		return coursemessMapper.selectAll(studentmess,rowBounds);
	}

	public int updateByPrimaryKey(Coursemess coursemess) {
		return coursemessMapper.updateByPrimaryKey(coursemess);
	}

	public List<Coursemess> selectChoosed(Studentmess studentmess) {
		return coursemessMapper.selectChoosed(studentmess);
	}

	public int updateByPrimaryKey2(Coursemess coursemess) {
		return coursemessMapper.updateByPrimaryKey2(coursemess);
	}

	public List<Coursemess> selectByTechno(Teachermess teachermess) {
		return coursemessMapper.selectByTechno(teachermess);
	}

	public List<Coursemess> selectForTeacher() {
		return coursemessMapper.selectForTeacher();
	}

	public int selectAllNum(Studentmess studentmess) {
		return coursemessMapper.selectAllNum(studentmess);
	}

}
