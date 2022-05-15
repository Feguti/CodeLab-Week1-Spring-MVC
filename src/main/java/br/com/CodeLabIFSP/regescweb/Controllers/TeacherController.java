package br.com.CodeLabIFSP.regescweb.Controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import br.com.CodeLabIFSP.regescweb.dto.FormTeacherRequisition;
import br.com.CodeLabIFSP.regescweb.models.Teacher;
import br.com.CodeLabIFSP.regescweb.models.TeacherStatus;
import br.com.CodeLabIFSP.regescweb.repositories.TeacherRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/teachers")
public class TeacherController {
    @Autowired
    private TeacherRepository teacherRepository;

    @GetMapping("")
    public ModelAndView index() {

        List<Teacher> teachers = this.teacherRepository.findAll();

        ModelAndView mv = new ModelAndView("teachers/index.html");
        mv.addObject("teachers", teachers);

        return mv;
    }

    @GetMapping("/new")
    public ModelAndView nnew(FormTeacherRequisition requisition) {

        ModelAndView mv = new ModelAndView("teachers/new");
        mv.addObject("TeacherStatusList", TeacherStatus.values());

        return mv;
    }

    @PostMapping("")
    public ModelAndView create(@Valid FormTeacherRequisition requisition, BindingResult result) {

        if (result.hasErrors()) {

            ModelAndView mv = new ModelAndView("teachers/new");
            mv.addObject("TeacherStatusList", TeacherStatus.values());
            return mv;
        } else {

            Teacher teacher = requisition.toTeacher();
            this.teacherRepository.save(teacher);

            return new ModelAndView("redirect:/teachers/" + teacher.getId());
        }
    }

    @GetMapping("/{id}")
    public ModelAndView show(@PathVariable long id) {

        Optional<Teacher> optional = this.teacherRepository.findById(id);

        if (optional.isPresent()) {

            Teacher teacher = optional.get();

            ModelAndView mv = new ModelAndView("teachers/show");
            mv.addObject("teacher", teacher);

            return mv;
        } else {

            return new ModelAndView("redirect:/teachers");
        }
    }

    @GetMapping("/{id}/edit")
    public ModelAndView edit(@PathVariable long id, FormTeacherRequisition requisition) {

        Optional<Teacher> optional = this.teacherRepository.findById(id);

        if (optional.isPresent()) {

            Teacher teacher = optional.get();
            requisition.fromTeacher(teacher);

            ModelAndView mv = new ModelAndView("teachers/edit");

            mv.addObject("teacherID", teacher.getId());
            mv.addObject("TeacherStatusList", TeacherStatus.values());

            return mv;

        } else {

            return new ModelAndView("redirect:/teachers");
        }
    }

    @PostMapping("/{id}")
    public ModelAndView update(@PathVariable long id, @Valid FormTeacherRequisition requisition, BindingResult result) {

        if (result.hasErrors()) {

            ModelAndView mv = new ModelAndView("teachers/edit");
            mv.addObject("teacherID", id);
            mv.addObject("TeacherStatusList", TeacherStatus.values());
            return mv;

        } else {

            Optional<Teacher> optional = this.teacherRepository.findById(id);

            if (optional.isPresent()) {

                Teacher teacher = requisition.toTeacher(optional.get());
                this.teacherRepository.save(teacher);

                return new ModelAndView("redirect:/teachers/" + teacher.getId());

            }
            else {

                return new ModelAndView("redirect:/teachers");
            }
        }
    }
}
