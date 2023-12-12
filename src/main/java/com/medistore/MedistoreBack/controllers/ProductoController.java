package com.medistore.MedistoreBack.controllers;

import com.medistore.MedistoreBack.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.medistore.MedistoreBack.dao.ProductoDao;
import com.medistore.MedistoreBack.models.Producto;

@RestController
@RequestMapping("producto")
public class ProductoController {

    @Autowired
    private ProductoDao productoDao;

    @RequestMapping(value = "api/productos", method = RequestMethod.GET)
    public ResponseEntity<List<Producto>> getProductos() {
        return ResponseEntity.ok(productoDao.getProductos());
    }

    @RequestMapping(value = "api/producto", method = RequestMethod.POST)
    public void createProducto(@RequestBody Producto producto) throws Exception {
        Producto p = productoDao.getProducto(producto.getNombre_comercial());
        if (p != null) {
            throw new ErrorResponseException(HttpStatusCode.valueOf(400), new Exception("Producto existente"));
        } else {
            productoDao.createProducto(producto);
        }
    }

    @RequestMapping(value = "api/producto/{id}", method = RequestMethod.PUT)
    public void updateProducto(@RequestBody Producto producto, @PathVariable int id) throws Exception {
        Producto p = productoDao.getProducto(id);
        if (p == null) {
            throw new ErrorResponseException(HttpStatusCode.valueOf(404), new Exception("Producto no existe"));
        } else {
            productoDao.updateProducto(producto, id);
        }
    }

    @RequestMapping(value = "api/producto/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteProducto(@PathVariable int id) throws Exception{
        Producto p = productoDao.getProducto(id);

        if(p == null){
            return ResponseEntity.status(404).body("Producto no existente, no se puede eliminar!");
        }
            productoDao.deleteProducto(p);
            return ResponseEntity.ok("Producto eliminado con exito!");
    }

}
