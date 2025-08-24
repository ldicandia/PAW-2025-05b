package ar.edu.itba.paw.persistence;

import ar.edu.itba.paw.models.Compra;

public interface CompraDao {

    long create(long compradorId, long viniloId, String estado, int precio);
    Compra findById(long id);
}
