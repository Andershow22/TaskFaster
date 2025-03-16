package com.anderson.TaskFaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.anderson.TaskFaster.data.projetoEntity;
import com.anderson.TaskFaster.data.userEntity;
import com.anderson.TaskFaster.service.userService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;




@Controller
@RequestMapping("/user")
public class userController {

    @Autowired
    userService service;
    

    @PostMapping("/salvar")
    public String salvarUser(@ModelAttribute userEntity user) {
        if (user.getId() == null) {
            service.salvarUser(user);
        }
        return "redirect:/";
    }

    @GetMapping("/cadastro")
    public String getLogin(Model m) {
        m.addAttribute("user", new userEntity());
        return "cadastro";
    }

    @PostMapping("/login")
    public String efetuarLogin(@RequestParam String email, @RequestParam String senha, Model m) {
        m.addAttribute("user", service.login(email, senha));
        m.addAttribute("projeto", new projetoEntity());
        return "projetos";
    }
    
    
}
