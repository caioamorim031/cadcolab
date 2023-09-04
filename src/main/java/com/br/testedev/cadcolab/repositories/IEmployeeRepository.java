package com.br.testedev.cadcolab.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.br.testedev.cadcolab.Entity.Employee;

public interface IEmployeeRepository extends CrudRepository<Employee, Long> {
	List<Employee> findAll();
}
