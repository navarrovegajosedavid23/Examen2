package com.upiiz.examen2.controllers;

import com.upiiz.examen2.services.UsuarioServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/sendEmail")

public class EmailController {

    private final UsuarioServiceImpl usuarioServiceImpl;

    EmailController(UsuarioServiceImpl usuarioServiceImpl) {
        this.usuarioServiceImpl = usuarioServiceImpl;
    }

        @PostMapping("/RecuperarContrasenia")
        public String recuperarContrasenia (@RequestParam String username)
        {                
            try {
                usuarioServiceImpl.RecuperarContrasenia(username);
                return "redirect:/auth/MostrarInicioSesion";
            } catch (Exception e) {
                return "Error al enviar el correo: " + e.getMessage();
            }

        }

    
}
