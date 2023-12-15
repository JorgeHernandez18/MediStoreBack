package com.medistore.MedistoreBack.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "detalle_venta")
public class Detalle_Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;



    @OneToOne
    @JoinColumn(name = "venta_id")
    private Venta venta;
}
