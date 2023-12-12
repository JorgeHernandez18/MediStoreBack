package com.medistore.MedistoreBack.daoImp;

import java.util.List;

import com.medistore.MedistoreBack.models.Lote;
import com.medistore.MedistoreBack.models.Producto;
import com.medistore.MedistoreBack.dao.ProductoDao;

import com.medistore.MedistoreBack.models.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ProductoDaoImp implements ProductoDao{

    @PersistenceContext
    private  EntityManager entityManager;
    @Override
    public List<Producto> getProductos() {
        String query = "FROM Producto";
        return  entityManager.createQuery(query).getResultList();
    }

    @Override
    public Producto getProducto(int id) throws Exception {
        try {
            String query = "FROM Producto WHERE id = :id";
            Producto p = (Producto) entityManager.createQuery(query)
                    .setParameter("id", id)
                    .getSingleResult();
            return p;
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public Producto getProducto(String nombreComercial) throws Exception {
        try {
            String query = "FROM Producto WHERE nombre_comercial = :nombreComercial";
            Producto p = (Producto) entityManager.createQuery(query)
                    .setParameter("nombreComercial", nombreComercial)
                    .getSingleResult();
            return p;
    }catch(NoResultException e){
        return  null;
        }
    }

    @Override
    public void createProducto(Producto producto) {
        entityManager.merge(producto);
    }

    @Override
    public void updateProducto(Producto producto, int id) {
        Producto p = entityManager.find(Producto.class, id);
        p.setNombre(producto.getNombre());
        p.setFecha_creacion(producto.getFecha_creacion());
        p.setUnidad(producto.getUnidad());
        p.setPrecio(producto.getPrecio());
        p.setConcentracion(producto.getConcentracion());
        p.setRegistro_invima(producto.getRegistro_invima());
        p.setPrincipio_activo(producto.getPrincipio_activo());
        p.setNombre_comercial(producto.getNombre_comercial());
        p.setPresentacion_comercial(producto.getPresentacion_comercial());
        entityManager.merge(p);
    }

    @Override
    public void deleteProducto(Producto producto) {
        entityManager.remove(producto);
    }

}
