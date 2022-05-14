package br.com.CodeLabIFSP.regescweb.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;
    private BigDecimal salary;
    @Enumerated(EnumType.STRING)
    private TeacherStatus status;


    public Teacher() { }

    public Teacher(String name, BigDecimal salary, TeacherStatus status) {
        this.name = name;
        this.salary = salary;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public BigDecimal getSalary() {
        return salary;
    }


    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }


    public TeacherStatus getStatus() {
        return status;
    }


    public void setStatus(TeacherStatus status) {
        this.status = status;
    }

    
}

