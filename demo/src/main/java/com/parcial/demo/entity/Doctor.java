package com.parcial.demo.entity;

import java.time.LocalDate;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@SuppressWarnings("deprecation")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Where(clause = "status = 'active'")
@SQLDelete(sql = "UPDATE doctor SET status = 'inactive' WHERE id = ?")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String especialidad;
    private String email;
    private String telefono;
    private LocalDate fechaContratacion;
    private String status = "active";
    
    @ManyToOne
    @JoinColumn(name = "clinica_id")
    private Clinica clinica;
}
