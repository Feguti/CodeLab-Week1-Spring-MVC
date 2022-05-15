package br.com.CodeLabIFSP.regescweb.dto;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.CodeLabIFSP.regescweb.models.Teacher;
import br.com.CodeLabIFSP.regescweb.models.TeacherStatus;

public class FormTeacherRequisition {

    @NotBlank
    @NotNull
    private String name;
    private TeacherStatus status;
    @NotNull
    @DecimalMin(value="0.0", inclusive=false)
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

    public void fromTeacher(Teacher teacher) {
        this.name = teacher.getName();
        this.salary = teacher.getSalary();
        this.status = teacher.getStatus();
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
