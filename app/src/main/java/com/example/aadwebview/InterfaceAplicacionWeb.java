package com.example.aadwebview;

import android.util.Log;
import android.webkit.JavascriptInterface;

public class InterfaceAplicacionWeb {

    private String usuario,clave;


    public void InterfaceAplicacionWeb(){

    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @JavascriptInterface
    public void sendData(String usuario, String pass){
        setUsuario(usuario);
        setClave(pass);
        Log.v("MOSTRAR","usuario "+usuario);
        Log.v("MOSTRAR","pass "+pass);
    }
}
