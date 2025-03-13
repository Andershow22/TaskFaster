package com.anderson.TaskFaster.data;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="usuario")
public class userEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    
    //@JsonIgnore usar só depois q terminar testes
    String nome, sobrenome, email, senha;


}
