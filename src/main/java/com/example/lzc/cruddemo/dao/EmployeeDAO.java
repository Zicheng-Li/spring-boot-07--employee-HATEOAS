package com.example.lzc.cruddemo.dao;

import com.example.lzc.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
