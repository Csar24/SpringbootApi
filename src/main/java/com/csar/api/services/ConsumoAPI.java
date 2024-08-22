package com.csar.api.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoAPI {

    //Metodo HTTP
    public String obtnerDatos(String url ){
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest request =HttpRequest.newBuilder().uri(URI.create(url)).build();

        HttpResponse<String> response =null;
        try {
            //respuesta a la llamada
            response = cliente.send(request,  HttpResponse.BodyHandlers.ofString());



        }
        catch ( IOException e) {
            throw new RuntimeException(e);
        }
        catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        String json = response.body();


        return json;
    }
}
