package com.medistore.MedistoreBack.dao;

import com.medistore.MedistoreBack.models.Factura;
import com.medistore.MedistoreBack.models.Lote;
import com.medistore.MedistoreBack.models.Producto;

import java.util.List;
import java.util.Set;

public interface FacturaDao {

    List<Factura> getFacturas();

    Factura getFactura(int id) throws Exception;

    Factura getFacturaPorNumDeposito(String numeroFacturaDeposito) throws  Exception;

    void createFactura(Factura factura, Set<Producto> productos);

    void updateFactura(Factura factura, int id);

    void deleteFactura(int id);
}
