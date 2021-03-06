package com.course.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.course.entity.Coursemess;
import com.course.entity.Studentmess;
import com.course.entity.Sysmess;
import com.course.entity.Teachermess;
import com.course.service.CourseService;
import com.course.service.LoginService;
import com.course.service.SysService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	CourseService courseService;
	
	@Autowired
	SysService sysService;
	
	@RequestMapping("logins")
	public String checkStudent(Studentmess studentmess,HttpSession session,Model model){
		Studentmess stu = loginService.checkStudent(studentmess);
		Sysmess sys = sysService.selectAll();
		if(stu != null){
			session.setAttribute("stu", stu);
			session.setAttribute("sys", sys);
			return "redirect:/courseList";
		}else{
			return "login";
		}
	}
	
	@RequestMapping("techLogins")
	public String techLogins(Teachermess teachermess,HttpSession session,Model model){
		Teachermess teacher = loginService.checkTeacher(teachermess);
		List<Coursemess> list = new ArrayList<Coursemess>();
		list = courseService.selectByTechno(teacher);
		if(teacher != null){
			session.setAttribute("teacher", teacher);
			session.setAttribute("courseList", list);
			return "redirect:/courseListTeacher";
		}else{
			return "techLogin";
		}
	}
	
	@RequestMapping("exits")
	@ResponseBody
	public String exits(HttpSession session){
		session.removeAttribute("stu");
		session.removeAttribute("teacher");
		return "success";
	}
	
}
