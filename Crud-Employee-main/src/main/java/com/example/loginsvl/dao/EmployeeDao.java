package com.example.loginsvl.dao;

import com.example.loginsvl.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> findAll();
    Employee createOrUpdate(Employee student);
    Integer delete(int id);
    Employee finById(int id);
}
