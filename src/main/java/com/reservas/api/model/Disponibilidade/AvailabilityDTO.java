package com.reservas.api.model.Disponibilidade;

import java.time.LocalDate;
import java.time.LocalTime;

public record AvailabilityDTO(Integer serviceID, LocalDate data, LocalTime horarioInicio, LocalTime horarioFIm) {
}
