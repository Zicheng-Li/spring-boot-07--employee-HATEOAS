package com.example.lzc.cruddemo.dao;

import com.example.lzc.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class EmployeeDAOImp implements EmployeeDAO{

    // define fields for entity-manager
    private EntityManager entityManager;

    // set up constructor inject
    @Autowired
    public EmployeeDAOImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        // create a query
        TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);

        // execute the query
        List<Employee> results = query.getResultList();

        // return the results
        return results;
    }

    @Override
    public Employee findById(int id) {

        // get the employee
        Employee employee = entityManager.find(Employee.class, id);

        // return the employee
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        //save the employee
        Employee dbEmployee= entityManager.merge(employee);  // if id is ==0, then insert the employee, else update

        // return the dbEmployee
        return dbEmployee;
    }

    @Override
    public void deleteById(int id) {

        // find the employee
        Employee employee = entityManager.find(Employee.class, id);

        // delete the employee
        entityManager.remove(employee);
    }
}
