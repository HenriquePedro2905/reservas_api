package com.reservas.api.model.Servicos;

import java.util.List;

import org.hibernate.annotations.Type;

import com.reservas.api.model.Disponibilidade.Disponibilidade;

import io.hypersistence.utils.hibernate.type.json.JsonBinaryType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Table(name = "servicos")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

// (Name = "jsonb", typeClass = JsonBinaryType.class)
public class Servicos {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String description;

    @Type(value = JsonBinaryType.class)
    @Column(columnDefinition = "jsonb")
    private List<Disponibilidade> dispo;

    public Servicos(List dispo){
        this.dispo = dispo;
    }
}