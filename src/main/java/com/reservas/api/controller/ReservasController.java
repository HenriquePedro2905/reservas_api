package com.reservas.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reservas.api.model.reservas.Reservas;
import com.reservas.api.model.reservas.ReservasDTO;
import com.reservas.api.model.reservas.ReservasRepository;

@RestController
@RequestMapping("/api/reservas")
public class ReservasController {

    @Autowired
    private ReservasRepository repository;

    @PostMapping("/register")
    public ResponseEntity registerReserva(@RequestBody ReservasDTO data){
        Reservas newReserva = new Reservas(data.usersId(), data.tableId(), data.dataReserva(), data.horaInicio());
        repository.save(newReserva);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/all")
    public ResponseEntity listAllReservas(){
        var AllReservas = repository.findAll();
        return ResponseEntity.ok(AllReservas);
    }

    @GetMapping("/{usersId}")
    public ResponseEntity getReservasByid(@RequestBody ReservasDTO data){
        var reservas = repository.findByUsersId(data.usersId());
        return ResponseEntity.ok(reservas);
    }

    
}
