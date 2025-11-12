package com.c3.logitrack.service;

import com.c3.logitrack.entities.Movimiento;
import com.c3.logitrack.exception.ResourceNotFoundException;
import com.c3.logitrack.repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimientoService {

    @Autowired
    private MovimientoRepository movimientoRepository;

    public List<Movimiento> getAllMovimientos() {
        return movimientoRepository.findAll();
    }

    @SuppressWarnings("null")
    public Movimiento getMovimientoById(Long id) {
        return movimientoRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Movimiento no encontrado con id: " + id));
    }

    @SuppressWarnings("null")
    public Movimiento createMovimiento(Movimiento movimiento) {
        return movimientoRepository.save(movimiento);
    }

    public Movimiento updateMovimiento(Long id, Movimiento movimientoDetails) {
        Movimiento movimiento = getMovimientoById(id);
        movimiento.setFecha(movimientoDetails.getFecha());
        movimiento.setTipo(movimientoDetails.getTipo());
        movimiento.setCantidad(movimientoDetails.getCantidad());
        // Otros setters según sea necesario
        return movimientoRepository.save(movimiento);
    }

    @SuppressWarnings("null")
    public void deleteMovimiento(Long id) {
        Movimiento movimiento = getMovimientoById(id);
        movimientoRepository.delete(movimiento);
    }
}