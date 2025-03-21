package com.anderson.TaskFaster.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anderson.TaskFaster.data.tarefaEntity;
import com.anderson.TaskFaster.data.tarefaRepository;

@Service
public class tarefaService {
    @Autowired
    tarefaRepository repo;

    public void salvar(tarefaEntity tarefa){
        tarefa.setId(null);
        repo.save(tarefa);
    }

    public tarefaEntity getTarefa(Integer id){
        return repo.findById(id).orElse(null); 
    }

    public void atualizar(tarefaEntity tarefa, Integer id){
        tarefaEntity tarefaNovo = getTarefa(id);
        tarefaNovo.setTitulo(tarefa.getTitulo());
        tarefaNovo.setData_finalizacao(tarefa.getData_finalizacao());
        tarefaNovo.setPrioridade(tarefa.getPrioridade());
        tarefaNovo.setStatus_tarefa(tarefa.getStatus_tarefa());
        repo.save(tarefa);
    }

    public List<tarefaEntity> getTarefasPorProjeto(Integer id){
        return repo.findByProjeto_id(id);
    }

    public List<tarefaEntity> getTarefasAFazer(Integer id){
        return repo.buscarTarefas("a fazer", id);
    }

    public List<tarefaEntity> getTarefasAndamento(Integer id){
        return repo.buscarTarefas("andamento", id);
    }

    public List<tarefaEntity> getTarefasConcluidas(Integer id){
        return repo.buscarTarefas("concluido", id);
    }
    
    public void deletar(Integer id){
        repo.delete(getTarefa(id));
    }

}
