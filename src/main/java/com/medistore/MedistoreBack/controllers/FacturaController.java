package com.medistore.MedistoreBack.controllers;

import com.medistore.MedistoreBack.dao.FacturaDao;
import com.medistore.MedistoreBack.models.Factura;
import com.medistore.MedistoreBack.models.Producto;
import com.medistore.MedistoreBack.util.ContainerFactura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "factura")
public class FacturaController {

    @Autowired
    private FacturaDao facturaDao;

    @RequestMapping(value = "api/facturas", method = RequestMethod.GET)
    public ResponseEntity<List<Factura>> getFacturas() {
        return ResponseEntity.ok(facturaDao.getFacturas());
    }

    @RequestMapping(value = "api/factura", method = RequestMethod.POST)
    public ResponseEntity<String> createFactura(@RequestBody ContainerFactura containerFactura) throws Exception {
        Factura factura = containerFactura.getFactura();
        Factura f = facturaDao.getFacturaPorNumDeposito(factura.getNumero_factura());

        if (f != null) {
            return ResponseEntity.internalServerError().body("Factura ya existe, " +
                    "no puede ser creado nuevamente");
        }
        Set<Producto> productos = containerFactura.getProductos();
        facturaDao.createFactura(factura, productos);
        return ResponseEntity.ok("Factura creada con exito");
    }

    @RequestMapping(value = "api/factura/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Factura> updateFactura(@RequestBody Factura factura, @PathVariable int id) throws Exception {
        Factura f = facturaDao.getFactura(id);
        if (f == null){
            return ResponseEntity.status(404).body(null);
        }
        facturaDao.updateFactura(factura, id);
        return ResponseEntity.ok(factura);
    }

}
