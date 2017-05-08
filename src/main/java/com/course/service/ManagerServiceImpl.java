package com.course.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.course.dao.ManagerMapper;
import com.course.entity.Manager;

@Service
public class ManagerServiceImpl implements ManagerService {

	@Resource
	private ManagerMapper managerDao;

	@Override
	public Manager login(Manager manager) {
		return managerDao.selectByAccountAndPassword(manager);
	}

	@Override
	public boolean updatePassword(Manager manager) {
		return 0 != managerDao.updatePassword(manager);
	}

}
