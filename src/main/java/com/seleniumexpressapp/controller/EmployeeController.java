package com.seleniumexpressapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seleniumexpressapp.entity.Employee;
import com.seleniumexpressapp.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@GetMapping()
	public ResponseEntity<?> getAllEmployees(){
		List<Employee> employees = service.getAllEmployees();
		return ResponseEntity.status(HttpStatus.OK).body(employees);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable int id) {
		Employee employee = service.getEmployeeById(id);
		return ResponseEntity.status(HttpStatus.OK).body(employee);
	}
	
	@PostMapping()
	public ResponseEntity<?> saveEmployee(@RequestBody Employee emp) {
		Employee employee = service.saveEmployee(emp);
		return ResponseEntity.status(HttpStatus.OK).body(employee);
	}
	
	@PutMapping()
	public ResponseEntity<?> updateEmployee(@RequestBody Employee emp) {
		Employee employee = service.updateEmployee(emp);
		return ResponseEntity.status(HttpStatus.OK).body(employee);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEmployeeById(@PathVariable int id) {
		boolean response = service.deleteEmployeeById(id);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@DeleteMapping()
	public ResponseEntity<?> deleteEmployees() {
		boolean response = service.deleteAllEmployees();
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
