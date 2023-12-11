package com.medistore.MedistoreBack.models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="producto")
@Data
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "nombreComercial")
    private String nombreComercial;
    @Column(name = "lote")
    private String lote;
    @Column(name = "fechaIngreso")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaIngreso;
    @Column(name = "fechaVencimiento")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaVencimiento;
    @Column(name = "precio")
    private float precio;
    @Column(name = "formula")
    private String formula;
    @Column(name = "dosis")
    private String dosis;
    @Column(name = "marca")
    private String marca;
    @Column(name = "disponible")
    private boolean disponible;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "producto", cascade = CascadeType.ALL)
    private Set<Lote> lotes = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    private Venta venta;

    @ManyToOne(fetch = FetchType.EAGER)
    private Pedido pedido;

    @ManyToOne(fetch = FetchType.EAGER)
    private ReporteProducto reporteProducto;



}
