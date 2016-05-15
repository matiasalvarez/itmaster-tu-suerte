package com.pisys.tusuerte;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class PedirDatosHoroscopoChinoActivity extends AppCompatActivity {

    private int anioActual = Calendar.getInstance().get(Calendar.YEAR);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedir_datos_horoscopo_chino);

        getSupportActionBar().setSubtitle(getString(R.string.horoscopo_chino));
    }

    public void calcular(View view) {
        EditText editAnio = (EditText) findViewById(R.id.etAnio);

        if(editAnio.getText().toString().isEmpty()){
            editAnio.setError("Debe ingresar un año");
            return;
        }

        Integer anio = Integer.valueOf(editAnio.getText().toString());
        if(anio < 1900 || anio > anioActual){
            editAnio.setError("Año inválido");
            return;
        }

        TextView tvHoroscopo = (TextView) findViewById(R.id.horoscopo);
        tvHoroscopo.setText(getString(R.string.tu_signo_es,calcularSigno(anio)));
    }

    private String calcularSigno(int anio) {
        return getResources().obtainTypedArray(R.array.signosChinos).getString((anio - 1900) % 12);
    }
}
