package com.c3.logitrack.service;

import com.c3.logitrack.entities.Usuario;
import com.c3.logitrack.exception.BadRequestException;
import com.c3.logitrack.exception.ResourceNotFoundException;
import com.c3.logitrack.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // ===== Registro =====
    public Usuario registerUser(String username, String email, String password) {
        if(usuarioRepository.findByUsername(username).isPresent()) {
            throw new BadRequestException("El nombre de usuario ya está en uso");
        }
        
        Usuario usuario = new Usuario();
        usuario.setUsername(username);
        usuario.setEmail(email);
        usuario.setPassword(password); // Sin encriptar (solo para pruebas rápidas)
        usuario.setRol(com.c3.logitrack.entities.enums.RolUsuario.USER);
        usuario.setActivo(true);

        return usuarioRepository.save(usuario);
    }

    

    // ===== Login =====
    public Usuario authenticateUser(String username, String password) {
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

        if(!usuario.getPassword().equals(password)) {
            throw new BadRequestException("Credenciales inválidas");
        }

        if(!usuario.isActivo()) {
            throw new BadRequestException("Usuario inactivo");
        }

        return usuario;
    }
}
