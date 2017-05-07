package com.course.service;

import java.util.List;

import com.course.entity.Choosemess;

public interface ChooseService {

	//����ѡ����Ϣ
	public String insertChooseMess(Choosemess choosemess);
	
	//�˿�
	public String deleteChooseMess(Choosemess choosemess);
	
	//��ѯ��ѡ�γ���Ϣ
	public List<Choosemess> selectChoosed(String stuNo);
	
	//��ѯѧ��ѧ����Ϣ
	public List<String> selectStuNoForTeacher(String courseNo);
	
	//��ѯ��ѡ�γ���
	public int selectCourseNoByStuNo(Choosemess choosemess);
}
