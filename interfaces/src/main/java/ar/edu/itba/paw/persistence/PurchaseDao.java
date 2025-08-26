package ar.edu.itba.paw.persistence;

import ar.edu.itba.paw.models.Purchase;

public interface PurchaseDao {

    long create(long compradorId, long viniloId, String estado, int precio);
    Purchase findById(long id);
}
