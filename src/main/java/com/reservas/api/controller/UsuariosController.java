package com.reservas.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reservas.api.model.Usuarios.RequestUsersDTO;
import com.reservas.api.model.Usuarios.UserRepository;
import com.reservas.api.model.Usuarios.Usuarios;


@RestController
@RequestMapping("/api/usuarios")
public class UsuariosController {

    @Autowired
    private UserRepository repository;

    @PostMapping
    public ResponseEntity registerUsuarioa(@RequestBody RequestUsersDTO data){
        Usuarios newUSer = new Usuarios(data);
        repository.save(newUSer);
        return ResponseEntity.status(201).build();
    }
}
