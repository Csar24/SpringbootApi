package com.csar.api.model;

import java.time.DateTimeException;
import java.time.LocalDate;

public class Episodios {

    private Integer temporada;
    private String titulo;
    private Integer numeroEpisodios;
    private Double evaluacion;
    private LocalDate fechaLanzamiento ;

    public Episodios(Integer numero, DatosEpisodios d) {
        this.temporada = numero;
        this.titulo = d.tiutlo();
        this.numeroEpisodios=d.numeroEpisodios();
        try {
            this.evaluacion= Double.valueOf(d.evaluacion());
        }
        catch (NumberFormatException e){
            this.evaluacion =0.0;
        }
        try {
            this.fechaLanzamiento= LocalDate.parse(d.fechadeLanzamiento());
        }
        catch (DateTimeException e){
            this.fechaLanzamiento = null;
        }


    }


    public Integer getTemporad() {
        return temporada;
    }

    public void setTemporad(Integer temporada) {
        this.temporada = temporada;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getNumeroEpisodios() {
        return numeroEpisodios;
    }

    public void setNumeroEpisodios(Integer numeroEpisodios) {
        this.numeroEpisodios = numeroEpisodios;
    }

    public Double getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(Double evaluacion) {
        this.evaluacion = evaluacion;
    }

    public LocalDate getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    @Override
    public String toString() {
        return "Episodios{" +
                "temporad=" + temporada +
                ", titulo='" + titulo + '\'' +
                ", numeroEpisodios=" + numeroEpisodios +
                ", evaluacion=" + evaluacion +
                ", fechaLanzamiento=" + fechaLanzamiento +
                '}';
    }
}
