package com.csar.api;

import com.csar.api.model.DatosSeries;
import com.csar.api.model.DatosTemporadas;
import com.csar.api.principal.Principal;
import com.csar.api.services.ConsumoAPI;
import com.csar.api.services.ConvierteDatos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);

//		// consumir API
//		ConsumoAPI consumoAPI =new ConsumoAPI();
//
//		String json = consumoAPI.obtnerDatos("https://www.omdbapi.com/?t=game+of+thrones&apikey=ae5358c3");
//		System.out.println(json );
//		//Convertir datos Json a Java class
//		ConvierteDatos conversor =new ConvierteDatos();
////		Class<DatosSeries> clase = DatosSeries.class;
//		DatosSeries datos = conversor.obtenerDatos(json, DatosSeries.class);
//		System.out.println(datos.titulo());
//
//		//consumir API de Series
//		String JsonSeries= consumoAPI.obtnerDatos("https://www.omdbapi.com/?t=game+of+thrones&season=1&episode&apikey=ae5358c3");
//		var episodios= conversor.obtenerDatos(JsonSeries, DatosSeries.class);
//		System.out.println(episodios);
//
//		//Consum de API de Temporadas
//		List<DatosTemporadas> temporadas = new ArrayList<>();
//		for(int i=0; i<= datos.totalTemporadas();i++){
//
//			 json =consumoAPI.obtnerDatos("https://www.omdbapi.com/?t=game+of+thrones&season="+i+"&apikey=ae5358c3");
//			 var datosTemporada = conversor.obtenerDatos(json, DatosTemporadas.class);
//			 temporadas.add(datosTemporada);
//
//
//		}
//		temporadas.forEach(System.out::println);



	}


	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.mostrarMenu();

	}
}
