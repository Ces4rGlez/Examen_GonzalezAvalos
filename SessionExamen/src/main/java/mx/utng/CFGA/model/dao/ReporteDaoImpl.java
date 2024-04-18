package mx.utng.CFGA.model.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import mx.utng.CFGA.model.entity.Reporte;


@Repository
public class ReporteDaoImpl implements IReporteDao{
     //Entity Manager y contexto de persistencia
    //Guarda internamente todas las entidads y
    //utiliza como una cache datos de BD
    //@PersistenceContext
    @Autowired
    private EntityManager em;


    @SuppressWarnings("unchecked")
    @Override
    public List<Reporte> list() {
        return em.createQuery("from Teacher").getResultList();
    }

    @Override
    public void save(Reporte teacher) {
        if(teacher.getId() != null && teacher.getId() >0){
            em.merge(teacher);
        }else{
            em.persist(teacher);
        }
    }

    @Override
    public Reporte getById(Long id) {
        return em.find(Reporte.class, id);
    }

    @Override
    public void delete(Long id) {
        Reporte teacher = getById(id);
        em.remove(teacher);
    }

    
}
