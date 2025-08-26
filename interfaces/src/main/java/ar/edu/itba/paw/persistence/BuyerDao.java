package ar.edu.itba.paw.persistence;

import ar.edu.itba.paw.models.Buyer;

public interface BuyerDao {
    Buyer create(String name, String email, String dni);

    Buyer findById(long id);

    Buyer findByEmail(String email);

    Buyer findByDni(String dni);
}
