package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.dao.EmployeeRepository;
import com.springboot.entity.Employee;
import java.util.Optional;

//import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeRepository repository;
	public List<Employee> getAllEmployees(){
		return repository.findAll();
	}
	public void saveEmployee(Employee employee) {
		this.repository.save(employee);
	}
	@Override
	public Employee getEmployeeById(int id) {
		Optional<Employee> optional=repository.findById(id);
		Employee employee=null;
		if(optional.isPresent()) {
			employee=optional.get();
		}
		else {
			throw new RuntimeException("Employee not found for id:: "+id);
		}
		return employee;
	}
	@Override
	public void deleteEmployee(int id) {
		repository.deleteById(id);
		
	}
}
