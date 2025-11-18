package com.parcial.demo.entity;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@SQLDelete(sql = "UPDATE clinica SET status = 'inactive' WHERE id = ?")
public class Clinica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String direccion;
    private int cantidadCamas;
    private String telefono;
    private String ciudad;
    private LocalDate fechaCreacion;
    private String status = "active";  
    
    @OneToMany(mappedBy = "clinica")
    private List<Doctor> doctores;   
}
