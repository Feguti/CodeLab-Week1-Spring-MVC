package br.com.CodeLabIFSP.regescweb.Controllers;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import br.com.CodeLabIFSP.regescweb.models.Teacher;
import br.com.CodeLabIFSP.regescweb.models.TeacherStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class TeacherController {
    
    @GetMapping("/teachers")
    public ModelAndView index() {
        Teacher Izumi = new Teacher("Izumi", new BigDecimal(10000.0), TeacherStatus.ACTIVE);
        Izumi.setId(1);

        Teacher Edward = new Teacher("Edward", new BigDecimal(0.0), TeacherStatus.INACTIVE);
        Edward.setId(2);

        Teacher Kanao = new Teacher("Kanao", new BigDecimal(15000.0), TeacherStatus.RETIRED);
        Kanao.setId(3);

        Teacher Makoto = new Teacher("Makoto", new BigDecimal(15000.0), TeacherStatus.AWAY);
        Makoto.setId(4);

        List<Teacher> teachers = Arrays.asList(Izumi, Edward, Kanao, Makoto);

        ModelAndView mv = new ModelAndView("teachers/index.html");
        mv.addObject("teachers", teachers);

        return mv;
    }
}
