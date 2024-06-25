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

    @Column(name = "usuarios_id")
    private Integer usuariosId;

    @Column(name = "data_reserva")
    private LocalDateTime dataReserva; 

    @Column(name = "Status_reserva")
    private Boolean statusReserva;

    @Column(name = "servico_id")
    private Integer servicoId;
}
