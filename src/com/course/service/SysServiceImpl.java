package com.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.course.dao.SysmessMapper;
import com.course.entity.Sysmess;

@Service
public class SysServiceImpl implements SysService {
	@Autowired
	SysmessMapper sysmessMapper;
	
	public Sysmess selectAll() {
		return sysmessMapper.selectAll();
	}

}
