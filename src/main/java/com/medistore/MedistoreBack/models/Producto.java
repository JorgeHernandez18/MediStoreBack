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
@Table(name="producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "nombre")
    private String nombre;
    //Fecha automatica del sistema, no se puede editar
    @Column(name = "fecha_creacion")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha_creacion;
    @Column(name = "unidad")
    private String unidad;
    @Column(name = "concentracion")
    private String concentracion;
    @Column(name = "registro_invima")
    private  String registro_invima;
    @Column(name = "principio_activo")
    private String principio_activo;
    @Column(name = "nombre_comercial")
    private String nombre_comercial;
    @Column(name = "presentacion_comercial")
    private String presentacion_comercial;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "producto", cascade ={ CascadeType.PERSIST, CascadeType.REMOVE})
    private Set<Lote> lotes = new HashSet<>();

    @OneToMany(mappedBy = "producto")
    private Set<Venta_Producto> venta_producto;

    @ManyToOne(fetch = FetchType.EAGER)
    private Laboratorio laboratorio;

    @ManyToOne(fetch = FetchType.EAGER)
    private Pedido pedido;

    @ManyToOne(fetch = FetchType.EAGER)
    private ReporteProducto reporteProducto;

    @ManyToMany(mappedBy = "productos")
    private Set<Factura> facturas = new HashSet<>();

    private long obtenerCantidadProducto(Lote lote){
        for(Lote l : lotes){
            if(l.getNombreLote() == lote.getNombreLote()){
                return l.getCantidad();
            }
        }
        return -1;
    }
}
