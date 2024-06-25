package com.reservas.api.model.Disponibilidade;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "disponibilidade")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Disponibilidade implements Serializable{

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "servico_id")
    private Integer servicoId;
    
    private LocalDate data;

    @Column(name = "horario_inicio")
    private LocalTime horarioInicio;

    @Column(name = "horario_fim")
    private LocalTime horarioFim;

    
}
