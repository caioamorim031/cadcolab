package com.br.testedev.cadcolab.Entity;

import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	
	@OneToMany
	private List<Employee> subordinates;
	
	@OneToOne
	@JoinColumn(name = "manager_id", referencedColumnName = "id")
	private Employee manager;

}
