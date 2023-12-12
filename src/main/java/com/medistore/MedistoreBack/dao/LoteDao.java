package com.medistore.MedistoreBack.dao;

import com.medistore.MedistoreBack.models.Lote;
import com.medistore.MedistoreBack.models.Producto;

import java.util.List;

public interface LoteDao {

    List<Lote> getLotes();

    Lote getLote(int id) throws Exception;

    Lote getLote(String nombreLote) throws  Exception;

    void createLote(Lote lote, Integer idProducto);

    void updateLote(Lote lote, int id);
}
