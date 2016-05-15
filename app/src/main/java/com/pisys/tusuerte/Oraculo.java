package com.pisys.tusuerte;

import android.content.Context;

/**
 * Created by malvarez on 14/05/16.
 */
public class Oraculo {

    public static Oraculo newOraculoChino() {
        return new Oraculo();
    }

    public static Oraculo newOraculoZodiaco() {
        return new Oraculo();
    }

    private Oraculo() {
    }

    public String getPrediccionAmor(Context context) {
        return getString(context, R.array.prediccionesAmor);
    }

    public String getPrediccionSalud(Context context) {
        return getString(context, R.array.prediccionesSalud);
    }

    public String getPrediccionDinero(Context context) {
        return getString(context, R.array.prediccionesDinero);
    }

    private String getString(Context context, int prediccionesSalud) {
        String[] stringArray = context.getResources().getStringArray(prediccionesSalud);
        return stringArray[(int) (Math.random() * stringArray.length)];
    }
}
