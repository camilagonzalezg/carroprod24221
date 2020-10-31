package cl.inacap.carroproductos.dto;

import java.io.Serializable;

//Para transferir objetos por red, implementamos Serializable, haciendo
// que los objetos de esta clase sean transportados
public class Producto implements Serializable {

    private String nombre;
    private String foto;
    private String descripcion;
    private int precio;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
