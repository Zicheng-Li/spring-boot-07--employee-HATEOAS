package com.example.lzc.cruddemo.service;

import com.example.lzc.cruddemo.dao.EmployeeDAO;
import com.example.lzc.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDA){
        this.employeeDAO = employeeDA;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }
}
