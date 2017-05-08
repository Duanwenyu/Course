package com.course.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.course.entity.Studentmess;
import com.course.service.ChooseService;
import com.course.service.StudentService;

@Controller
public class ChooseController {
	@Autowired
	ChooseService chooseService;
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping("selectStuNoForTeacher")
	@ResponseBody
	public List<Studentmess> selectStuNoForTeacher(String courseNo){
		List<String> stuList = chooseService.selectStuNoForTeacher(courseNo);
		List<Studentmess> list = new ArrayList<Studentmess>();
		for (int i = 0; i < stuList.size(); i++) {
			Studentmess student = new Studentmess();
			student = studentService.selectByStuno2(stuList.get(i));
			list.add(student);
		}
		return list;
	}

}
