package com.medistore.MedistoreBack.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="proveedor")
@Data
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "tipoDocumento")
    private String tipoDocumento;
    @Column(name = "numeroDocumento")
    private String numeroDocumento;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "ciudad")
    private String ciudad;
}
