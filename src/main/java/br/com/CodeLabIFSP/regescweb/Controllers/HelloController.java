package br.com.CodeLabIFSP.regescweb.Controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class HelloController {
    
    @GetMapping("/hello")
    public ModelAndView hello() {
        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("nome", "Verdin");

        return mv; 
    }

    @GetMapping("/hello-model")
    public String hello(Model model) {

        model.addAttribute("nome", "Kenji");

        return "hello"; 
    }

    @GetMapping("/hello-servlet")
    public String hello(HttpServletRequest request) {

        request.setAttribute("nome", "Guti");

        return "hello"; // O Spring vai renderizar o arquivo que está em templates/hello.html
    }
}
