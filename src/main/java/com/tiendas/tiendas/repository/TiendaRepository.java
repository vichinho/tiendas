package com.tiendas.tiendas.repository;

import com.tiendas.tiendas.model.Tienda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TiendaRepository extends JpaRepository<Tienda, Long> {
}