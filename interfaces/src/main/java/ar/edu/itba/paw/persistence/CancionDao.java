package ar.edu.itba.paw.persistence;

import ar.edu.itba.paw.models.Cancion;

public interface CancionDao {
    Cancion create(String titulo, String artista, String genero, int anio, int duracion, long viniloId);
    Cancion findById(long id);
}
