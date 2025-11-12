package com.c3.logitrack.service;

import com.c3.logitrack.entities.Auditoria;
import com.c3.logitrack.exception.ResourceNotFoundException;
import com.c3.logitrack.repository.AuditoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditoriaService {

    @Autowired
    private AuditoriaRepository auditoriaRepository;

    public List<Auditoria> getAllAuditEntries() {
        return auditoriaRepository.findAll();
    }

    public Auditoria getAuditById(Long id) {
        return auditoriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Registro de auditoría no encontrado con id: " + id));
    }

    @SuppressWarnings("null")
    public Auditoria saveAuditEntry(Auditoria auditoria) {
        return auditoriaRepository.save(auditoria);
    }

    public Auditoria updateAuditEntry(Long id, Auditoria auditoriaDetails) {
        Auditoria auditoria = getAuditById(id);
        auditoria.setAccion(auditoriaDetails.getAccion());
        auditoria.setUsuario(auditoriaDetails.getUsuario());
        auditoria.setFecha(auditoriaDetails.getFecha());
        return auditoriaRepository.save(auditoria);
    }

    @SuppressWarnings("null")
    public void deleteAuditEntry(Long id) {
        Auditoria auditoria = getAuditById(id);
        auditoriaRepository.delete(auditoria);
    }

    // Método para registrar una acción concreta en la auditoría
    public void logAction(String usuario, String accion) {
        Auditoria auditoria = new Auditoria();
        auditoria.setUsuario(usuario);
        auditoria.setAccion(accion);
        auditoria.setFecha(new java.util.Date());
        auditoriaRepository.save(auditoria);
    }
}
