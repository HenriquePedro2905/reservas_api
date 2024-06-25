package com.reservas.api.model;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class DisponibilidadeSerializer extends JsonSerializer<Disponibilidade>{
 @Override
    public void serialize(Disponibilidade disponibilidade, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeObject(disponibilidade);
    }
}
