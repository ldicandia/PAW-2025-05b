package ar.edu.itba.paw.persistence;

import ar.edu.itba.paw.models.Buyer;
import org.springframework.stereotype.Repository;

@Repository
public class BuyerDaoImpl implements BuyerDao {
    @Override
    public Buyer create(String name, String email, String dni) {
        return null;
    }

    @Override
    public Buyer findById(long id) {
        return null;
    }

    @Override
    public Buyer findByEmail(String email) {
        return null;
    }

    @Override
    public Buyer findByDni(String dni) {
        return null;
    }
}
