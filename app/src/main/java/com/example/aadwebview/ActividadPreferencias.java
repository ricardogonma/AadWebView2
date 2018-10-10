package com.example.aadwebview;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActividadPreferencias extends AppCompatActivity {

    private Button btPref;
    private Button btShPref;
    private Button btDeShPref;
    private Button btLeerPref;
    private Button btLeerShPref;
    private Button btLeerShPrefDef;
    private android.widget.TextView tvResultado;

    private void addEvents(){
        botonesEscritura();
        botonesLectura();
    }

    private void botonesEscritura(){
        /*
            El archivo guarda el nombre de la clase (ActividadPreferencias)
            Para acceder a este archivo solo se puede con el nombre de la calse
         */
        this.btPref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
                escribirPreferencias(sharedPref,"valor guardado btPref uno",getString(R.string.datoGuardadoPref));
            }
        });

        /*
            El archivo se guarda con el nombre de la clave

         */
        this.btShPref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = ActividadPreferencias.this;
                SharedPreferences sharedPref = context.getSharedPreferences(
                        getString(R.string.archivoSharedPreferences), Context.MODE_PRIVATE
                );
                escribirPreferencias(sharedPref,"valor guardado btShPref dos",getString(R.string.datoGuardadoShPref));
            }
        });

        /*
            El archivo guarda el nombre del paquete (com.example.aadwebview)
            Para acceder a este archivo solo se puede con el nombre del paquete
         */
        this.btDeShPref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(ActividadPreferencias.this);
                escribirPreferencias(sharedPref,"valor guardado btShPref tres",getString(R.string.datoGuardadoShPrefDef));
            }
        });
    }

    private void botonesLectura(){
        this.btLeerPref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
                leerPreferencias(sharedPref,getString(R.string.datoGuardadoPref));
            }
        });


        this.btLeerShPref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = ActividadPreferencias.this;
                SharedPreferences sharedPref = context.getSharedPreferences(
                        getString(R.string.archivoSharedPreferences), Context.MODE_PRIVATE
                );
                leerPreferencias(sharedPref,getString(R.string.datoGuardadoShPref));
            }
        });


        this.btLeerShPrefDef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(ActividadPreferencias.this);
                leerPreferencias(sharedPref,getString(R.string.datoGuardadoShPrefDef));
            }
        });
    }

    private void escribirPreferencias(SharedPreferences sharedPref, String valor, String clave){
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(clave, valor);
        editor.apply();
    }

    private void init() {
        this.btDeShPref = findViewById(R.id.btDeShPref);
        this.btShPref = findViewById(R.id.btShPref);
        this.btPref = findViewById(R.id.btPref);
        this.btLeerShPrefDef = findViewById(R.id.btLeerShPrefDef);
        this.btLeerShPref = findViewById(R.id.btLeerShPref);
        this.btLeerPref = findViewById(R.id.btLeerPref);
        this.tvResultado = findViewById(R.id.tvResultado);
        addEvents();
    }

    /*
        Clave = nombre del valor
        valorPredefinido = Valor que devuelve si no lo encuentra
     */
    private void leerPreferencias(SharedPreferences sharedPref,String clave){
        String valorPredefinido = getResources().getString(R.string.valorPredefinido);
        String valor = sharedPref.getString(clave, valorPredefinido);
        tvResultado.setText(valor);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_preferencias);
        init();
    }



}
