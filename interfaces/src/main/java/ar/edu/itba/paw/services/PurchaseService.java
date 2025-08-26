package ar.edu.itba.paw.services;

import ar.edu.itba.paw.models.Purchase;

import java.util.Optional;

public interface PurchaseService {
    Purchase create(long buyerId, long vinylId, String status, float price);
    Optional<Purchase> findById(long id);

}
