package com.c3.logitrack.repository;

import com.c3.logitrack.entities.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {
    // Aquí puedes definir métodos de consulta personalizados
}