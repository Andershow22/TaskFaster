package com.anderson.TaskFaster.service;

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

    public List<projetoEntity> getProjetosIdUser(Integer id){
        List<projetoEntity> lista = repo.findByUserCriador_id(id);
        return lista;
        
    }

    public void deletar(Integer id){
        repo.delete(getProjeto(id));
    }
}
