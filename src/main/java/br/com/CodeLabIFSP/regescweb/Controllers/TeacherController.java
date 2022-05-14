package br.com.CodeLabIFSP.regescweb.Controllers;

import java.util.List;

import br.com.CodeLabIFSP.regescweb.models.Teacher;
import br.com.CodeLabIFSP.regescweb.repositories.TeacherRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class TeacherController {
    @Autowired   
    private TeacherRepository teacherRepository;

    @GetMapping("/teachers")
    public ModelAndView index() {

        List<Teacher> teachers = this.teacherRepository.findAll();

        ModelAndView mv = new ModelAndView("teachers/index.html");
        mv.addObject("teachers", teachers);

        return mv; 
    }
}
