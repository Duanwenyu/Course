package com.course.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.course.entity.Studentmess;
import com.course.entity.Teachermess;

@Controller
public class GotoController {
	
	@RequestMapping("courseList")
	public String gotocourseList(HttpSession session){
		Studentmess stu = (Studentmess) session.getAttribute("stu");
		if(stu == null){
			return "redirect:/logins";
		}
		return "courseList";
	}
	
	@RequestMapping("courseListTeacher")
	public String courseListTeacher(HttpSession session){
		Teachermess teacher = (Teachermess) session.getAttribute("teacher");
		if(teacher == null){
			return "redirect:/techLogins";
		}
		return "courseListTeacher";
	}
	
	@RequestMapping("showStuMess")
	public String showStuMess(){
		return "showStuMess";
	}
	
	@RequestMapping("showTechMess")
	public String showTechMess(){
		return "showTechMess";
	}
	
	@RequestMapping("changeStuPass")
	public String changeStuPass(){
		return "changeStuPass";
	}
	
}
