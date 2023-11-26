package com.medistore.MedistoreBack.dao;

import java.util.List;

import com.medistore.MedistoreBack.models.Producto;
public interface ProductoDao{

    List<Producto> getProductos();

    Producto getProducto(int id) throws Exception;

    Producto getProducto(String nombreComercial) throws  Exception;

    void createProducto(Producto producto);

    void updateProducto(Producto producto, int id);



}
