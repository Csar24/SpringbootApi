package com.csar.api;

import com.csar.api.services.ConsumoAPI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
		ConsumoAPI consumoAPI =new ConsumoAPI();
		String json = consumoAPI.obtnerDatos("https://www.omdbapi.com/?t=matrix&apikey=ae5358c3");
		System.out.println(json );

	}




}
