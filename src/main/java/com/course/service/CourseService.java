package com.course.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.course.entity.Coursemess;
import com.course.entity.Studentmess;
import com.course.entity.Teachermess;

public interface CourseService {

	//ѡ���б�
	public List<Coursemess> selectAll(Studentmess studentmess,RowBounds rowBounds);
	
	//��ѡ�γ�
	public List<Coursemess> selectChoosed(Studentmess studentmess);
	
	//���ݽ�ʦ��Ų�ѯ
	public List<Coursemess> selectByTechno(Teachermess teachermess);
	
	//��ѯ�γ���Ϣ
	public List<Coursemess> selectForTeacher();
	
	//��ѯ����
	public int selectAllNum(Studentmess studentmess);
	
	//����ʣ������
	public int updateByPrimaryKey(Coursemess coursemess);
	
	public int updateByPrimaryKey2(Coursemess coursemess);
	
}
