package com.anderson.TaskFaster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class controller {

    @GetMapping("/")
    public String getIndex() {
        return "index";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @GetMapping("/cadastro")
    public String getCadastro() {
        return "cadastro";
    }

    @GetMapping("/tarefas")
    public String getTarefas() {
        return "tarefas";
    }
    
    
    

}
