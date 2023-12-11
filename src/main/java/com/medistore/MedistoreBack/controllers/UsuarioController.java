package com.medistore.MedistoreBack.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.medistore.MedistoreBack.dao.UsuarioDao;
import com.medistore.MedistoreBack.models.Usuario;


@RestController
//Cambiar la ruta a administrador
@RequestMapping("usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioDao usuarioDao;

    @RequestMapping(value = "api/usuarios", method = RequestMethod.GET)
    public ResponseEntity<List<Usuario>> getUsuarios() {
        return ResponseEntity.ok(usuarioDao.getUsuarios());
    }

    @RequestMapping(value = "api/usuario", method = RequestMethod.POST)
    public void createUsuario(@RequestBody Usuario usuario) throws Exception {
        Usuario u = usuarioDao.getUsuario(usuario.getCorreo());
        if (u != null) {
            throw new ErrorResponseException(HttpStatusCode.valueOf(400), new Exception("Usuario existente"));
        } else {
            usuarioDao.createUsuario(usuario);
        }
    }

    @RequestMapping(value = "api/usuario/{id}", method = RequestMethod.PUT)
    public void updateUsuario(@RequestBody Usuario usuario, @PathVariable int id  ) throws Exception {
        Usuario u = usuarioDao.getUsuario(id);
        if(u == null){
            throw new ErrorResponseException(HttpStatusCode.valueOf(404), new Exception("Usuario no existe"));
        }else {
            usuarioDao.updateUsuario(usuario, id);
        }
        //Validar que al cambiar el correo no esté en otra cuenta
    }
}