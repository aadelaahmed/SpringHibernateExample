package org.example.service;

import org.example.model.Employee;
import org.example.persistence.CRUDOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    CRUDOperation<Employee> crudEmployee;
    @Override
    public Employee addEmployee(Employee employee) {
        return crudEmployee.save(employee);
    }
}
