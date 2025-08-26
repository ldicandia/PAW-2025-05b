package ar.edu.itba.paw.services;

import ar.edu.itba.paw.models.Purchase;
import ar.edu.itba.paw.persistence.PurchaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PurchaseServiceImpl implements PurchaseService {
    private final PurchaseDao purchaseDao;

    @Autowired
    public PurchaseServiceImpl(PurchaseDao purchaseDao) {
        this.purchaseDao = purchaseDao;
    }

    @Override
    public Purchase create(long buyerId, long vinylId, String status, float price) {
        return purchaseDao.create(buyerId, vinylId, status, price);
    }

    @Override
    public Optional<Purchase> findById(long id) {
        return purchaseDao.findById(id);
    }
}