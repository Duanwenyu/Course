package com.course.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.course.entity.Choosemess;
import com.course.entity.Coursemess;
import com.course.entity.Studentmess;
import com.course.entity.Sysmess;
import com.course.service.ChooseService;
import com.course.service.CourseService;

@Controller
public class CourseController {
	@Autowired
	CourseService courseService;
	
	@Autowired
	ChooseService chooseService;
	
	//选课菜单列表
	@RequestMapping("course/showList")
	@ResponseBody
	public Map<String,Object> showList(int page, int rows, HttpSession session){
		Studentmess studentmess = (Studentmess) session.getAttribute("stu");
		RowBounds rowBounds  = new RowBounds((page-1)*rows, rows);
		List<Coursemess> list = courseService.selectAll(studentmess,rowBounds);
		int total = courseService.selectAllNum(studentmess);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", list);
		return map;
	}
	
	//保存选课信息
	@RequestMapping("course/insertChooseMess")
	@Transactional
	@ResponseBody
	public String insertChooseMess(Choosemess choosemess , HttpSession session){
		Sysmess sysmess = (Sysmess) session.getAttribute("sys");
		Studentmess student = (Studentmess) session.getAttribute("stu");
		choosemess.setStuNo(student.getStuNo());
		int courseNo = sysmess.getSysChoosenum();
		int CourseNoStu = chooseService.selectCourseNoByStuNo(choosemess);
		if(CourseNoStu < courseNo){
			Studentmess studentmess = (Studentmess) session.getAttribute("stu");
			Choosemess c = new Choosemess();
			c.setStuNo(studentmess.getStuNo());
			c.setCourseNo(choosemess.getCourseNo());
			c.setCourseName(choosemess.getCourseName());
			c.setTechNo(choosemess.getTechNo());
			c.setTechName(choosemess.getTechName());
			c.setCourseTime(choosemess.getCourseTime());
			c.setCourseScore(choosemess.getCourseScore());
			c.setCourseDescribe(choosemess.getCourseDescribe());
			c.setCourseNumber(choosemess.getCourseNumber());
			c.setCourseStatus("1");
			chooseService.insertChooseMess(c);
			Coursemess coursemess = new Coursemess();
			coursemess.setCourseNo(choosemess.getCourseNo());
			coursemess.setCourseNumber(choosemess.getCourseNumber()-1);
			courseService.updateByPrimaryKey(coursemess);
			return "success";
		}else{
			return "" + courseNo;
		}
	}
	
	//查询已选课程信息
	@RequestMapping("course/showChoosedList")
	@ResponseBody
	public List<Coursemess> selectChoosed(Choosemess choosemess , HttpSession session){
		Studentmess studentmess = (Studentmess) session.getAttribute("stu");
		List<Coursemess> list = new ArrayList<Coursemess>();
		list = courseService.selectChoosed(studentmess);
		return list;
	}

	//退课
	@RequestMapping("course/deleteChooseMess")
	@Transactional
	@ResponseBody
	public String deleteChooseMess(Choosemess choosemess , HttpSession session){
		Studentmess studentmess = (Studentmess) session.getAttribute("stu");
		Choosemess c = new Choosemess();
		c.setCourseNo(choosemess.getCourseNo());
		c.setStuNo(studentmess.getStuNo());
		chooseService.deleteChooseMess(c);
		Coursemess coursemess = new Coursemess();
		coursemess.setCourseNo(choosemess.getCourseNo());
		coursemess.setCourseNumber(choosemess.getCourseNumber() + 1);
		courseService.updateByPrimaryKey(coursemess);
		return "success";
	}
	
	
	@RequestMapping("course/selectForTeacher")
	@ResponseBody
	public List<Coursemess> selectForTeacher(HttpSession session){
		List<Coursemess> list = new ArrayList<Coursemess>();
		list = courseService.selectForTeacher();
		return list;
	}
	
}
