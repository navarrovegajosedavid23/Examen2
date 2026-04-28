package com.upiiz.examen2.controllers;

import com.upiiz.examen2.entities.UsuarioEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.upiiz.examen2.services.UsuarioServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@RequestMapping("/auth")
@Controller
public class authController{

    @Autowired
    UsuarioServiceImpl usuarioServiceImpl;

    //Creacion de usuarios

    @GetMapping("/MostrarRegistrarUsuario")
    public String MostrarFormularioCrearUsuario(Model model)
    {
        UsuarioEntity usuario = new UsuarioEntity();
        model.addAttribute("usuario",usuario);
        return "Sesion/register";
    }

    @PostMapping("/RegistrarUsuario")
    public String RegistrarUsuario(@ModelAttribute UsuarioEntity usuario)
    {
        usuarioServiceImpl.RegistrarUsuario(usuario);
        return "redirect:/auth/MostrarInicioSesion";
    }

    //Login de usuarios

    @GetMapping("/MostrarInicioSesion")
    public String MostrarInicioSesion()
    {
        return "Sesion/login";
    }

}
