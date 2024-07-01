package com.reservas.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reservas.api.model.Tables.Tables;
import com.reservas.api.model.Tables.TablesDTO;
import com.reservas.api.model.Tables.TablesRepository;


@RestController
@RequestMapping("/api/tables")
public class TablesController {

    @Autowired
    private TablesRepository repository;

    @RequestMapping("/register")
    @PostMapping
    public ResponseEntity registerTables(@RequestBody TablesDTO data){
        Tables newTables = new Tables(data.numTable(), data.capacity());
        repository.save(newTables);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/getTables")
    public ResponseEntity getAllTables(){
       var allTables = repository.findAll();
       return ResponseEntity.ok(allTables);
    }
}
