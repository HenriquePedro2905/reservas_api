package com.reservas.api.model.Usuarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<Usuarios, String>{

    public UserDetails findByLogin(String login);
}
