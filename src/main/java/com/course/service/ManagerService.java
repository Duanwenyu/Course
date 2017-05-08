package com.course.service;

import com.course.entity.Manager;

public interface ManagerService {

	Manager login(Manager manager);

	boolean updatePassword(Manager manager);
}
