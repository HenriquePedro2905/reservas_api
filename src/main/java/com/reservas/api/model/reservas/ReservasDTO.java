package com.reservas.api.model.reservas;

import java.sql.Time;
import java.util.Date;


public record ReservasDTO(Integer usersId, Integer tableId, Date dataReserva, Time horaInicio) {

}
