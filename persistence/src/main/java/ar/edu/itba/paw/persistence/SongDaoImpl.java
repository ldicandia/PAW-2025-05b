package ar.edu.itba.paw.persistence;

import ar.edu.itba.paw.models.Song;
import ar.edu.itba.paw.models.Vinyl;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public class SongDaoImpl implements SongDao {
    @Override
    public Song create(String title, String artist, int durationSec, int position, long vinylId) {
        return null;
    }

    @Override
    public Optional<Vinyl> findById(long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Song> findByTitle(long id) {
        return Optional.empty();
    }
}
