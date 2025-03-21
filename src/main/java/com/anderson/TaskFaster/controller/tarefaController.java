package com.anderson.TaskFaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.anderson.TaskFaster.data.projetoEntity;
import com.anderson.TaskFaster.data.tarefaEntity;
import com.anderson.TaskFaster.service.projetoService;
import com.anderson.TaskFaster.service.tarefaService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/tarefa")
public class tarefaController {

    @Autowired
    tarefaService service;

    @Autowired
    projetoService serviceProjeto;

    @PostMapping("/criar")
    public String salvarTarefa(@ModelAttribute tarefaEntity tarefa, Model m, HttpSession session) {
        projetoEntity projeto = (projetoEntity) session.getAttribute("projeto-ativo");
        tarefa.setProjeto(projeto);
        if (tarefa.getId() == null) {
            service.salvar(tarefa);
        } else {
            service.atualizar(tarefa, tarefa.getId());
        }
        return "redirect:/projeto/acessar";
    }

    @PostMapping("/atualizar")
    public String attTarefa(@RequestParam("id_task") Integer id, @RequestParam("status_tarefa") String status, HttpSession session) {
        tarefaEntity tarefa = service.getTarefa(id);
        if (tarefa != null) {
            projetoEntity projeto = (projetoEntity) session.getAttribute("projeto-ativo");
            tarefa.setProjeto(projeto);
            tarefa.setStatus_tarefa(status);
            service.atualizar(tarefa, id);
        } else {
            throw new RuntimeException("Tarefa não encontrada!");
        }
        return "redirect:/projeto/acessar";
    }

}
