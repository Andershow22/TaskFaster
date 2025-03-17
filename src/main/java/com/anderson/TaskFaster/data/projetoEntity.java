package com.anderson.TaskFaster.data;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "projeto")
public class projetoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne()
    @JoinColumn(name = "id_user_criador")
    @JsonIgnore
    private userEntity user_criador;

    private String titulo, descricao, categoria;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataCriacao = LocalDate.now(); //a data em que foi criado o projeto

}
