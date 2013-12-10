package com.java.deany.service;

import java.util.Collection;

import com.java.deany.entity.Department;

public interface DepartmentService {
	void addDepartment(Department department);
	void updateDepartment(int departmentId, Department department);
	Collection<Department> getAllDepartments();
	Department getDepartmentById(int departmentId);
	void deleteDepartment(Department department);
	int getCount();
}
