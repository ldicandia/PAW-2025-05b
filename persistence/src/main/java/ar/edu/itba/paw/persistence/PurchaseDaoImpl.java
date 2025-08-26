package ar.edu.itba.paw.persistence;

import ar.edu.itba.paw.models.Purchase;
import org.springframework.stereotype.Repository;

@Repository
public class PurchaseDaoImpl implements PurchaseDao {
    @Override
    public long create(long buyerId, long vinylId, String status, int price) {
        return 0;
    }

    @Override
    public Purchase findById(long id) {
        return null;
    }
}
