package br.com.CodeLabIFSP.regescweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.CodeLabIFSP.regescweb.models.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    
} 

