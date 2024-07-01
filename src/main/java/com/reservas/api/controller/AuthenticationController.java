package com.reservas.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reservas.api.infra.security.TokenService;
import com.reservas.api.model.Usuarios.AuthenticationDTO;
import com.reservas.api.model.Usuarios.RegisterDTO;
import com.reservas.api.model.Usuarios.LoginResponseDTO;
import com.reservas.api.model.Usuarios.UserRepository;
import com.reservas.api.model.Usuarios.Users;

import lombok.var;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {


    @Autowired
    TokenService tokenService;

    @Autowired
    private UserRepository repository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationDTO data){
        
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password()) ;
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((Users) auth.getPrincipal());
        // var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity registerUsuarioa(@RequestBody RegisterDTO data){
        if (this.repository.findByLogin(data.login()) != null) return ResponseEntity.ok().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        Users newUSer = new Users(data.name(), data.login(), encryptedPassword, data.role());
        repository.save(newUSer);
        return ResponseEntity.status(201).build();
    }
}
