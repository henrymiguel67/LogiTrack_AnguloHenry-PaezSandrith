package com.c3.logitrack.controller;

import com.c3.logitrack.entities.Auditoria;
import com.c3.logitrack.service.AuditoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auditoria")
@CrossOrigin(origins = "*")
public class AuditoriaController {

    @Autowired
    private AuditoriaService auditoriaService;

    // Obtener todos los registros de auditoría
    @GetMapping
    public ResponseEntity<List<Auditoria>> getAll() {
        return ResponseEntity.ok(auditoriaService.getAllAuditEntries());
    }

    // Obtener un registro por ID
    @GetMapping("/{id}")
    public ResponseEntity<Auditoria> getById(@PathVariable Long id) {
        return ResponseEntity.ok(auditoriaService.getAuditById(id));
    }

    // Crear un nuevo registro de auditoría
    @PostMapping
    public ResponseEntity<Auditoria> create(@RequestBody Auditoria auditoria) {
        return ResponseEntity.ok(auditoriaService.saveAuditEntry(auditoria));
    }

    // Actualizar un registro de auditoría
    @PutMapping("/{id}")
    public ResponseEntity<Auditoria> update(@PathVariable Long id, @RequestBody Auditoria auditoria) {
        return ResponseEntity.ok(auditoriaService.updateAuditEntry(id, auditoria));
    }

    // Eliminar un registro de auditoría
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        auditoriaService.deleteAuditEntry(id);
        return ResponseEntity.noContent().build();
    }
}
