package com.reservas.api.model.reservas;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.Type;

import com.reservas.api.model.Tables.Tables;

import io.hypersistence.utils.hibernate.type.json.JsonBinaryType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Reservas {


    public Reservas(Integer usersId, Integer tableId, Date dataReserva, Time date) {
        this.usersId = usersId;
        this.tableId = tableId;
        this.dataReserva = dataReserva;
        this.horaInicio = date;
    }
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "users_id")
    private Integer usersId;

    @Column(name = "table_id")
    private Integer tableId;

    @Column(name = "dt_reserva")
    private Date dataReserva; 

    @Column(name = "hr_inicio")
    private Time horaInicio;
}
