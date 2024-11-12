package com.centreMuraz.payroll.employeepayrollSystem.repository;

import com.centreMuraz.payroll.employeepayrollSystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
