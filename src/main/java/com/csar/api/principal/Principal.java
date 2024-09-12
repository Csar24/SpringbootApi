package com.csar.api.principal;

import com.csar.api.model.DatosEpisodios;
import com.csar.api.model.DatosSeries;
import com.csar.api.model.DatosTemporadas;
import com.csar.api.model.Episodios;
import com.csar.api.services.ConsumoAPI;
import com.csar.api.services.ConvierteDatos;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private Scanner scanner = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConvierteDatos  convierteDatos = new ConvierteDatos();

    private final  String URL_BASE = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=ae5358c3";


    public  void mostrarMenu(){
        System.out.println("Porfavor Introdusca el nombre de una serie");
        var  nombreSerie = scanner.nextLine();
        // buscar los datos generales  de la serie
        var json = consumoAPI.obtnerDatos(URL_BASE+ nombreSerie.replace(" ","+")+ API_KEY);
        //conversion
        var datos = convierteDatos.obtenerDatos(json, DatosSeries.class);
        System.out.println(datos);

        //buscar los datos de las Temporadas
        List<DatosTemporadas> temporadas = new ArrayList<>();
        for (int i = 1; i <= datos.totalTemporadas() ; i++) {
            json = consumoAPI.obtnerDatos(URL_BASE+ nombreSerie.replace(" ","+")+"&Season="+i+API_KEY);
            var datoTeporada=  convierteDatos.obtenerDatos(json, DatosTemporadas.class);
            temporadas.add(datoTeporada);

        }
         temporadas.forEach(System.out::println);

//        //mostrar titulos de Temporada
//        for (int i = 0; i < datos.totalTemporadas(); i++) {
//            List<DatosEpisodios> episodiosTemporada = temporadas.get(i).episodios();
//            for (int j = 0; j < episodiosTemporada.size() ; j++) {
//                System.out.println(episodiosTemporada.get(j).tiutlo());
//
//            }
//
//        }
// Expresion Lambda
        temporadas.forEach(t -> t.episodios().forEach(e-> System.out.println(e.tiutlo())) );

        //convertir informacion  a lista de tipo datos de episodios
        List<DatosEpisodios> datosepisodios = temporadas.stream()
                .flatMap(t->t.episodios().stream())
                .collect(Collectors.toList());

        System.out.println("TOP-5");
        datosepisodios.stream()
                .filter(e->!e.evaluacion().equalsIgnoreCase("N/A"))
                .sorted(Comparator.comparing(DatosEpisodios::evaluacion).reversed())
                .limit(5)
                .forEach(System.out::println);


        //Convirtiendo los datos  a una lista de tipo de Episodios
        List<Episodios> episodios = temporadas.stream()
                .flatMap(t->t.episodios().stream()
                        .map(d-> new Episodios(t.numero(),d)))
                .collect(Collectors.toList());
        episodios.forEach(System.out::println);

        //Busqueda de Episodios Apartir de un anio

        System.out.println("Porfavor indicar el año a partir del cual quiere que se muestre");

        var  fecha = scanner.nextInt();
        scanner.nextLine();

        LocalDate fechaBusqueda = LocalDate.of(fecha,1,1);

        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd/MM/yyy");
        episodios.stream()
                .filter(e ->e.getFechaLanzamiento()!= null && e.getFechaLanzamiento().isAfter(fechaBusqueda))
                .forEach(e->{
                    System.out.println(
                            "Temporada"+e.getTemporad()+
                                    "Episodios" +e.getTitulo()+
                                    "Fecha de Lanzamiento"+e.getFechaLanzamiento().format(dtf)

                    );
                });


    }

}
