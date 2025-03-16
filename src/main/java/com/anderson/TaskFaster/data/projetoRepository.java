package com.anderson.TaskFaster.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface projetoRepository extends JpaRepository<projetoEntity, Integer> {

}
