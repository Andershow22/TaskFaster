package com.anderson.TaskFaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.anderson.TaskFaster.data.userEntity;
import com.anderson.TaskFaster.service.projetoService;
import com.anderson.TaskFaster.service.userService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequestMapping("/user")
public class userController {

    @Autowired
    userService service;

    @Autowired
    projetoService serviceProjeto;

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
    public String efetuarLogin(@RequestParam String email, String senha, Model m, HttpSession sessao) {
        userEntity user = service.login(email, senha);
        if (user != null) {
            sessao.setAttribute("user-logado", user);
            m.addAttribute("user", user);
            m.addAttribute("projetos", serviceProjeto);
            return "projetos";
        }
        return "redirect:/login";
    }

}
