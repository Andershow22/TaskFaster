package com.anderson.TaskFaster.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.anderson.TaskFaster.data.projetoEntity;
import com.anderson.TaskFaster.data.projetoRepository;

@Service
public class projetoService{


    @Autowired
    projetoRepository repo;

    public void salvar(projetoEntity projeto){
        projeto.setId(null);
        repo.save(projeto); 
    }

    public void atualizar(projetoEntity projeto, Integer id){
        projetoEntity projetoNovo = getProjeto(id);

        projetoNovo.setTitulo(projeto.getTitulo());
        projetoNovo.setDescricao(projeto.getDescricao());
        projetoNovo.setCategoria(projeto.getCategoria());
    }

    public projetoEntity getProjeto(Integer id){
        return repo.findById(id).orElse(null);
    }

    public List<projetoEntity> getProjetosIdUser(){
        List<projetoEntity> lista = new ArrayList<>();
        return lista;
        
    }

    public void deletar(Integer id){
        repo.delete(getProjeto(id));
    }
}
