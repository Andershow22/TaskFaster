package com.anderson.TaskFaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anderson.TaskFaster.data.projetoEntity;
import com.anderson.TaskFaster.service.projetoService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/projeto")
public class projetoController {

    @Autowired
    projetoService service;
    @GetMapping("/criar")
    public String getPaginaProjeto(Model m, Integer id) {
        m.addAttribute("projeto", new projetoEntity());
        return "projetos";
    }
    @PostMapping("/criar")
    public String salvarProjeto(@ModelAttribute projetoEntity projeto) {
        if (projeto.getId() == null) {
            
            service.salvar(projeto);
        }
        return "redirect:/";
    }
}
