package com.medistore.MedistoreBack.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch =  FetchType.EAGER, mappedBy = "reporteProducto")
    private Set<Producto> Producto = new HashSet<>();

}


