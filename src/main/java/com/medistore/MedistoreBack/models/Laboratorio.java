package com.medistore.MedistoreBack.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Laboratorio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nombreLaboratorio")
    private String nombreLaboratorio;

}
