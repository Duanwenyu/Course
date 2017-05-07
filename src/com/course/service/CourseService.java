package com.course.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.course.entity.Coursemess;
import com.course.entity.Studentmess;
import com.course.entity.Teachermess;

public interface CourseService {

	//选课列表
	public List<Coursemess> selectAll(Studentmess studentmess,RowBounds rowBounds);
	
	//已选课程
	public List<Coursemess> selectChoosed(Studentmess studentmess);
	
	//根据教师编号查询
	public List<Coursemess> selectByTechno(Teachermess teachermess);
	
	//查询课程信息
	public List<Coursemess> selectForTeacher();
	
	//查询总数
	public int selectAllNum(Studentmess studentmess);
	
	//更新剩余人数
	public int updateByPrimaryKey(Coursemess coursemess);
	
	public int updateByPrimaryKey2(Coursemess coursemess);
	
}
