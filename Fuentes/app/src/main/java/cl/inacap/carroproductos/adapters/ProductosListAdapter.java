package cl.inacap.carroproductos.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.List;

import cl.inacap.carroproductos.R;
import cl.inacap.carroproductos.dto.Producto;

public class ProductosListAdapter extends ArrayAdapter<Producto> {

    //Definir lista de productos
    private List <Producto> productos;

    //Definir el activity como atributo
    private Activity activity;

    public ProductosListAdapter(@NonNull Activity context, int resource, @NonNull List<Producto> objects) {
        super(context, resource, objects);
        this.productos = objects;
        this.activity = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //Generar un layout, construyendo la instancia
        LayoutInflater inflater = this.activity.getLayoutInflater();

        //Generar una fila del layout, fila que será obtenida del inflater
        View fila = inflater.inflate(R.layout.productos_list, null, true);

        //Aquí carga contenido layout
        // obteniendo referencia del texview
        TextView nombreTv = fila.findViewById(R.id.nombre_prod_pl);
        // obteniendo el imageview
        ImageView imageProd = fila.findViewById(R.id.image_prod_pl);
        //Acceder al producto actual, va producto por producto
        Producto actual = productos.get(position);
        //Definir el texto del view
        nombreTv.setText(actual.getNombre());
        //Ingresar la imagen de picasso
        Picasso.get().load(actual.getFoto())
                .resize(300,300)
                .centerCrop()
                .into(imageProd);

        //Finalmente, se retorna la fila
        return fila;
    }
}
