package com.course.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.course.entity.Studentmess;
import com.course.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	StudentService studentService;

	@RequestMapping("student/studentMess")
	public Studentmess selectByStuno(HttpSession session) {
		Studentmess studentmess = (Studentmess) session.getAttribute("stu");
		return studentmess;
	}

	@RequestMapping(value = "alter-stu-pass", method = RequestMethod.POST)
	@ResponseBody
	public String alertPassword(HttpSession session, String oldPass, String newPass) {
		Studentmess studentmess = (Studentmess) session.getAttribute("stu");
		if (null == studentmess)
			return "re-login";
		if (!studentmess.getStuPassword().equals(oldPass))
			return "pass-error";
		studentmess.setStuPassword(newPass);
		if (studentService.update(studentmess)) {
			session.removeAttribute("stu");
			return "SUCCESS";
		} else
			return "FAILED";
	}
}
