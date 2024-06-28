package com.reservas.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reservas.api.model.Disponibilidade.Availability;
import com.reservas.api.model.Disponibilidade.AvailabilityDTO;
import com.reservas.api.model.Disponibilidade.AvailabilityRepository;

@RestController
@RequestMapping("/api/availability")
public class AvailabilityController {

    @Autowired
    private AvailabilityRepository repository;

    @PostMapping
    public ResponseEntity registerregisterAvailability(@RequestBody AvailabilityDTO data){
        Availability newAvailability = new Availability(data.serviceID(), data.data(), data.horarioInicio(), data.horarioFIm());
        repository.save(newAvailability);
        return ResponseEntity.status(201).build();
    }

}
