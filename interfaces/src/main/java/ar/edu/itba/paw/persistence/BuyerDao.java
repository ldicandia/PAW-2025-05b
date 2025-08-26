package ar.edu.itba.paw.persistence;

import ar.edu.itba.paw.models.Buyer;

public interface BuyerDao {
    long create(String nombre, String email, String dni);

    Buyer findById(long id);

    Buyer findByEmail(String email);

    Buyer findByDni(String dni);
}
