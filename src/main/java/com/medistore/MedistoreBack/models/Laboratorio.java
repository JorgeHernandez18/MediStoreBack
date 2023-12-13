package com.medistore.MedistoreBack.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

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

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "laboratorio", cascade = CascadeType.ALL)
    private Set<Producto> productos = new HashSet<>();

}
