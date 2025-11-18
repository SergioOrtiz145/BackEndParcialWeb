package com.parcial.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parcial.demo.dto.ClinicaDTO;
import com.parcial.demo.service.ClinicaServicio;

@RestController
@RequestMapping("/api/clinica")
public class ClinicaControlador {
    @Autowired
    private ClinicaServicio clinicaServicio;

    @PostMapping()
    public ClinicaDTO crearClinica(@RequestBody ClinicaDTO dto) {
        return clinicaServicio.crearClinica(dto);
    }
    @PutMapping()
    public ClinicaDTO actualizarClinica(@RequestBody ClinicaDTO dto) {
        return clinicaServicio.actualizarClinica(dto);
    }
    @GetMapping(value = "/{id}")
    public ClinicaDTO obtenerClinicaPorId(@PathVariable Long id) {
        return clinicaServicio.obtenerClinicaDTOPorId(id);
    }
    @GetMapping()
    public List<ClinicaDTO> obtenerTodasLasClinicas() {
        return clinicaServicio.obtenerTodas();
    }
    @DeleteMapping(value = "/{id}")
    public void eliminarContrato(@PathVariable Long id) {
        clinicaServicio.eliminarClinica(id);
    }
}
