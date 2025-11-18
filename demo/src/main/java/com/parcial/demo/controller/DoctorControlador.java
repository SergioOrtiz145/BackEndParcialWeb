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

import com.parcial.demo.dto.DoctorDTO;
import com.parcial.demo.service.DoctorServicio;

@RestController
@RequestMapping("/api/doctor")
public class DoctorControlador {
    
    @Autowired
    private DoctorServicio doctorServicio;

    @PostMapping()
    public DoctorDTO crearDoctor(@RequestBody DoctorDTO dto) {
        return doctorServicio.crearDoctor(dto);
    }
    @PutMapping()
    public DoctorDTO actualizarDoctor(@RequestBody DoctorDTO dto) {
        return doctorServicio.actualizarDoctor(dto);
    }
    @GetMapping(value = "/{id}")
    public DoctorDTO obtenerDoctorPorId(@PathVariable Long id) {
        return doctorServicio.obtenerDoctorPorId(id);
    }
    @GetMapping()
    public List<DoctorDTO> obtenerTodasLosDoctores() {
        return doctorServicio.obtenerTodos();
    }
    @DeleteMapping(value = "/{id}")
    public void eliminarEntidad(@PathVariable Long id) {
        doctorServicio.eliminarDoctor(id);
    }
}
