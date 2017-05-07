package com.course.dao;

import com.course.entity.Sysmess;

public interface SysmessMapper {
	Sysmess selectAll();
	
    int insert(Sysmess record);

    int insertSelective(Sysmess record);
}