package com.medistore.MedistoreBack.controllers;

import com.medistore.MedistoreBack.dao.LoteDao;
import com.medistore.MedistoreBack.models.Lote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "lote")
public class LoteController {

    @Autowired
    private LoteDao loteDao;

    @RequestMapping(value = "api/lotes", method = RequestMethod.GET)
    public ResponseEntity<List<Lote>> getLotes(){return ResponseEntity.ok(loteDao.getLotes());}

    @RequestMapping(value = "api/lote/{idProducto}", method = RequestMethod.POST)
    public ResponseEntity<String> createLote(@RequestBody Lote lote, @PathVariable Integer idProducto) throws Exception {
        Lote l = loteDao.getLote(lote.getNombreLote());

        if(l != null){
            return ResponseEntity.internalServerError().body("Lote ya existe, " +
                    "no puede ser creado nuevamente");
        }

        loteDao.createLote(lote, idProducto);
        return ResponseEntity.ok("Lote creado con exito!");
    }

    @RequestMapping(value = "api/lote/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Lote> updateLote(@RequestBody Lote lote, @PathVariable int id) throws Exception {
        Lote l = loteDao.getLote(id);
        if (l == null){
            return ResponseEntity.status(404).body(null);
        }
        loteDao.updateLote(lote, id);
        return ResponseEntity.ok(lote);
    }


}
