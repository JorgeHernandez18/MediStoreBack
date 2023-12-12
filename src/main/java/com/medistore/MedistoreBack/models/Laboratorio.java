package com.medistore.MedistoreBack.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "laboratorio")
public class Laboratorio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nombre_laboratorio")
    private String nombre_laboratorio;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "laboratorio", cascade = CascadeType.ALL)
    private Set<Producto> productos = new HashSet<>();

}
