package com.java.DAO;

import java.sql.SQLException;
import java.util.Collection;

import com.java.deany.entity.Department;

public interface DepartmentDAO {
	void addDepartment(Department department) throws SQLException;
	void updateDepartment(int departmentId, Department department) throws SQLException;
	Collection<Department> getAllDepartments() throws SQLException;
	Department getDepartmentById(int departmentId) throws SQLException;
	void deleteDepartment(Department department) throws SQLException;
	int getCount() throws SQLException;
}
