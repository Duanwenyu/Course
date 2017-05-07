package com.course.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.course.entity.Studentmess;
import com.course.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@RequestMapping("student/studentMess")
	public Studentmess selectByStuno(HttpSession session){
		Studentmess studentmess = (Studentmess) session.getAttribute("stu");
		return studentmess;
	}
}
