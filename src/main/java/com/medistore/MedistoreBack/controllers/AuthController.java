package com.medistore.MedistoreBack.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.medistore.MedistoreBack.dao.UsuarioDao;
import com.medistore.MedistoreBack.models.Usuario;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private UsuarioDao usuarioDao;
    
    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public ResponseEntity<Boolean> login(@RequestBody Usuario usuario) throws Exception{
        Usuario usuarioLog = usuarioDao.obtenerUsuarioPorCredenciales(usuario);
        if(usuarioLog != null) {
            return ResponseEntity.ok(true);
        }
        throw new ErrorResponseException(HttpStatusCode.valueOf(400), new Exception("Usuario o contraseña incorrectos"));
    }

}
