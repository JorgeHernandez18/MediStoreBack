package com.medistore.MedistoreBack.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;
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

    @Column(name = "fecha_venta")
    private Date fecha_venta;

    //@ToString.Exclude
    //@EqualsAndHashCode.Exclude
    //@JsonIgnore
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "venta")
    private Set<Venta_Producto> venta_productos = new HashSet<>();

    @OneToOne(mappedBy = "venta")
    private Detalle_Venta detalle_venta;


    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario usuario;
}
