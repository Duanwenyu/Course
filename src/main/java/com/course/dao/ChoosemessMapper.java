package com.course.dao;

import java.util.List;

import com.course.entity.Choosemess;

public interface ChoosemessMapper {
	//�˿�
    int deleteChooseMess(Choosemess choosemess);

    //����ѡ����Ϣ
    int insertChooseMess(Choosemess choosemess);
    
    //��ѯ��ѡ�γ���
    int selectCourseNoByStuNo(Choosemess choosemess);

    int insertSelective(Choosemess record);

    //��ѯ��ѡ�γ���Ϣ
    List<Choosemess> selectChoosed(String stuNo);
    
    //��ѯѧ��ѧ����Ϣ
    List<Choosemess> selectStuNoForTeacher(String courseNo);
    
    int selectStuNoSumForTeacher(String courseNo);

    int updateByPrimaryKeySelective(Choosemess record);

    int updateByPrimaryKey(Choosemess record);
}