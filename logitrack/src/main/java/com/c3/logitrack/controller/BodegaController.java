package com.c3.logitrack.controller;

import com.c3.logitrack.entities.Bodega;
import com.c3.logitrack.service.BodegaService;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/bodegas")
public class BodegaController {

    private final BodegaService bodegaService;


    public BodegaController(BodegaService bodegaService) {
        this.bodegaService = bodegaService;
    }

    // Listar todas las bodegas
    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'EMPLEADO')")
    public ResponseEntity<List<Bodega>> listarBodegas() {
        List<Bodega> bodegas = bodegaService.listarBodegas();
        return ResponseEntity.ok(bodegas);
    }

    // Obtener bodega por ID
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'EMPLEADO')")
    public ResponseEntity<Bodega> obtenerBodega(@PathVariable Long id) {
        Bodega bodega = bodegaService.obtenerBodegaPorId(id);
        return ResponseEntity.ok(bodega);
    }

    // Crear nueva bodega
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Bodega> crearBodega(@Valid @RequestBody Bodega bodega) {
        Bodega nuevaBodega = bodegaService.crearBodega(bodega);
        return new ResponseEntity<>(nuevaBodega, HttpStatus.CREATED);
    }

    // Actualizar bodega
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Bodega> actualizarBodega(@PathVariable Long id, @Valid @RequestBody Bodega bodega) {
        Bodega bodegaActualizada = bodegaService.actualizarBodega(id, bodega);
        return ResponseEntity.ok(bodegaActualizada);
    }

    // Eliminar bodega
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> eliminarBodega(@PathVariable Long id) {
        bodegaService.eliminarBodega(id);
        return ResponseEntity.noContent().build();
    }
}
