package com.example.employee;

import java.util.*;

public interface EmployeeRepository {
    ArrayList<Employee> getEmployees();

    Employee addEmployee(Employee employee);

    Employee getEmployeeById(int employeeId);

    Employee updateEmployeeById(int employeeId, Employee employee);

    void deleteEmployeeById(int employeeId);

}