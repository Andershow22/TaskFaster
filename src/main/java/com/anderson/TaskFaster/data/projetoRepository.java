package com.anderson.TaskFaster.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface projetoRepository extends JpaRepository<projetoEntity, Integer> {
    List<projetoEntity> findByUserCriador_id(Integer user_id);
}
