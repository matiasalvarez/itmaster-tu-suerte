package com.pisys.tusuerte;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirHoroscopoChino(View boton){
        startActivity(new Intent(this, PedirDatosHoroscopoChinoActivity.class));
    }

    public void abrirHoroscopoZodiaco(View boton){
        startActivity(new Intent(this, PedirDatosHoroscopoZodiacoActivity.class));
    }
}
