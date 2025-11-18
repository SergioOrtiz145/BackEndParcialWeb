package com.parcial.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parcial.demo.dto.DoctorDTO;
import com.parcial.demo.entity.Clinica;
import com.parcial.demo.entity.Doctor;
import com.parcial.demo.repository.DoctorRepositorio;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DoctorServicio {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private DoctorRepositorio doctorRepositorio;

    @Autowired
    private ClinicaServicio clinicaServicio;


    public DoctorDTO crearDoctor(DoctorDTO dto) {

        Clinica clinica = clinicaServicio.obtenerClinicaPorId(dto.getClinicaId());

        Doctor doctor = modelMapper.map(dto, Doctor.class);
        doctor.setClinica(clinica);
        doctor.setStatus("active");

        Doctor guardado = doctorRepositorio.save(doctor);

        return modelMapper.map(guardado, DoctorDTO.class);
    }

    public DoctorDTO actualizarDoctor(DoctorDTO dto) {

        Doctor doctor = doctorRepositorio.findById(dto.getId())
                .orElseThrow(() -> new EntityNotFoundException("Doctor no encontrado"));

        Clinica clinica = clinicaServicio.obtenerClinicaPorId(dto.getClinicaId());

        doctor.setNombre(dto.getNombre());
        doctor.setEmail(dto.getEmail());
        doctor.setTelefono(dto.getTelefono());
        doctor.setEspecialidad(dto.getEspecialidad());
        doctor.setFechaContratacion(dto.getFechaContratacion());
        doctor.setClinica(clinica);

        Doctor actualizado = doctorRepositorio.save(doctor);

        return modelMapper.map(actualizado, DoctorDTO.class);
    }

    public DoctorDTO obtenerDoctorPorId(Long id) {
        Doctor doctor = doctorRepositorio.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Doctor no encontrado"));

        return modelMapper.map(doctor, DoctorDTO.class);
    }

    public List<DoctorDTO> obtenerTodos() {
        return doctorRepositorio.findAll()
                .stream()
                .map(d -> modelMapper.map(d, DoctorDTO.class))
                .collect(Collectors.toList());
    }

    public void eliminarDoctor(Long id) {
        Doctor doctor = doctorRepositorio.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Doctor no encontrado"));

        doctor.setStatus("inactive");
        doctorRepositorio.save(doctor);
    }
}
