package ar.edu.itba.paw.services;

import ar.edu.itba.paw.models.Buyer;

import java.util.Optional;

public interface BuyerService {
    Buyer create(String name, String email, String dni);

    Optional<Buyer> findById(long id);

    Optional<Buyer> findByEmail(String email);

    Optional<Buyer> findByDni(String dni);
}
