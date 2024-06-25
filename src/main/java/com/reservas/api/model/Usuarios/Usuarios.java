package com.reservas.api.model.Usuarios;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "usuarios")
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Usuarios {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String email;

    private String password;


    public Usuarios(RequestUsersDTO requestDTO) {
        this.name = requestDTO.name();
        this.email = requestDTO.email();
        this.password = requestDTO.password();
    }

}
