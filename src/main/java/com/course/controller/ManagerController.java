package com.course.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.course.entity.Manager;
import com.course.entity.Studentmess;
import com.course.entity.Teachermess;
import com.course.service.ManagerService;
import com.course.service.StudentService;
import com.course.service.TeacherService;
import com.course.timer.ChooseCourseTimer;

@Controller
public class ManagerController {

	@Autowired
	private ManagerService managerService;
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private ChooseCourseTimer timer;

	@RequestMapping(value = "manager-login", method = RequestMethod.GET)
	public String toLoginPage(Model model) {
		return "manager-login";
	}

	@RequestMapping(value = "alter-man-pass", method = RequestMethod.POST)
	@ResponseBody
	public String alertPassword(HttpSession session, String oldPass, String newPass) {
		Manager manager = (Manager) session.getAttribute("manager");
		if (null == manager)
			return "re-login";
		if (!manager.getPassword().equals(oldPass))
			return "pass-error";
		manager.setPassword(newPass);
		if (managerService.updatePassword(manager)) {
			session.removeAttribute("manager");
			return "SUCCESS";
		} else
			return "FAILED";
	}

	@RequestMapping(value = "back-manage", method = RequestMethod.GET)
	public String showBackManagePage(HttpSession session) {
		if (null == session.getAttribute("manager"))
			return "redirect:/manager-login";
		else
			return "back-manage";
	}

	@RequestMapping(value = "students", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getStudents(int page, int rows) {
		return studentService.selectByPagination(page, rows);
	}

	@RequestMapping(value = "teachers", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getTeachers(int page, int rows) {
		return teacherService.selectByPagination(page, rows);
	}

	@RequestMapping(value = "alter-stu-pass-by-manager", method = RequestMethod.POST)
	@ResponseBody
	public String alterStudentPass(String _no, String pass) {
		Studentmess stu = new Studentmess();
		stu.setStuNo(_no);
		stu.setStuPassword(pass);
		return studentService.update(stu) ? "SUCCESS" : "FAILED";
	}

	@RequestMapping(value = "alter-tea-pass-by-manager", method = RequestMethod.POST)
	@ResponseBody
	public String alterTeacherPass(String _no, String pass) {
		Teachermess tea = new Teachermess();
		tea.setTechNo(_no);
		tea.setTechPassword(pass);
		return teacherService.update(tea) ? "SUCCESS" : "FAILED";
	}

	@RequestMapping(value = "set-choose-course-date", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String setChooseCourseDate(Date date) {
		try {
			timer.startAt(date);
		} catch (Exception e) {
			return e.getMessage();
		}
		return "SUCCESS";
	}

	@RequestMapping(value = "show-choose-course-date", method = RequestMethod.GET)
	public String showChooseCourseDate(Model model) {
		model.addAttribute("startDate", timer.getStartDate());
		return "choose-course-date";
	}
}
