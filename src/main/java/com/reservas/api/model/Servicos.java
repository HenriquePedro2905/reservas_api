package com.reservas.api.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "servico")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Servicos {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String descrition;

    @JsonDeserialize(as = Disponibilidade.class)
    @JsonSerialize(using = DisponibilidadeSerializer.class)
    private Map<String, Disponibilidade> disponibilidade; 

}