package com.pisys.tusuerte;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Arrays;
import java.util.List;

public class PedirDatosHoroscopoZodiacoActivity extends AppCompatActivity {

    private Oraculo oraculo = Oraculo.newOraculoZodiaco();
    private String nombreSigno;
    private int logoSigno;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedir_datos_horoscopo_zodiaco);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setSubtitle(getString(R.string.horoscopo_zodiaco));
        actionBar.setDisplayHomeAsUpEnabled(true);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void calcular(View view) {
        EditText editDia = (EditText) findViewById(R.id.editDia);
        EditText editMes = (EditText) findViewById(R.id.editMes);

        if (editDia.getText().toString().isEmpty()) {
            editDia.setError("Debe ingresar un día");
            return;
        }

        if (editMes.getText().toString().isEmpty()) {
            editDia.setError("Debe ingresar un mes");
            return;
        }

        int dia = Integer.valueOf(editDia.getText().toString());
        int mes = Integer.valueOf(editMes.getText().toString());

        try {
            TextView tvHoroscopo = (TextView) findViewById(R.id.horoscopo);
            calcularSigno(dia, mes);
            tvHoroscopo.setText(getString(R.string.tu_signo_es, nombreSigno));
        } catch (Exception e) {
            new AlertDialog.Builder(this).setTitle("Error").setMessage(e.getMessage()).setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            }).show();
        }
    }

    private void calcularSigno(int dia, int mes) {
        Button btnPrediccion = (Button) findViewById(R.id.btnPrediccion);
        btnPrediccion.setVisibility(View.INVISIBLE);
        if ((dia >= 21 && mes == 3) || (dia <= 20 && mes == 4)) {
            logoSigno = R.drawable.aries;
            nombreSigno = "Aries";
        } else if ((dia >= 24 && mes == 9) || (dia <= 23 && mes == 10)) {
            logoSigno = R.drawable.libra;
            nombreSigno = "Libra";
        } else if ((dia >= 21 && mes == 4) || (dia <= 21 && mes == 5)) {
            logoSigno = R.drawable.tauro;
            nombreSigno = "Tauro";
        } else if ((dia >= 24 && mes == 10) || (dia <= 22 && mes == 11)) {
            logoSigno = R.drawable.aries;
            nombreSigno = "Escorpio";
        } else if ((dia >= 22 && mes == 5) || (dia <= 21 && mes == 6)) {
            logoSigno = R.drawable.geminis;
            nombreSigno = "Geminis";
        } else if ((dia >= 23 && mes == 11) || (dia <= 21 && mes == 12)) {
            logoSigno = R.drawable.sagitario;
            nombreSigno = "Sagitario";
        } else if ((dia >= 21 && mes == 6) || (dia <= 23 && mes == 7)) {
            logoSigno = R.drawable.cancer;
            nombreSigno = "Cancer";
        } else if ((dia >= 22 && mes == 12) || (dia <= 20 && mes == 1)) {
            logoSigno = R.drawable.capricornio;
            nombreSigno = "Capricornio";
        } else if ((dia >= 24 && mes == 7) || (dia <= 23 && mes == 8)) {
            logoSigno = R.drawable.leo;
            nombreSigno = "Leo";
        } else if ((dia >= 21 && mes == 1) || (dia <= 19 && mes == 2)) {
            logoSigno = R.drawable.acuario;
            nombreSigno = "Acuario";
        } else if ((dia >= 24 && mes == 8) || (dia <= 23 && mes == 9)) {
            logoSigno = R.drawable.virgo;
            nombreSigno = "Virgo";
        } else if ((dia >= 20 && mes == 2) || (dia <= 20 && mes == 3)) {
            logoSigno = R.drawable.piscis;
            nombreSigno = "Piscis";
        }
        btnPrediccion.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void verPrediccion(View view) {
        Intent intent = new Intent(this, PrediccionActivity.class);
        intent.putExtra(PrediccionActivity.EXTRA_FOTO, logoSigno);
        intent.putExtra(PrediccionActivity.EXTRA_TITULO, nombreSigno);
        intent.putExtra(PrediccionActivity.EXTRA_PREDICCION_DINERO, oraculo.getPrediccionDinero(this));
        intent.putExtra(PrediccionActivity.EXTRA_PREDICCION_SALUD, oraculo.getPrediccionSalud(this));
        intent.putExtra(PrediccionActivity.EXTRA_PREDICCION_AMOR, oraculo.getPrediccionAmor(this));
        startActivity(intent);
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "PedirDatosHoroscopoZodiaco Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.pisys.tusuerte/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "PedirDatosHoroscopoZodiaco Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.pisys.tusuerte/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
