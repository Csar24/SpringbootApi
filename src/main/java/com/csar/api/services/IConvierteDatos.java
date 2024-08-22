package com.csar.api.services;

public interface IConvierteDatos {

    <T> T obtenerDatos(String json, Class<T> clase);

}
