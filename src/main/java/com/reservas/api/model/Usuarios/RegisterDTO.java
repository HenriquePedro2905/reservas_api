package com.reservas.api.model.Usuarios;

public record RegisterDTO(String name, String password, String login, UserRole role) {

}
