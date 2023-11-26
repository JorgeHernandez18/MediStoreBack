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
@Table(name="pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "productos")
    private String productos;
    @Column (name = "total")
    private float total;


    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch =  FetchType.EAGER, mappedBy = "pedido")
    private Set<Producto> Producto = new HashSet<>();

}
