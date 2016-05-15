package com.pisys.tusuerte;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

public class PrediccionActivity extends AppCompatActivity {

    public static final String EXTRA_TITULO = "titulo";
    public static final String EXTRA_FOTO = "foto";
    public static final String EXTRA_PREDICCION_AMOR = "pamor";
    public static final String EXTRA_PREDICCION_SALUD = "psalud";
    public static final String EXTRA_PREDICCION_DINERO = "pdinero";
    private String prediccionDinero;
    private String prediccionSalud;
    private String prediccionAmor;
    private int foto;
    private String titulo;
    private TextView tvPrediccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prediccion);

        titulo = getIntent().getStringExtra(EXTRA_TITULO);
        foto = getIntent().getIntExtra(EXTRA_FOTO, R.drawable.unknown);
        prediccionAmor = getIntent().getStringExtra(EXTRA_PREDICCION_AMOR);
        prediccionSalud = getIntent().getStringExtra(EXTRA_PREDICCION_SALUD);
        prediccionDinero = getIntent().getStringExtra(EXTRA_PREDICCION_DINERO);

        tvPrediccion = (TextView) findViewById(R.id.tvPrediccion);
        tvPrediccion.setMovementMethod(ScrollingMovementMethod.getInstance());
        seleccionarAmor();

        TextView tvNombre = (TextView) findViewById(R.id.tvNombreSigno);
        tvNombre.setText(titulo);

        ImageView ivImagen = (ImageView) findViewById(R.id.imgLogoSigno);
        ivImagen.setImageResource(foto);
    }

    private void seleccionarAmor() {
        tvPrediccion.setText(prediccionAmor);
    }
}
