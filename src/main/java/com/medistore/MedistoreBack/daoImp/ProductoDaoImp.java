package com.medistore.MedistoreBack.daoImp;

import java.util.List;

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
            String query = "FROM Producto WHERE nombreComercial = :nombreComercial";
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
        p.setNombreComercial(producto.getNombreComercial());
        p.setLote(producto.getLote());
        p.setFechaIngreso(producto.getFechaIngreso());
        p.setFechaVencimiento(producto.getFechaVencimiento());
        p.setPrecio(producto.getPrecio());
        p.setFormula(producto.getFormula());
        p.setDosis(producto.getDosis());
        p.setMarca(producto.getMarca());
        p.setDisponible(producto.isDisponible());
    }
}
