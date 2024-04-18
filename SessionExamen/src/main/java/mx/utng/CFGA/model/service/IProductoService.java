package mx.utng.CFGA.model.service;

import java.util.List;

import mx.utng.CFGA.model.entity.Producto;



public interface IProductoService {
    List<Producto> list();
    void save(Producto producto);
    Producto getById(Long id);
    void delete(Long id);
}
