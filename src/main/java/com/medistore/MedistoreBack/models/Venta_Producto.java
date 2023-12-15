package com.medistore.MedistoreBack.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Venta_Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int venta_producto_id;

    private double cantidad_producto;

    @ManyToOne(fetch = FetchType.EAGER)
    private Venta venta;

    @ManyToOne(fetch = FetchType.EAGER)
    private Producto producto;

}
