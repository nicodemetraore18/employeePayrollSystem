package com.centreMuraz.payroll.employeepayrollSystem.model;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "payroll")
@Getter
@Setter
@EqualsAndHashCode

public class Payroll {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="gross_pay")
    private double grossPay;

    @Column(name="net_pay")
    private double netPay;

    @Column(name="pay_period" , unique =true)
    private String payPeriod;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id",referencedColumnName = "id")
    private Employee employee;


}
