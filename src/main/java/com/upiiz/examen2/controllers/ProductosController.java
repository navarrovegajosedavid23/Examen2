package com.upiiz.examen2.controllers;

import com.upiiz.examen2.entities.ProductosEntity;
import com.upiiz.examen2.services.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/productos")
public class ProductosController {

    @Autowired
    private ProductosService productosService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("productos", productosService.listarProductos());
        return "TablasFormularios/TablasProductos";
    }

    @GetMapping("/nuevo")
    public String formularioNuevo(Model model) {
        model.addAttribute("producto", new ProductosEntity());
        return "TablasFormularios/FormularioCrearProductos";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("producto") ProductosEntity producto) {
        productosService.crearProducto(producto);
        return "redirect:/productos";
    }

    @GetMapping("/editar/{id}")
    public String formularioEditar(@PathVariable Long id, Model model) {
        ProductosEntity producto = productosService.getProductoPorId(id).orElse(null);
        model.addAttribute("producto", producto);
        return "TablasFormularios/FormularioActualizarProductos";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizar(@PathVariable Long id, @ModelAttribute("producto") ProductosEntity producto) {
        producto.setIdProducto(id);
        productosService.actualizarProducto(producto);
        return "redirect:/productos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        productosService.eliminarProducto(id);
        return "redirect:/productos";
    }
}