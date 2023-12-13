package com.medistore.MedistoreBack.dao;

import com.medistore.MedistoreBack.models.Factura;
import com.medistore.MedistoreBack.models.Lote;

import java.util.List;

public interface FacturaDao {

    List<Factura> getFacturas();

    Factura getFactura(int id) throws Exception;

    Lote getLote(String nombreLote) throws  Exception;

    void createLote(Lote lote, Integer idProducto);

    void updateLote(Lote lote, int id);
}
