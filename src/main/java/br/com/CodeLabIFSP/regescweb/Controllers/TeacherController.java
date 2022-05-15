package br.com.CodeLabIFSP.regescweb.Controllers;

import java.util.List;

import javax.validation.Valid;

import br.com.CodeLabIFSP.regescweb.dto.NewTeacherRequisition;
import br.com.CodeLabIFSP.regescweb.models.Teacher;
import br.com.CodeLabIFSP.regescweb.models.TeacherStatus;
import br.com.CodeLabIFSP.regescweb.repositories.TeacherRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/teachers/new")
    public ModelAndView nnew(NewTeacherRequisition requisition) {

        ModelAndView mv = new ModelAndView("teachers/new");
        mv.addObject("TeacherStatusList", TeacherStatus.values());

        return mv;
    }

    @PostMapping("/teachers")
    public ModelAndView create(@Valid NewTeacherRequisition requisition, BindingResult result) {

        if (result.hasErrors()) {

            ModelAndView mv = new ModelAndView("teachers/new");
            mv.addObject("TeacherStatusList", TeacherStatus.values());
            return mv;
        } else {

            Teacher teacher = requisition.toTeacher();
            this.teacherRepository.save(teacher);

            return new ModelAndView("redirect:/teachers");
        }
    }
}
