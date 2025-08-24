package ar.edu.itba.paw.persistence;

import ar.edu.itba.paw.models.Cancion;
import ar.edu.itba.paw.models.Vinilo;

import java.util.List;
import java.util.Optional;


public interface ViniloDao {

    Vinilo create(String nombre, String fecha_lanzamiento, String genero,
                  Cancion[] canciones, float precio, String condicion, Integer stock);

    List<Vinilo> findById(long id);


}
