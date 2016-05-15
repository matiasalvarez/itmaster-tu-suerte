package com.pisys.tusuerte;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
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
        seleccionarAmor(null);

        TextView tvNombre = (TextView) findViewById(R.id.tvNombreSigno);
        tvNombre.setText(titulo);

        ImageView ivImagen = (ImageView) findViewById(R.id.imgLogoSigno);
        ivImagen.setImageResource(foto);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.prediccion_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String prediccion = tvPrediccion.getText().toString();
        Intent intent = new Intent();
        switch (item.getItemId()) {
            case R.id.enviarMail:
                intent.setAction(Intent.ACTION_SENDTO);
                intent.putExtra(Intent.EXTRA_SUBJECT, "Mirá la predicción de Tu Suerte!");
                intent.putExtra(Intent.EXTRA_TEXT, prediccion);
                intent.setData(Uri.parse("mailto:"));
                startActivity(Intent.createChooser(intent, "Enviar Predicción por Email"));
                return true;
            case R.id.enviarOtro:
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, prediccion);
                intent.setType("text/plain");
                startActivity(Intent.createChooser(intent, "Enviar Predicción..."));
                return true;
            case R.id.enviarSms:
                intent.setAction(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("smsto:"));
                intent.putExtra("sms_body", prediccion);
                startActivity(Intent.createChooser(intent, "Enviar Predicción por SMS"));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void seleccionarSalud(MenuItem item) {
        tvPrediccion.setText(prediccionSalud);
    }

    public void seleccionarDinero(MenuItem item) {
        tvPrediccion.setText(prediccionDinero);
    }

    public void seleccionarAmor(MenuItem item) {
        tvPrediccion.setText(prediccionAmor);
    }
}
