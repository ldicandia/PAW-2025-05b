package ar.edu.itba.paw.persistence;

import ar.edu.itba.paw.models.Comprador;

public interface CompradorDao {
    long create(String nombre, String email, String dni);

    Comprador findById(long id);

    Comprador findByEmail(String email);

    Comprador findByDni(String dni);
}
