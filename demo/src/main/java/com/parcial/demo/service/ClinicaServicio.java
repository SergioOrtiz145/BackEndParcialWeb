package com.parcial.demo.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parcial.demo.dto.ClinicaDTO;
import com.parcial.demo.entity.Clinica;
import com.parcial.demo.repository.ClinicaRepositorio;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClinicaServicio {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ClinicaRepositorio clinicaRepositorio;

    public ClinicaDTO crearClinica(ClinicaDTO dto) {
        Clinica clinica = modelMapper.map(dto, Clinica.class);
        clinica.setStatus("active");

        Clinica guardada = clinicaRepositorio.save(clinica);

        return modelMapper.map(guardada, ClinicaDTO.class);
    }

    public ClinicaDTO actualizarClinica(ClinicaDTO dto) {
        Clinica clinica = clinicaRepositorio.findById(dto.getId())
                .orElseThrow(() -> new EntityNotFoundException("Clinica con id " + dto.getId() + " no encontrada"));

        clinica.setNombre(dto.getNombre());
        clinica.setDireccion(dto.getDireccion());
        clinica.setTelefono(dto.getTelefono());
        clinica.setCiudad(dto.getCiudad());
        clinica.setCantidadCamas(dto.getCantidadCamas());
        clinica.setFechaCreacion(dto.getFechaCreacion());

        Clinica actualizada = clinicaRepositorio.save(clinica);

        return modelMapper.map(actualizada, ClinicaDTO.class);
    }

    public ClinicaDTO obtenerClinicaDTOPorId(Long id) {
        Clinica clinica = clinicaRepositorio.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Clinica con id " + id + " no encontrada"));

        return modelMapper.map(clinica, ClinicaDTO.class);
    }

    public Clinica obtenerClinicaPorId(Long id) {
        Clinica clinica = clinicaRepositorio.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Clinica con id " + id + " no encontrada"));

        return clinica;
    }

    public List<ClinicaDTO> obtenerTodas() {
        List<Clinica> clinicas = clinicaRepositorio.findAll();
        return clinicas.stream()
                .map(clinica -> modelMapper.map(clinica, ClinicaDTO.class))
                .toList();
    }

    public void eliminarClinica(Long id) {
        Clinica clinica = clinicaRepositorio.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Clinica con id " + id + " no encontrada"));

        clinica.setStatus("inactive");
        clinicaRepositorio.save(clinica);
    }
}
