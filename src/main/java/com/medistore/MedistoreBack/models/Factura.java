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
@Table(name = "factura")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Numero de la factura creada será incremental
    private int id;

    @Column(name = "fecha_factura")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    //La que expide el deposito, debe ingresarse manualmente
    private Date fecha_factura;

    @Column(name = "fecha_facturacion")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    //Automatica, del sistema, no se puede modificar
    private Date fecha_facturacion;

    @Column(name = "numero_factura")
    //Es el numero que expide el deposito
    private String numero_factura;

    //@ToString.Exclude
    //@EqualsAndHashCode.Exclude
    //@JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "factura_producto", joinColumns = @JoinColumn(name = "factura_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "producto_id", referencedColumnName = "id")
    )
    private Set<Producto> productos = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "id_proveedor")
    private Proveedor proveedor;
}
