package ar.edu.itba.paw.models;

import lombok.Builder;
import lombok.Getter;
@Getter
@Builder
public class Song {
    private final long id;
    private final String title;
    private final String artist;
    private final int durationSec;
    private final int position;
    private final long vinylId;

    public Song(final long id, final String title, final String artist, final int durationSec, final int position, final long vinylId) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.durationSec = durationSec;
        this.position = position;
        this.vinylId = vinylId;
    }

}
