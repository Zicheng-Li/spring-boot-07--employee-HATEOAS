package com.example.lzc.cruddemo.dao;

import com.example.lzc.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // that is it, no need to write anything
}
