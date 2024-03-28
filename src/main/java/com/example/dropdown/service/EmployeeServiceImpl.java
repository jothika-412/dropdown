package com.example.dropdown.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dropdown.model.Employee;
import com.example.dropdown.repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService {
@Autowired
private EmployeeRepository employeeRepository;
	@Override
	public List<Employee> getEmployeeByName(String name) {
		// TODO Auto-generated method stub
		return employeeRepository.findByName(name);
	}

}
