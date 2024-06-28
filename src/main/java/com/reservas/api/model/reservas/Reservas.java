package com.reservas.api.model.reservas;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class Reservas {
    
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "users_id")
    private Integer usuariosId;


    @Column(name = "services_id")
    private Integer servicoId;

    @Column(name = "data_reserva")
    private LocalDateTime dataReserva; 

    @Column(name = "status_reserva")
    private Boolean statusReserva;
}
