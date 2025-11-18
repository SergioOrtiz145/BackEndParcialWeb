package com.parcial.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parcial.demo.entity.Doctor;

public interface DoctorRepositorio extends JpaRepository<Doctor, Long> {
    
}
