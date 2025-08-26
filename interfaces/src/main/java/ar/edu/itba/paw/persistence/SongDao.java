package ar.edu.itba.paw.persistence;

import ar.edu.itba.paw.models.Song;
import ar.edu.itba.paw.models.Vinyl;

import java.util.Optional;

public interface SongDao {
    Song create(String title, String artist, int durationSec, int position, long vinylId);
    Optional<Vinyl> findById(long id);
    Optional<Song> findByTitle(long id);
}
