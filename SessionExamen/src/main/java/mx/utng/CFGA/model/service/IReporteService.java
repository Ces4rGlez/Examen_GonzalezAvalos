package mx.utng.CFGA.model.service;

import java.util.List;

import mx.utng.CFGA.model.entity.Reporte;

public interface IReporteService {
    List<Reporte> list();
    void save(Reporte teacher);
    Reporte getById(Long id);
    void delete(Long id);
}
