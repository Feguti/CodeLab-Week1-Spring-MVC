package br.com.CodeLabIFSP.regescweb.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Discipline {
    @Id
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String disciplineCode;


    public Discipline() {

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


    public String getDisciplineCode() {
        return disciplineCode;
    }


    public void setDisciplineCode(String disciplineCode) {
        this.disciplineCode = disciplineCode;
    }

    
}
