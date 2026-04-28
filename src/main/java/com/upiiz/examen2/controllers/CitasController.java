package com.upiiz.examen2.controllers;

import com.upiiz.examen2.entities.CitasEntity;
import com.upiiz.examen2.services.CitasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/citas")
public class CitasController {

    @Autowired
    private CitasService citasService;

    @GetMapping
    public String listarCitas(Model model) {
        model.addAttribute("citas", citasService.listarCitas());
        return "TablasFormularios/TablasCita";
    }

    @GetMapping("/nueva")
    public String formularioNuevaCita(Model model) {
        model.addAttribute("cita", new CitasEntity());
        return "TablasFormularios/FormularioCrearCita";
    }

    @PostMapping("/guardar")
    public String guardarCita(@ModelAttribute("cita") CitasEntity cita) {
        citasService.crearCita(cita);
        return "redirect:/citas";
    }

    @GetMapping("/editar/{id}")
    public String formularioEditarCita(@PathVariable Long id, Model model) {
        CitasEntity cita = citasService.getCitaPorId(id).orElse(null);
        model.addAttribute("cita", cita);
        return "TablasFormularios/FormularioActualizarCita";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarCita(@PathVariable Long id, @ModelAttribute("cita") CitasEntity cita) {
        cita.setIdCita(id);
        citasService.actualizarCita(cita);
        return "redirect:/citas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCita(@PathVariable Long id) {
        citasService.eliminarCita(id);
        return "redirect:/citas";
    }

    @GetMapping("/ver/{id}")
    public String verDetalle(@PathVariable Long id, Model model) {
        CitasEntity cita = citasService.getCitaPorId(id).orElse(null);
        model.addAttribute("cita", cita);
        return "TablasFormularios/TablasFactura";
    }
}