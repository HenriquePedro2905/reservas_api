package com.reservas.api.model.reservas;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservasRepository extends JpaRepository<Reservas, Long>{

    public List<Reservas> findByUsersId(Integer UsersId);
}
