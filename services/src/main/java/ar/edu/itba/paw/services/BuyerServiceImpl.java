package ar.edu.itba.paw.services;

import ar.edu.itba.paw.models.Buyer;
import ar.edu.itba.paw.persistence.BuyerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BuyerServiceImpl implements BuyerService {
    private final BuyerDao buyerDao;

    @Autowired
    public BuyerServiceImpl(BuyerDao buyerDao) {
        this.buyerDao = buyerDao;
    }

    @Override
    public Buyer create(String name, String email, String dni) {
        return buyerDao.create(name, email, dni);
    }

    @Override
    public Optional<Buyer> findById(long id) {
        return buyerDao.findById(id);
    }

    @Override
    public Optional<Buyer> findByEmail(String email) {
        return buyerDao.findByEmail(email);
    }

    @Override
    public Optional<Buyer> findByDni(String dni) {
        return buyerDao.findByDni(dni);
    }
}