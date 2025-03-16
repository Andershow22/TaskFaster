package com.anderson.TaskFaster.data;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tarefa")
public class tarefaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String titulo, prioridade, status_tarefa;

    @DateTimeFormat(pattern = "yyyy/mm/dd")
    private LocalDate data_criacao = LocalDate.now();

    @DateTimeFormat(pattern = "yyyy/mm/dd")
    private LocalDate data_finalizacao;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="projeto_id")
    @JsonIgnore
    private projetoEntity projeto;

}
