package com.csar.api.principal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploStream {

    public void ejemloString(){
        List<String> nombre = Arrays.asList("Cesar","Esmeralda","Fidel","Raul");

        nombre.stream()
                .sorted()
                .forEach(System.out::println);



    }

}
