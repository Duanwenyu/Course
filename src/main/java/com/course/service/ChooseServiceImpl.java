package com.course.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.dao.ChoosemessMapper;
import com.course.entity.Choosemess;

@Service
public class ChooseServiceImpl implements ChooseService {

	@Autowired
	ChoosemessMapper choosemessMapper;
	
	public String insertChooseMess(Choosemess choosemess) {
		choosemessMapper.insertChooseMess(choosemess);
		return "success";
	}

	public List<Choosemess> selectChoosed(String stuNo) {
		return choosemessMapper.selectChoosed(stuNo);
	}

	public String deleteChooseMess(Choosemess choosemess) {
		choosemessMapper.deleteChooseMess(choosemess);
		return "success";
	}

	public List<String> selectStuNoForTeacher(String courseNo) {
		List<Choosemess> list = choosemessMapper.selectStuNoForTeacher(courseNo);
		List<String> stuList = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			String a = new String();
			a = list.get(i).getStuNo();
			stuList.add(a);
		}
		return stuList;
	}

	public int selectCourseNoByStuNo(Choosemess choosemess) {
		return choosemessMapper.selectCourseNoByStuNo(choosemess);
	}

}
