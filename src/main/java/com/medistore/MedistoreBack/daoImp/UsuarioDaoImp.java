package com.medistore.MedistoreBack.daoImp;

import java.util.List;

import com.medistore.MedistoreBack.dao.UsuarioDao;
import com.medistore.MedistoreBack.models.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao{

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public List<Usuario> getUsuarios() {
        String query = "FROM Usuario";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Usuario getUsuario(String correo) throws Exception {
        try {
            String query = "FROM Usuario WHERE correo = :correo";
            Usuario u = (Usuario) entityManager.createQuery(query)
                    .setParameter("correo", correo)
                    .getSingleResult();
            return u;
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public Usuario getUsuario(int id) throws Exception {
        try {
            String query = "FROM Usuario WHERE id = :id";
            Usuario u = (Usuario) entityManager.createQuery(query)
                    .setParameter("id", id)
                    .getSingleResult();
            return u;
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public void createUsuario(Usuario usuario) {
        entityManager.merge(usuario);
    }

    @Override
    public void updateUsuario(Usuario usuario, int id) {
        Usuario u = entityManager.find(Usuario.class, id);
        u.setNombre(usuario.getNombre());
        u.setApellido(usuario.getApellido());
        u.setTipodoc(usuario.getTipodoc());
        u.setNumerodoc(usuario.getNumerodoc());
        u.setTelefono(usuario.getTelefono()); 
        u.setCorreo(usuario.getCorreo());
        u.setClave(usuario.getClave());
        //No se edita el rol del usuario porque auxiliar no puede ser admin

        entityManager.merge(u);
    }

    @Override
    public Usuario obtenerUsuarioPorCredenciales(Usuario usuario) {
        String query = "FROM Usuario WHERE correo = :correo";
        Usuario usuarioAuth = (Usuario) entityManager.createQuery(query)
        .setParameter("correo", usuario.getCorreo())
        .getSingleResult();

        if(usuario != null){
            if(usuarioAuth.getClave().contentEquals(usuario.getClave()) &&
                usuarioAuth.getRol().contentEquals(usuario.getRol())
            ){
                return usuarioAuth;
            }
        }
        return null;
    }

    @Override
    public void deleteUsuario(int id) {
        Usuario u = entityManager.find(Usuario.class, id);
        entityManager.remove(u);
    }

}
