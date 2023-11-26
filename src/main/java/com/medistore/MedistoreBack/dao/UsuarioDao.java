package com.medistore.MedistoreBack.dao;

import java.util.List;

import com.medistore.MedistoreBack.models.Usuario;

public interface UsuarioDao {

    List<Usuario> getUsuarios();

    Usuario getUsuario(String correo) throws Exception;

    Usuario getUsuario(int id) throws Exception;

    void createUsuario(Usuario usuario);

    void updateUsuario(Usuario usuario, int id);

    Usuario obtenerUsuarioPorCredenciales(Usuario usuario);

}
