package com.springboot.service;

import java.util.List;

import com.springboot.entity.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployees();
	void saveEmployee(Employee employee);
	Employee getEmployeeById(int id);
	void deleteEmployee(int id);
}
