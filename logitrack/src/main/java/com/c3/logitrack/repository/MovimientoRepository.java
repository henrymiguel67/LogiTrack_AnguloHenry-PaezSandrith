package com.c3.logitrack.repository;

import com.c3.logitrack.entities.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {

    // Si deseas buscar por tipo (ya que la entidad lo tiene)
    List<Movimiento> findByTipo(String tipo);

    // Si quieres buscar por fecha exacta
    List<Movimiento> findByFecha(java.util.Date fecha);
}
