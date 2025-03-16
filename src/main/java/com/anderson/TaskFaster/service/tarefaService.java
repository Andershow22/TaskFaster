package com.anderson.TaskFaster.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.anderson.TaskFaster.data.tarefaEntity;
import com.anderson.TaskFaster.data.tarefaRepository;

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

    }

    public void deletar(Integer id){
        repo.delete(getTarefa(id));
    }

}
