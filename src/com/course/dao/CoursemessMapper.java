package com.course.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.course.entity.Coursemess;
import com.course.entity.Studentmess;
import com.course.entity.Teachermess;

public interface CoursemessMapper {
	//ѡ���б�
	List<Coursemess> selectAll(Studentmess studentmess,RowBounds rowBounds);
	
	//��ѯ������
	int selectAllNum(Studentmess studentmess);
	
	//��ѯ��ѡ�γ�
	List<Coursemess> selectChoosed(Studentmess studentmess);
	
	//���ݽ�ʦ��Ų�ѯ�γ�
	List<Coursemess> selectByTechno(Teachermess teachermess);

	//��ѯ�γ���Ϣ
	List<Coursemess> selectForTeacher();
	
    int deleteByPrimaryKey(String courseNo);

    int insert(Coursemess record);

    int insertSelective(Coursemess record);

    Coursemess selectByPrimaryKey(String courseNo);

    int updateByPrimaryKeySelective(Coursemess record);

    //����ʣ������
    int updateByPrimaryKey(Coursemess coursemess);
    int updateByPrimaryKey2(Coursemess coursemess);
    
    
    
}