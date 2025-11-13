package com.c3.logitrack.controller;

import com.c3.logitrack.entities.Movimiento;
import com.c3.logitrack.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/movimientos")
public class MovimientoController {

    @Autowired
    private MovimientoService movimientoService;

    /**
     * Obtener todos los movimientos
     */
    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'EMPLEADO')")
    public ResponseEntity<List<Movimiento>> getAllMovimientos() {
        List<Movimiento> movimientos = movimientoService.getAllMovimientos();
        return ResponseEntity.ok(movimientos);
    }

    /**
     * Obtener un movimiento por ID
     */
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'EMPLEADO')")
    public ResponseEntity<Movimiento> getMovimientoById(@PathVariable Long id) {
        Movimiento movimiento = movimientoService.getMovimientoById(id);
        return ResponseEntity.ok(movimiento);
    }

    /**
     * Crear un nuevo movimiento
     */
    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'EMPLEADO')")
    public ResponseEntity<Movimiento> createMovimiento(@Valid @RequestBody Movimiento movimiento) {
        Movimiento nuevoMovimiento = movimientoService.createMovimiento(movimiento);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoMovimiento);
    }

    /**
     * Actualizar un movimiento existente
     */
    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'EMPLEADO')")
    public ResponseEntity<Movimiento> updateMovimiento(@PathVariable Long id,
                                                       @Valid @RequestBody Movimiento movimientoDetails) {
        Movimiento actualizado = movimientoService.updateMovimiento(id, movimientoDetails);
        return ResponseEntity.ok(actualizado);
    }

    /**
     * Eliminar un movimiento (solo ADMIN)
     */
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteMovimiento(@PathVariable Long id) {
        movimientoService.deleteMovimiento(id);
        return ResponseEntity.noContent().build();
    }
}
