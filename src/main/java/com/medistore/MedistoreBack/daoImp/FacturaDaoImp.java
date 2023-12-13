package com.medistore.MedistoreBack.daoImp;

import com.medistore.MedistoreBack.dao.FacturaDao;
import com.medistore.MedistoreBack.models.Factura;
import com.medistore.MedistoreBack.models.Producto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
@Repository
@Transactional
public class FacturaDaoImp implements FacturaDao {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Factura> getFacturas() {
        String query = "FROM Factura";
        return  entityManager.createQuery(query).getResultList();
    }

    @Override
    public Factura getFactura(int id) throws Exception {
        try {
            String query = "FROM Factura WHERE id = :id";
            Factura f = (Factura) entityManager.createQuery(query)
                    .setParameter("id", id)
                    .getSingleResult();
            return f;
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public Factura getFacturaPorNumDeposito(String numeroFacturaDeposito) throws Exception {
        try {
            String query = "FROM Factura WHERE numero_factura = :numeroFacturaDeposito";
            Factura f = (Factura) entityManager.createQuery(query)
                    .setParameter("numeroFacturaDeposito", numeroFacturaDeposito)
                    .getSingleResult();
            return f;
        }catch(NoResultException e){
            return  null;
        }
    }

    @Override
    public void createFactura(Factura factura, Set<Producto> productos) {
        factura.setProductos(productos);
        entityManager.merge(factura);
    }

    @Override
    public void updateFactura(Factura factura, int id) {
        Factura f = entityManager.find(Factura.class, id);
        f.setFecha_factura(factura.getFecha_factura());
        f.setNumero_factura(factura.getNumero_factura());
        f.setProveedor(factura.getProveedor());
        f.setProductos(factura.getProductos());
    }

    @Override
    public void deleteFactura(int id) {
        Factura f = entityManager.find(Factura.class, id);
        entityManager.remove(f);
    }
}
