package cl.inacap.carroproductos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import cl.inacap.carroproductos.dto.Producto;

public class ProductoViewActivity extends AppCompatActivity {

    //Referencias anombre, producto, toolbar y titulo tolbar
    TextView nombreProdTv;
    Producto producto;
    Toolbar toolbar;
    TextView tituloToolbarTv;
    //Referencias de pag. productos
    TextView descripcionProdTv;
    ImageView imagenProd;
    TextView precioProdTv;

    //Sobre escribir método del activity
    @Override
    public boolean onSupportNavigateUp() {
        //asegurar que volverá al activity antes cargado
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto_view);

        //referencia a toolbar para que cambie el título en función del producto
        this.toolbar = findViewById(R.id.toolbar);
        //Recibir titulo toolbar
        this.tituloToolbarTv = findViewById(R.id.titulo_toolbar_txt);

        this.nombreProdTv = findViewById(R.id.nombre_prod_view_txt);
        this.imagenProd = findViewById(R.id.imagen_prod_view);
        this.descripcionProdTv = findViewById(R.id.desc_prod_view_tv);
        this.precioProdTv = findViewById(R.id.precio_prod_view_tx);

        //definir toolbar
        this.setSupportActionBar(this.toolbar);
        //definir métodos del action bar-aka toolbar, en este,
        // cuando suba dentro de la navegacion, se va a ir al home:
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //en este metodo del action bar, dice que en activity sale la flecha
        this.getSupportActionBar().setDisplayShowHomeEnabled(true);

        if(getIntent().getExtras() != null){
            //el intend venia con yapa
            //me enviaron algo en el intend
            //traer el producto:
            this.producto = (Producto)getIntent().getSerializableExtra("producto");
            //definir valor titulo toolbar
            this.tituloToolbarTv.setText(this.producto.getNombre());

            //traer el nombre del producto:
            this.nombreProdTv.setText(this.producto.getNombre());
            //traer la imagen del producto
            Picasso.get().load(this.producto.getFoto())
                    .resize(500,500)
                    .centerCrop()
                    .into(this.imagenProd);
            //traer la descripcion
            this.descripcionProdTv.setText(this.producto.getDescripcion());
            //traer precio
            this.precioProdTv.setText("$"+this.producto.getPrecio());
        }
    }
}