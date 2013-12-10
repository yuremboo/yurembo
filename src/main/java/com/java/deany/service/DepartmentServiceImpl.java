package com.java.deany.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.java.DAO.DepartmentDAO;
import com.java.deany.Factory;
import com.java.deany.entity.Department;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	private DepartmentDAO departmentDAO = Factory.getInstance().getDepartmentDAO();

	@Override
	public void addDepartment(Department department) {
		// TODO Auto-generated method stub
		departmentDAO.addDepartment(department);
	}

	@Override
	public void updateDepartment(int departmentId, Department department) {
		// TODO Auto-generated method stub
		departmentDAO.updateDepartment(departmentId, department);
	}

	@Override
	public Collection<Department> getAllDepartments() {
		// TODO Auto-generated method stub
		return departmentDAO.getAllDepartments();
	}

	@Override
	public Department getDepartmentById(int departmentId) {
		// TODO Auto-generated method stub
		return departmentDAO.getDepartmentById(departmentId);
	}

	@Override
	public void deleteDepartment(Department department) {
		// TODO Auto-generated method stub
		departmentDAO.deleteDepartment(department);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return departmentDAO.getCount();
	}

}
