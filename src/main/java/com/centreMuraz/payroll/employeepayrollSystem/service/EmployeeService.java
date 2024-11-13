package com.centreMuraz.payroll.employeepayrollSystem.service;

import com.centreMuraz.payroll.employeepayrollSystem.model.Employee;

import java.util.LinkedList;
import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployees();

    public Employee getEmployeeById(Long employeeId);

    public Employee addEmployee(Employee employee);

    public Employee updateEmployee(Long employeeId,Employee employee);

    public void deleteEmployee(Long employeeId);

}
