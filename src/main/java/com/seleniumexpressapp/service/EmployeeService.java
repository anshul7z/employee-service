package com.seleniumexpressapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seleniumexpressapp.entity.Employee;
import com.seleniumexpressapp.repo.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo repo;
	
	public List<Employee> getAllEmployees(){
		return repo.findAll();
	}
	
	public Employee getEmployeeById(int id) {
		return repo.findById(id).get();
	}
	
	public Employee saveEmployee(Employee emp) {
		return repo.save(emp);
	}
	
	public Employee updateEmployee(Employee emp) {
		return repo.save(emp);
	}
	
	public boolean deleteEmployeeById(int id) {
		repo.deleteById(id);
		return true;
	}
	
	public boolean deleteAllEmployees() {
		repo.deleteAll();
		return true;
	}
}
