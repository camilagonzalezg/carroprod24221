package cl.inacap.carroproductos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import cl.inacap.carroproductos.adapters.ProductosListAdapter;
import cl.inacap.carroproductos.dao.ProductosDAO;
import cl.inacap.carroproductos.dao.ProductosDAOLista;
import cl.inacap.carroproductos.dto.Producto;

public class MainActivity extends AppCompatActivity {

    //Lista de productos
    private List<Producto> productos;
    //Referencia al list view
    private ListView productosLv;
    //Referencia al adaptador
    private ProductosListAdapter adapter;
    //Referencia al DAO
    private ProductosDAO prodDAO = ProductosDAOLista.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Acceder a referencia de toolbar para que funcione
        this.setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        //Obtener una referencia del listview
        this.productosLv=findViewById(R.id.productos_lv);

        //Ir a buscar a los productos a la lista
        this.productos=this.prodDAO.getAll();

        //Construir un list view al adapter
        this.adapter = new ProductosListAdapter(this,
                R.layout.productos_list, this.productos);

        //Hacer que el adaptador sea parte del listview
        this.productosLv.setAdapter(this.adapter);

        //Agregar un listener a los elementos de la lista
        this.productosLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //Probar el listener 1
                // Toast.makeText(MainActivity.this, "Se apretó" + i, Toast.LENGTH_SHORT).show();

                //Hacer click y que diga qué producto es
                Producto producto = productos.get(i);
                Toast.makeText(MainActivity.this,producto.getNombre(),
                        Toast.LENGTH_SHORT).show();

                //Provocar que luego de click, vaya a otro activity, mediante un intent
                //Intend-Desde donde viene(contexto), hacia donde va (contexto), en este caso va a la clase ProductoView
                Intent intent = new Intent(MainActivity.this, ProductoViewActivity.class);
                //Pasar el elemento para que esté en el activity
                intent.putExtra("producto", producto);
                //Para que se ejecute la navegación agregándolo al stack
                startActivity(intent);
            }
        });
    }
}