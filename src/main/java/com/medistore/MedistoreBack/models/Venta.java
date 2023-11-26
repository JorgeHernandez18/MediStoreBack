package com.medistore.MedistoreBack.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name ="venta")

public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name= "producto")
    private String producto;
    @Column(name= "cantidad")
    private String cantidad;
    @Column(name= "lote")
    private String lote;
    @Column(name= "costo")
    private float costo;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch =  FetchType.EAGER, mappedBy = "venta")
    private Set<Producto> Productos = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario usuario;
}
