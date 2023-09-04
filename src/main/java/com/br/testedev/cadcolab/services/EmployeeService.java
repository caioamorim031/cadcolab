package com.br.testedev.cadcolab.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.br.testedev.cadcolab.Entity.Employee;
import com.br.testedev.cadcolab.exceptions.EmployeeWithSubordinatesException;
import com.br.testedev.cadcolab.repositories.IEmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private IEmployeeRepository repository;
	
	public Employee newEmployee(Employee pEmployee) {
		pEmployee.setPassword(new BCryptPasswordEncoder().encode(pEmployee.getPassword()));
		return repository.save(pEmployee);
	}
	
	public Employee findEmployee(Long pId) {
		return repository.findById(pId).orElse(null);
	}
	
	public List<Employee> getListEmployee() {
		return repository.findAll();
	}
	
	public void deleteEmployee(Employee employee) {
		if(!employee.getSubordinates().isEmpty()) {
			repository.delete(employee);			
		} else {
			throw new EmployeeWithSubordinatesException();
		}
	}

}
