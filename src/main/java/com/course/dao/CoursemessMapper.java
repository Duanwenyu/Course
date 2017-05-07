package com.course.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.course.entity.Coursemess;
import com.course.entity.Studentmess;
import com.course.entity.Teachermess;

public interface CoursemessMapper {
	//选课列表
	List<Coursemess> selectAll(Studentmess studentmess,RowBounds rowBounds);
	
	//查询总行数
	int selectAllNum(Studentmess studentmess);
	
	//查询已选课程
	List<Coursemess> selectChoosed(Studentmess studentmess);
	
	//根据教师编号查询课程
	List<Coursemess> selectByTechno(Teachermess teachermess);

	//查询课程信息
	List<Coursemess> selectForTeacher();
	
    int deleteByPrimaryKey(String courseNo);

    int insert(Coursemess record);

    int insertSelective(Coursemess record);

    Coursemess selectByPrimaryKey(String courseNo);

    int updateByPrimaryKeySelective(Coursemess record);

    //更新剩余人数
    int updateByPrimaryKey(Coursemess coursemess);
    int updateByPrimaryKey2(Coursemess coursemess);
    
    
    
}