package br.com.CodeLabIFSP.regescweb.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class Student {
    @Id
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String RegistrationCode;
    @Enumerated(EnumType.STRING)
    private StudentStatus status;

    public Student() {

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

    public String getRegistrationCode() {
        return RegistrationCode;
    }

    public void setRegistrationCode(String registrationCode) {
        RegistrationCode = registrationCode;
    }

    public StudentStatus getStatus() {
        return status;
    }

    public void setStatus(StudentStatus status) {
        this.status = status;
    }

    
}
