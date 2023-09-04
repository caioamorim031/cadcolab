package com.br.testedev.cadcolab.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.testedev.cadcolab.Entity.Employee;
import com.br.testedev.cadcolab.services.EmployeeService;
import com.br.testedev.cadcolab.util.PasswordUtil;

@RestController
@RequestMapping("employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@PostMapping("/new")
	public Employee insertEmployee(@RequestBody Employee pEmployee, @RequestParam(required = false) Long pManagerId){
		
		if(pManagerId != null) {
			pEmployee.setManager(service.findEmployee(pManagerId));
		}
		pEmployee.setScore(PasswordUtil.calculateScore(pEmployee.getPassword()));
		
		
		return service.newEmployee(pEmployee);
	}
	
	@GetMapping("/")
	public List<Employee> getEmployee(){
		return service.getListEmployee();
	}
	
	@DeleteMapping("/delete")
	public void deleteEmployee(@RequestParam Long pEmployee) {
		Employee employee = service.findEmployee(pEmployee);
		
		if(employee != null) {
			service.deleteEmployee(employee);
		}
	}
}
