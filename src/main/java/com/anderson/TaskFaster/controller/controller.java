package com.anderson.TaskFaster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class controller {

    @GetMapping("/")
    public String getIndex() {
        return "index";
    }

    @GetMapping("/login")
    public String getLogin(Model m) {
        m.addAttribute("email", new String());
        m.addAttribute("senha", new String());
        return "login";
    }

    @GetMapping("/cadastro")
    public String getCadastro() {
        return "cadastro";
    }

    @GetMapping("/projetos")
    public String getProjetos() {
        return "projetos";
    }
    
    
    

}
