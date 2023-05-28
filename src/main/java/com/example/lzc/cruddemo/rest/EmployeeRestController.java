package com.example.lzc.cruddemo.rest;


import com.example.lzc.cruddemo.entity.Employee;
import com.example.lzc.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    // inject employee dao (constructor injection)
    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // expose "/employee" and return list of employees
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    // add mapping for GET /employees/{employeeId} by Id
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {

        Employee employee = employeeService.findById(employeeId);
        if(employee == null) {
            throw new RuntimeException("employee id not found" + employeeId);
        }
        return employee;
    }

    // add mapping for POST /employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        // set the id to 0 in case of they pass an id to Json
        // this is force a save of new item
        employee.setId(0);

        Employee dbemployee = employeeService.save(employee);
        return dbemployee;
    }

    // add PUT method
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        Employee dbemployee = employeeService.save(employee);
        return dbemployee;
    }

    // add DELETE method
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {

        Employee dbemployee = employeeService.findById(employeeId);
        // check for exception
        if (dbemployee == null){
            throw new RuntimeException("employee id not found" + employeeId);
        }
        employeeService.deleteById(employeeId);

        return "delete employee # " + employeeId;
    }

}
