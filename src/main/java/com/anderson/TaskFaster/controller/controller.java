package com.anderson.TaskFaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.anderson.TaskFaster.data.userEntity;
import com.anderson.TaskFaster.service.projetoService;

import jakarta.servlet.http.HttpSession;




@Controller
public class controller {

    @Autowired
    projetoService serviceProjeto;

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

    @GetMapping("/geral")
    public String getMethodName(HttpSession session, Model m) {
        userEntity user = (userEntity) session.getAttribute("user-logado");
        if(user == null){
            return "login";
        }else{
            m.addAttribute("user", user);
            m.addAttribute("projetos", serviceProjeto.getProjetosIdUser(user.getId()));
            return "geral";
        }
    }
    
    
    
    

}
