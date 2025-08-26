package ar.edu.itba.paw.persistence;


import ar.edu.itba.paw.models.Song;
import ar.edu.itba.paw.models.Vinyl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface VinylDao {
    Vinyl create(String title, Date releaseDate, String genre, Float price,
                 String condition, String publicationStatus, Integer stock, Date createdOn);

    Optional<Vinyl> findById(long id);

    List<Vinyl> findAll();
}
