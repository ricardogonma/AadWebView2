package com.example.aadwebview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ActividadPrincipal extends AppCompatActivity {

    private WebView webView;
    private String usuario = "aad";
    private String pass = "1234";
    private String url = "http://www.juntadeandalucia.es/averroes/centros-tic/18700098/moodle2/login/index.php";
    //private String url = "https://curso1819-izvdamdaw.c9users.io/aad/prueba2.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_principal);

        webView = findViewById(R.id.wvMoodle);

        webView.getSettings().setJavaScriptEnabled(true);

        webView.loadUrl(url);

        /*final String strJavaScript =
                "        var user = document.getElementById('username');" +
                "        var pass = document.getElementById('password');" +
                "        var btnEnviar = document.getElementById('loginbtn');" +
                "        user.value = '" + usuario + "';" +
                "        pass.value = '"  + pass + "';" +
                "        btnEnviar.click();";*/





        final String strJavaScript =
         "var xhttp = new XMLHttpRequest();"+
         "var formData = new FormData();"+
         "formData.append('user', "+usuario+");"+
         "formData.append('password',"+pass+");"+
         "xhttp.open('POST', 'http://www.juntadeandalucia.es/averroes/centros-tic/18700098/moodle2/login/index.php', true);"+
         "xhttp.send(formData);"+
         "document.getElementByName('loginerrors')[0].setText(xhttp.responseText);";


        webView.setWebViewClient(new WebViewClient(){
            boolean isLoaded = false;
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

                if(!isLoaded) {
                    InterfaceAplicacionWeb iaw;
                    iaw = new InterfaceAplicacionWeb();
                    webView.addJavascriptInterface(iaw,"puente");
                    /*String strJavaScript =
                            "var formulario = document.getElementById('formulario');"+
                            "boton.addEventListener('submit', function(){" +
                                "var usuario = document.getElelementById('nombre').value;"+
                                "var pass = document.getElementById('clave').value;"+
                                "puente.sendData(usuario,pass);"+
                            "});";*/
                    webView.loadUrl("javascript:" + strJavaScript);
                    System.out.println("usuario: "+iaw.getUsuario()+" --- pass: "+iaw.getClave());
                }
                isLoaded = true;
            }
        });

    }

    /*private static void pruebaPaginaNuestra(WebView webView){
        final String strJavaScript =
                "        var nombre = document.getElementById('nombre');" +
                        "        var btnEnviar = document.getElementById('btnEnviar');" +
                        "        nombre.value = 'pepe';" +
                        "        btnEnviar.click();";


        webView.getSettings().setJavaScriptEnabled(true);

        //webView.loadUrl("http://www.juntadeandalucia.es/averroes/centros-tic/18700098/moodle2/");
        webView.loadUrl("https://clases-carmelo-ricarquico.c9users.io/formulario.html");

        webView.setWebViewClient(new WebViewClient(){
            boolean isLoaded = false;
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                if(!isLoaded) {
                    webView.loadUrl("javascript:" + strJavaScript);
                }
                isLoaded = true;
            }
        });
    }*/


}
