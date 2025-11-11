package com.c3.logitrack.repository;

import com.c3.logitrack.entities.Auditoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditoriaRepository extends JpaRepository<Auditoria, Long> {
    // Consultas específicas a auditoría pueden ir aquí
}