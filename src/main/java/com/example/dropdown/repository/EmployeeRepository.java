package com.example.dropdown.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dropdown.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{
//Employee findByEmployeeName(String name);
List<Employee> findByName(String name);

}

