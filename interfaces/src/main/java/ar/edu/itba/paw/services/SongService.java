package ar.edu.itba.paw.services;

import ar.edu.itba.paw.models.Song;

import java.util.Optional;

public interface SongService {
    Song create(String title, String artist, int durationSec, int position, long vinylId);
    Optional<Song> findById(long id);
    Optional<Song> findByTitle(String title);
}
