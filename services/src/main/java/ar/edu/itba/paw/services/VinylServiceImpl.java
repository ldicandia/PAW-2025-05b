package ar.edu.itba.paw.services;

import ar.edu.itba.paw.models.Vinyl;
import ar.edu.itba.paw.persistence.VinylDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class VinylServiceImpl implements VinylService {
    @Autowired
    private final VinylDao vinylDao;

    public VinylServiceImpl(VinylDao vinylDao) {
        this.vinylDao = vinylDao;
    }

    @Override
    public Vinyl create(String title, Date releaseDate, String genre,
                        Float price, String condition, String publicationStatus,
                        Integer stock, Date createdOn) {
        return vinylDao.create(title, releaseDate, genre, price,
                condition, publicationStatus, stock, createdOn);
    }

    @Override
    public Optional<Vinyl> findById(long id) {
        return vinylDao.findById(id);
    }

    @Override
    public List<Vinyl> findAll() {
        return vinylDao.findAll();
    }
}
