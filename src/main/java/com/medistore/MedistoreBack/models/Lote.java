package com.medistore.MedistoreBack.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Entity
@Table(name="lote")
public class Lote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nombre_lote")
    private String nombreLote;

    @Column(name = "cantidad")
    private long cantidad;

    @Column(name = "fecha_vencimiento")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha_vencimiento;

    //Multiplicar este por la cantidad***
    @Column(name = "precio_compra_unidad")
    private double precio_compra_unidad;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_producto")
    private Producto producto;

}
