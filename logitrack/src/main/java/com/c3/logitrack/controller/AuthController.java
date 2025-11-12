package com.c3.logitrack.controller;

import com.c3.logitrack.entities.Usuario;
import com.c3.logitrack.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private AuthService authService;

    // ===== LOGIN =====
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginRequest) {
        String username = loginRequest.get("username");
        String password = loginRequest.get("password");

        if(username == null || password == null) {
            Map<String, Object> error = new HashMap<>();
            error.put("message", "Username y password son obligatorios");
            return ResponseEntity.badRequest().body(error);
        }

        try {
            Usuario usuario = authService.authenticateUser(username, password);

            Map<String, Object> response = new HashMap<>();
            response.put("message", "Inicio de sesión exitoso");
            response.put("usuario", usuario.getUsername());
            response.put("rol", usuario.getRol());
            response.put("activo", usuario.isActivo());

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            Map<String, Object> error = new HashMap<>();
            error.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }

    // ===== REGISTRO =====
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String email = request.get("email");
        String password = request.get("password");

        if(username == null || password == null) {
            Map<String, Object> error = new HashMap<>();
            error.put("message", "Username y password son obligatorios");
            return ResponseEntity.badRequest().body(error);
        }

        try {
            Usuario nuevo = authService.registerUser(username, email, password);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Usuario registrado correctamente");
            response.put("id", nuevo.getId());
            response.put("username", nuevo.getUsername());
            response.put("rol", nuevo.getRol());

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            Map<String, Object> error = new HashMap<>();
            error.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }
}
