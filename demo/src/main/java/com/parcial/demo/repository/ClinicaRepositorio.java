package com.parcial.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parcial.demo.entity.Clinica;


public interface ClinicaRepositorio extends JpaRepository<Clinica, Long> {
    
}
