package com.example.employeemanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "employee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "firstname", nullable = true, length = 50)
    private String firstname;
    @Basic
    @Column(name = "lastname", nullable = true, length = 50)
    private String lastname;
    @Basic
    @Column(name = "email", nullable = true, length = 50)
    private String email;
}
