package cl.inacap.carroproductos.dao;

import java.util.List;

import cl.inacap.carroproductos.dto.Producto;

public interface ProductosDAO {

    //Metodo agregar
    Producto save(Producto p);

    //Metodo listar
    List<Producto> getAll();

}
