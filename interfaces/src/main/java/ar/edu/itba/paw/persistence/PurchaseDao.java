package ar.edu.itba.paw.persistence;

import ar.edu.itba.paw.models.Purchase;

import java.util.Optional;

public interface PurchaseDao {

    Purchase create(long buyerId, long vinylId, String status, int price);
    Optional<Purchase> findById(long id);
}
