package com.parcial.demo.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDTO {
    private Long id;
    private String nombre;
    private String especialidad;
    private String email;
    private String telefono;
    private LocalDate fechaContratacion;
    private String status = "active";
    private Long clinicaId;
}