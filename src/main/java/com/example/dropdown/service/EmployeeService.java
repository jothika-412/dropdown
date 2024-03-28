package com.example.dropdown.service;

import java.util.List;

import com.example.dropdown.model.Employee;

public interface EmployeeService  {



List<Employee> getEmployeeByName(String name);
}
