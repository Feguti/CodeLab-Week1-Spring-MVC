package br.com.CodeLabIFSP.regescweb.dto;

import java.math.BigDecimal;

import br.com.CodeLabIFSP.regescweb.models.Teacher;
import br.com.CodeLabIFSP.regescweb.models.TeacherStatus;

public class NewTeacherRequisition {

    private String name;
    private TeacherStatus status;
    private BigDecimal salary;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TeacherStatus getStatus() {
        return status;
    }

    public void setStatus(TeacherStatus status) {
        this.status = status;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    
    public Teacher toTeacher() {
        Teacher teacher = new Teacher();
        teacher.setName(this.name);
        teacher.setSalary(this.salary);
        teacher.setStatus(this.status);

        return teacher;
    }

    @Override
    public String toString() {
        return "NewTeacherRequisition{" +
        "Name="  + name + 
        ", Salary=" + salary +
        ", TeacherStatus=" + status +
        '}';
    }

    
}
