package com.anderson.TaskFaster.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface tarefaRepository extends JpaRepository<tarefaEntity, Integer>{
    List<tarefaEntity> findByProjeto_id(Integer id);
}
