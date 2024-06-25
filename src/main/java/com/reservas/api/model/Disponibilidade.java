package com.reservas.api.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Disponibilidade {

    @Id
    @GeneratedValue
    private long id;

    private Integer servicoId;
    
    private LocalDate data;

    private LocalTime horarioInicio;

    private LocalTime horarioFim;
}
