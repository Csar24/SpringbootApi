package com.csar.api.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosEpisodios(
        @JsonAlias("Title") String tiutlo,
        @JsonAlias("Episode") Integer numeroEpisodios,
        @JsonAlias("imdbRating") String evaluacion,
        @JsonAlias("Released") String fechadeLanzamiento
) {
}
