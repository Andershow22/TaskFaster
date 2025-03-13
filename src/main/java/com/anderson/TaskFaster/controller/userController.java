package com.anderson.TaskFaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
    
    @GetMapping("/cadastro")
    public String getCadastro(Model m) {
        m.addAttribute("user", new userEntity());
        return "cadastro";
    }
    

    @PostMapping("/salvar")
    public String salvarUser(@ModelAttribute userEntity user) {
        if (user.getId() == null) {
            service.salvarUser(user);
        }
        
        return "redirect:/";
    }
    
}
