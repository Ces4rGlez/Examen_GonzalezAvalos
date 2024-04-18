package mx.utng.CFGA.model.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import mx.utng.CFGA.model.entity.Producto;



@Repository
public class ProductoDaoImpl implements IProductoDao{
     //Entity Manager y contexto de persistencia
    //Guarda internamente todas las entidads y
    //utiliza como una cache datos de BD
    //@PersistenceContext
    @Autowired
    private EntityManager em;


    @SuppressWarnings("unchecked")
    @Override
    public List<Producto> list() {
        return em.createQuery("from Producto").getResultList();
    }

    @Override
    public void save(Producto producto) {
        if(producto.getId() != null && producto.getId() >0){
            em.merge(producto);
        }else{
            em.persist(producto);
        }
    }

    @Override
    public Producto getById(Long id) {
        return em.find(Producto.class, id);
    }

    @Override
    public void delete(Long id) {
        Producto producto = getById(id);
        em.remove(producto);
    }

    
}
