package com.reservas.api.model.Usuarios;

public record RegisterDTO(String name, String login, String password, UserRole role) {

}
