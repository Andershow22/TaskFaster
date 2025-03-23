package com.anderson.TaskFaster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.anderson.TaskFaster.data.userEntity;
import com.anderson.TaskFaster.data.userRepository;

@Service
public class userService {


    @Autowired
    userRepository repo;

    public userEntity salvarUser(userEntity user){
        repo.save(user);

        return user;
    }
    public userEntity getUserPorId(Integer id){
        userEntity user = repo.findById(id).orElse(null);
        return user;
    }
    public void editarUser(userEntity user, Integer id) {
        userEntity userNovo = getUserPorId(id);
    
        userNovo.setNome(user.getNome());
        userNovo.setSobrenome(user.getSobrenome());
        userNovo.setEmail(user.getEmail());
        userNovo.setSenha(user.getSenha());
    
        // Salva corretamente o usuário atualizado
        repo.save(userNovo);
    }

    public userEntity login(String email, String senha){
        userEntity usuario = repo.realizarLogin(email, senha);
        return usuario;
    }

}
