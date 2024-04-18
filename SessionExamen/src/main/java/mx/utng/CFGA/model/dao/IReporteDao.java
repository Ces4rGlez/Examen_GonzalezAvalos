package mx.utng.CFGA.model.dao;

import java.util.List;

import mx.utng.CFGA.model.entity.Reporte;

public interface IReporteDao {
    List<Reporte> list();
    void save(Reporte teacher);
    Reporte getById(Long id);
    void delete(Long id);
}
