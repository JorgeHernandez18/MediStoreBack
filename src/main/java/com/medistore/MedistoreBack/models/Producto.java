package com.medistore.MedistoreBack.models;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name="producto")


public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;



}
