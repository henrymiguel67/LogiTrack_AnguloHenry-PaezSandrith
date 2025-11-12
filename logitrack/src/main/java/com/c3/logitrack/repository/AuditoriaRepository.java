package com.c3.logitrack.repository;

import com.c3.logitrack.entities.Auditoria;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditoriaRepository extends JpaRepository<Auditoria, Long> {
   @SuppressWarnings("null")
   Optional<Auditoria> findById(Long id);
}