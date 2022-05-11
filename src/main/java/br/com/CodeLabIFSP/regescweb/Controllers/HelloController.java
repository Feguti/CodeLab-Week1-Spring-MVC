package br.com.CodeLabIFSP.regescweb.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class HelloController {
    
    @GetMapping("/hello")
    public String hello() {

        return "hello"; // O Spring vai renderizar o arquivo que está em templates/hello.html
    }
}
