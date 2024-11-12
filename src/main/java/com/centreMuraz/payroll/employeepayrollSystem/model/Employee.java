package com.centreMuraz.payroll.employeepayrollSystem.model;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "employee")
@Getter
@Setter
@EqualsAndHashCode
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column (name="first_name",nullable=false)
    private String firstName;

    @Column(name="last_name",nullable=false)
    private String lastName;

    @Column(name="salary",nullable=false)
    private String salary;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "employee")
    private List<Payroll> payrollList;


}
