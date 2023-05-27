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
}
