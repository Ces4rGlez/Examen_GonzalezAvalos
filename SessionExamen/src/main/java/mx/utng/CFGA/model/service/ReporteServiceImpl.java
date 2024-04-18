package mx.utng.CFGA.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.CFGA.model.dao.IReporteDao;
import mx.utng.CFGA.model.entity.Reporte;

/*
 * Una clase service, esta basada en el patrón de diseño fachada
 * Es un único punto de acceso hacia los DAOs. Dentro de la clase
 * service , podemos operar con distintas clases DAO
 */
@Service
public class ReporteServiceImpl implements IReporteService{

    //Inyectamos la interfaz para utilizar los métodos de CRUD
    //C-Create, R-Read Retrieve, U-Update, D-Delete
    @Autowired
    private IReporteDao dao;


    @Transactional(readOnly = true)
    @Override
    public List<Reporte> list() {
        return dao.list();
    }

    @Transactional
    @Override
    public void save(Reporte teacher) {
        dao.save(teacher);
    }

    @Transactional(readOnly = true)
    @Override
    public Reporte getById(Long id) {
        return dao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        dao.delete(id);
    }
   
}
