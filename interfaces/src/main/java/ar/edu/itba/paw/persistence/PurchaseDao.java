package ar.edu.itba.paw.persistence;

import ar.edu.itba.paw.models.Purchase;

public interface PurchaseDao {

    long create(long buyerId, long vinylId, String status, int price);
    Purchase findById(long id);
}
