package ar.edu.itba.paw.models;

import lombok.Getter;

@Getter

public class Cancion {
    private final long id;
    private final String titulo;
    private final String artista;
    private final int duracion_seg;
    private final int posicion;
    private final Vinilo vinilo;

    public Cancion(final long id, final String titulo, final String artista, final int duracion_seg, final int posicion, final Vinilo vinilo) {
        this.id = id;
        this.titulo = titulo;
        this.artista = artista;
        this.duracion_seg = duracion_seg;
        this.posicion = posicion;
        this.vinilo = vinilo;
    }
}