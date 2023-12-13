package com.medistore.MedistoreBack.util;

import com.medistore.MedistoreBack.models.Factura;
import com.medistore.MedistoreBack.models.Producto;
import lombok.Data;

import java.util.Set;
@Data
public class ContainerFactura {
    private Factura factura;
    private Set<Producto> productos;
}
