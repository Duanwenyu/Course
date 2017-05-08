package com.course.dao;

import com.course.entity.Manager;

public interface ManagerMapper {
	
	Manager selectByAccountAndPassword(Manager manager);
	
	int updatePassword(Manager manager);

}
