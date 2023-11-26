package com.medistore.MedistoreBack.models;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name="usuario")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "tipodoc")
    private String tipodoc;
    @Column(name = "numerodoc")
    private String numerodoc;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "correo")
    private String correo;
    @Column(name = "clave")
    private String clave;
    @Column(name = "rol")
    private String rol;
}
