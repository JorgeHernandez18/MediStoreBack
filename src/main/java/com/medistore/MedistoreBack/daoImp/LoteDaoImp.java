package com.medistore.MedistoreBack.daoImp;

import com.medistore.MedistoreBack.dao.LoteDao;
import com.medistore.MedistoreBack.models.Lote;
import com.medistore.MedistoreBack.models.Producto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
public class LoteDaoImp implements LoteDao {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Lote> getLotes() {
        String query = "FROM Lote";
        return  entityManager.createQuery(query).getResultList();
    }

    @Override
    public Lote getLote(int id) throws Exception {
        try {
            String query = "FROM Lote WHERE id = :id";
            Lote l = (Lote) entityManager.createQuery(query)
                    .setParameter("id", id)
                    .getSingleResult();
            return l;
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public Lote getLote(String nombreLote) throws Exception {
        try {
            String query = "FROM Lote WHERE nombreLote = :nombreLote";
            Lote l = (Lote) entityManager.createQuery(query)
                    .setParameter("nombreLote", nombreLote)
                    .getSingleResult();
            return l;
        }catch(NoResultException e){
            return  null;
        }
    }

    @Override
    public void createLote(Lote lote, Integer idProducto) {
        Producto p = entityManager.find(Producto.class, idProducto);
        lote.setProducto(p);
        p.getLotes().add(lote);
        entityManager.merge(p);
    }

    @Override
    public void updateLote(Lote lote, int id) {
        Lote l = entityManager.find(Lote.class, id);
        l.setNombreLote(lote.getNombreLote());
        l.setCantidad(lote.getCantidad());
        l.setFecha_vencimiento(lote.getFecha_vencimiento());
        l.setPrecio_compra_unidad(lote.getPrecio_compra_unidad());
        l.setProducto(lote.getProducto());
        entityManager.merge(l);
    }
}
