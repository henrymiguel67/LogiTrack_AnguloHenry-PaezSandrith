package com.c3.logitrack.repository;

import com.c3.logitrack.entities.Producto;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    Optional <Producto> findByNombre(String nombre);
}