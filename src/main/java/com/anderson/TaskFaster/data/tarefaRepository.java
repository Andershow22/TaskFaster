package com.anderson.TaskFaster.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface tarefaRepository extends JpaRepository<tarefaEntity, Integer>{
    List<tarefaEntity> findByProjeto_id(Integer id);

    @Query(value = "SELECT * FROM tarefa WHERE status_tarefa = :status_tarefa  AND projeto_id = :projeto_id", nativeQuery = true)
    public List<tarefaEntity> buscarTarefas(String status_tarefa, Integer projeto_id);
}
