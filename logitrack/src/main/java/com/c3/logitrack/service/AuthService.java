package com.c3.logitrack.service;

import com.c3.logitrack.entities.Usuario;
import com.c3.logitrack.exception.BadRequestException;
import com.c3.logitrack.exception.ResourceNotFoundException;
import com.c3.logitrack.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;  // Asegúrate de configurar un bean de PasswordEncoder

    public Usuario registerUser(String username, String email, String rawPassword) {
        // Revisar si el username ya existe
        if (usuarioRepository.findByUsername(username).isPresent()) {
            throw new BadRequestException("El nombre de usuario ya está en uso");
        }
        // Crear nuevo usuario y cifrar contraseña
        Usuario usuario = new Usuario();
        usuario.setUsername(username);
        usuario.setEmail(email);
        usuario.setPassword(passwordEncoder.encode(rawPassword));

        return usuarioRepository.save(usuario);
    }

    public Usuario authenticateUser(String username, String rawPassword) {
        Usuario usuario = usuarioRepository.findByUsername(username)
            .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con username: " + username));

        if (!passwordEncoder.matches(rawPassword, usuario.getPassword())) {
            throw new BadRequestException("Credenciales inválidas");
        }
        return usuario;
    }

    // Aquí podrías agregar métodos para generar tokens JWT u otros mecanismos de autenticación
}