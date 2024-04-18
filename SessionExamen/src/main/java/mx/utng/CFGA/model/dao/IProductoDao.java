package mx.utng.CFGA.model.dao;

import java.util.List;

import mx.utng.CFGA.model.entity.Producto;



public interface IProductoDao {
    List<Producto> list();
    void save(Producto producto);
    Producto getById(Long id);
    void delete(Long id);
}
