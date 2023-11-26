package com.medistore.MedistoreBack.models;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Entity
@Table(name="reporteProducto")

public class ReporteProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nombreProducto")
    private String nombreProducto;
    @Column(name = "lote")
    private String lote;
    @Column(name = "observaciones")
    private String observaciones;
    @Column(name = "fechaReporte")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaReporte;

}


