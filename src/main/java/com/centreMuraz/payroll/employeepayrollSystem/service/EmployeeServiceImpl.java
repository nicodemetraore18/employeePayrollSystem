package com.centreMuraz.payroll.employeepayrollSystem.service;

import com.centreMuraz.payroll.employeepayrollSystem.model.Employee;
import com.centreMuraz.payroll.employeepayrollSystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EmployeeServiceImpl implements EmployeeService{


    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId).orElseThrow(() -> new NoSuchElementException("Employee Id number "+employeeId+"not found"));
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Long employeeId, Employee employeeDetails) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new NoSuchElementException("Employee Id number "+employeeId+"not found"));
        employee.setFirstName(employeeDetails.getFirstName() != null ? employeeDetails.getFirstName():employee.getFirstName());
        employee.setLastName(employeeDetails.getLastName() != null ? employeeDetails.getLastName():employee.getLastName());
        employee.setSalary(employeeDetails.getSalary());

        return  employeeRepository.save(employee);

    }

    @Override
    public void deleteEmployee(Long employeeId) {

        if (!employeeRepository.existsById(employeeId)){
            throw  new  NoSuchElementException("Employee Id number "+employeeId+"not found");
        }
        employeeRepository.deleteById(employeeId);

    }
}
