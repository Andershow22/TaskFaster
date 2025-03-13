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
        user.setId(null); //tem q ser nulo para o JPA entender q é um novo registro 
        repo.save(user);

        return user;
    }
    public userEntity getUser(Integer id){
        userEntity user = repo.findById(id).orElse(null);
        return user;
    }
    public userEntity editarUser(userEntity user, Integer id){
        userEntity userNovo = getUser(id);

        userNovo.setNome(user.getNome());
        userNovo.setSobrenome(user.getSobrenome());
        userNovo.setEmail(user.getEmail());
        userNovo.setSenha(user.getSenha());
        repo.save(user);

        return user;
    }

}
