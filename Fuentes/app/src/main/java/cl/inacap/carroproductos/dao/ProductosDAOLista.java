package cl.inacap.carroproductos.dao;

import java.util.ArrayList;
import java.util.List;

import cl.inacap.carroproductos.dto.Producto;

public class ProductosDAOLista implements ProductosDAO {

    //Lista
    private static List<Producto> productos = new ArrayList<>();

    //Patron singleton:
    //1. Se crea constructor privado para que se ejecute solo 1 vez los productos, al abrir la app
    private ProductosDAOLista(){
        //Producto 1
        Producto p = new Producto();
        p.setNombre("Coca cola Zero");
        p.setDescripcion("Descripción producto");
        p.setPrecio(1000);
        p.setFoto("https://jumbo.vteximg.com.br/arquivos/ids/222681/1259964.jpg?v=636548056172700000");
        productos.add(p);

        //Producto 2
        p = new Producto();
        p.setNombre("Centella");
        p.setDescripcion("Descripción producto");
        p.setPrecio(100);
        p.setFoto("https://www.savory.cl/sites/default/files/solo-para-mi_infantiles--centella.png");
        productos.add(p);

        //Producto 3
        p = new Producto();
        p.setNombre("Ramitas");
        p.setDescripcion("Descripción producto");
        p.setPrecio(500);
        p.setFoto("https://images.lider.cl/wmtcl?source=url[file:/productos/1023486a.jpg]&sink");
        productos.add(p);

    }

    //2. Que tenga una instancia a sí mismo
    private static ProductosDAOLista instancia;

    //3. metodo público estático que va a retornar una instancia de la clase
    public static ProductosDAOLista getInstance(){
    if(instancia==null){
        instancia = new ProductosDAOLista();
    }
    return instancia;
    }

    @Override
    public Producto save(Producto p) {
        //Guardar lista
        productos.add(p);
        //Que retorne "p" (se saca null)
        return p;
    }

    @Override
    public List<Producto> getAll() {
        //Que retorne "productos" (se saca null)
        return productos;
    }
}
