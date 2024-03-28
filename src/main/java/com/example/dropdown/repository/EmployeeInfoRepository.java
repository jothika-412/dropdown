package com.example.dropdown.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dropdown.model.EmployeeInfo;

public interface EmployeeInfoRepository extends JpaRepository<EmployeeInfo,Long> {

}
