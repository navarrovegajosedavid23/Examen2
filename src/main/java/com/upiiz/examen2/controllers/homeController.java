package com.upiiz.examen2.controllers;

import com.upiiz.examen2.services.FacturasService;
import com.upiiz.examen2.services.CitasService;
import com.upiiz.examen2.services.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class homeController {

    @Autowired
    private FacturasService facturasService;

    @Autowired
    private CitasService citasService;

    @Autowired
    private ProductosService productosService;

    @GetMapping("/MostrarInicio")
    public String inicio(Model model) {
        // 1. Obtenemos el correo del usuario logueado
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("usuarioLogueado", username);

        // 2. CONTAMOS los registros reales de la base de datos
        int totalFacturas = facturasService.listarFacturas().size();
        int totalCitas = citasService.listarCitas().size();
        int totalProductos = productosService.listarProductos().size();

        // 3. MANDAMOS los números al HTML
        model.addAttribute("totalFacturas", totalFacturas);
        model.addAttribute("totalCitas", totalCitas);
        model.addAttribute("totalProductos", totalProductos);

        return "index"; // O el nombre que tenga tu archivo (index.html)
    }
}