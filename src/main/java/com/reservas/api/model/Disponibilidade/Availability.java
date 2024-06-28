package com.reservas.api.model.Disponibilidade;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.security.access.event.PublicInvocationEvent;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "availability")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Availability {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "services_id")
    private Integer serviceId;
    
    private LocalDate data;

    @Column(name = "horario_inicio")
    private LocalTime horarioInicio;

    @Column(name = "horario_fim")
    private LocalTime horarioFim;

    public Availability(Integer serviceId, LocalDate data, LocalTime horarioInicio, LocalTime horarioFim){
        this.serviceId = serviceId;
        this.data = data;
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
    }

}
