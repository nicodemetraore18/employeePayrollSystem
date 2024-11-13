package com.centreMuraz.payroll.employeepayrollSystem.service;


import com.centreMuraz.payroll.employeepayrollSystem.model.Payroll;
import com.centreMuraz.payroll.employeepayrollSystem.repository.EmployeeRepository;
import com.centreMuraz.payroll.employeepayrollSystem.repository.PayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PayrollServiceImpl implements PayrollService{

    @Autowired
    private PayrollRepository payrollRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Payroll> getAllPayrolls() {
        return payrollRepository.findAll();
    }

    @Override
    public Payroll getPayrollByEmployeeIdAndPayPeriod(Long employeeId, String payPeriod) {
        return payrollRepository.findByEmployeeIdAndPayPeriod(employeeId,payPeriod);
    }

    @Override
    public List<Payroll> getPayrollByEmployeeId(Long employeeId) {
        if (!employeeRepository.existsById(employeeId)){
            throw  new NoSuchElementException("Employee Id number "+employeeId+"not found");
        }
        return  payrollRepository.findByEmployeeId(employeeId);
    }

    @Override
    public Payroll addPayroll(Long employeeId, Payroll payroll) {
        Payroll p=employeeRepository.findById(employeeId).map(employee -> {
            Double grossPay = employee.getSalary() * 80;
            Double netPay = grossPay * 0.8;
            payroll.setEmployee(employee);
            payroll.setGrossPay(grossPay);
            payroll.setNetPay(netPay);
            return  payrollRepository.save(payroll);

        }).orElseThrow(() -> new NoSuchElementException("Employee Id number "+employeeId+"not found"));
        return p;
    }

    @Override
    public Payroll updatePayroll(Long payrollId, Payroll payrollDetails) {
        Payroll payroll = payrollRepository.findById(payrollId).orElseThrow(() -> new NoSuchElementException("Payroll Id number "+payrollId+"not found"));
        payroll.setGrossPay(!Double.isNaN(payrollDetails.getGrossPay() ? payrollDetails.getGrossPay():payroll.getGrossPay()));
        payroll.setNetPay(!Double.isNaN(payrollDetails.getNetPay() ? payrollDetails.getNetPay():payroll.getNetPay()));
        return  payrollRepository.save(payroll);
    }
}
