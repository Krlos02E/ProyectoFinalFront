package edu.local.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String mostrarHome() {
        
        return "../static/index";
    }

}
