package com.upiiz.examen2.controllers;

import com.upiiz.examen2.entities.FacturasEntity;
import com.upiiz.examen2.services.FacturasService;
import com.upiiz.examen2.services.CitasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/facturas")
public class FacturasController {

    @Autowired
    private FacturasService facturasService;

    @Autowired
    private CitasService citasService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("facturas", facturasService.listarFacturas());
        return "TablasFormularios/TablasFactura";
    }

    @GetMapping("/nueva")
    public String formularioNueva(Model model) {
        model.addAttribute("factura", new FacturasEntity());
        model.addAttribute("citas", citasService.listarCitas());
        return "TablasFormularios/FormularioCrearFacturas";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("factura") FacturasEntity factura) {
        facturasService.crearFactura(factura);
        return "redirect:/facturas";
    }

    @GetMapping("/editar/{id}")
    public String formularioEditar(@PathVariable Long id, Model model) {
        FacturasEntity factura = facturasService.obtenerFacturaPorId(id).orElse(null);
        model.addAttribute("factura", factura);
        return "TablasFormularios/FormulariosActualizarFactura";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizar(@PathVariable Long id, @ModelAttribute("factura") FacturasEntity factura) {
        factura.setIdFactura(id);
        facturasService.crearFactura(factura);
        return "redirect:/facturas";
    }

    @GetMapping("/mostrar/{id}")
    public String mostrarFactura(@PathVariable Long id, Model model) {
        FacturasEntity factura = facturasService.obtenerFacturaPorId(id).orElse(null);
        model.addAttribute("factura", factura);
        return "TablasFormularios/MostrarFacturas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        facturasService.eliminarFactura(id);
        return "redirect:/facturas";
    }
}