package ar.edu.itba.paw.services;

import ar.edu.itba.paw.models.Song;
import ar.edu.itba.paw.persistence.SongDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SongServiceImpl implements SongService {
    private final SongDao songDao;

    @Autowired
    public SongServiceImpl(SongDao songDao) {
        this.songDao = songDao;
    }

    @Override
    public Song create(String title, String artist, int durationSec, int position, long vinylId) {
        return songDao.create(title, artist, durationSec, position, vinylId);
    }

    @Override
    public Optional<Song> findById(long id) {
        return songDao.findById(id);
    }

    @Override
    public Optional<Song> findByTitle(String title) {
        return songDao.findByTitle(title);
    }
}