package com.anderson.TaskFaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.anderson.TaskFaster.data.projetoEntity;
import com.anderson.TaskFaster.data.tarefaEntity;
import com.anderson.TaskFaster.data.userEntity;
import com.anderson.TaskFaster.service.projetoService;
import com.anderson.TaskFaster.service.tarefaService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/projeto")
public class projetoController {

    @Autowired
    projetoService service;

    @Autowired
    tarefaService serviceTarefa;

    @GetMapping("/criar")
    public String getPaginaProjeto(Model m) {

        m.addAttribute("projeto", new projetoEntity());
        return "projetos";
    }

    @PostMapping("/criar")
    public String salvarProjeto(@ModelAttribute projetoEntity projeto, HttpSession session, Model m) {
        userEntity user = (userEntity) session.getAttribute("user-logado");
        if (projeto.getId() == null) {
            projeto.setUserCriador(user);
            service.salvar(projeto);
        } else {
            projetoEntity projetoNovo = (projetoEntity) session.getAttribute("projeto-ativo");
            projeto.setUserCriador(user);
            service.atualizar(projeto, projetoNovo.getId());
        }
        session.setAttribute("user-logado", user);
        m.addAttribute("user", user);
        m.addAttribute("projetos", service.getProjetosIdUser(user.getId()));
        return "geral";
    }

    @GetMapping("/acessar")
    public String acessarProjeto(HttpSession session, Model m) {
        projetoEntity projeto = (projetoEntity) session.getAttribute("projeto-ativo");
        m.addAttribute("projeto", projeto);

        m.addAttribute("tarefasAFazer", serviceTarefa.getTarefasAFazer(projeto.getId()));
        m.addAttribute("tarefasAndamento", serviceTarefa.getTarefasAndamento(projeto.getId()));
        m.addAttribute("tarefasConcluidas", serviceTarefa.getTarefasConcluidas(projeto.getId()));

        m.addAttribute("tarefa", new tarefaEntity());
        return "tarefas";
    }

    @PostMapping("/acessar")
    public String gettarefas(Model m, @RequestParam Integer id, HttpSession session) {
        projetoEntity projeto = service.getProjeto(id);
        session.setAttribute("projeto-ativo", projeto);
        m.addAttribute("projeto", projeto);

        m.addAttribute("tarefasAFazer", serviceTarefa.getTarefasAFazer(id));
        m.addAttribute("tarefasAndamento", serviceTarefa.getTarefasAndamento(id));
        m.addAttribute("tarefasConcluidas", serviceTarefa.getTarefasConcluidas(id));

        m.addAttribute("tarefa", new tarefaEntity());
        return "tarefas";
    }

    @GetMapping("/editar")
    public String editarProjeto(HttpSession session, Model m) {
        projetoEntity projeto = (projetoEntity) session.getAttribute("projeto-ativo");
        m.addAttribute("projeto", projeto);
        return "editarProjeto";
    }

    @PostMapping("/editar")
    public String editarProjeto(@ModelAttribute projetoEntity projeto, HttpSession session, Model m) {
        projetoEntity projetoAtual = (projetoEntity) session.getAttribute("projeto-ativo");
        if (projetoAtual != null && projeto.getId().equals(projetoAtual.getId())) {
            service.atualizar(projeto, projeto.getId());
        }
        userEntity user = (userEntity) session.getAttribute("user-logado");
        m.addAttribute("user", user);
        m.addAttribute("projetos", service.getProjetosIdUser(user.getId()));
        return "geral";
    }

    @GetMapping("/excluir")
    public String getMethodName(HttpSession session) {
        projetoEntity projeto = (projetoEntity) session.getAttribute("projeto-ativo");
        service.deletar(projeto.getId());
        return "redirect:/";
    }
    


}
