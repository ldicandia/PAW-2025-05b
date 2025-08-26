package ar.edu.itba.paw.models;

import lombok.Getter;

import java.util.Date;

@Getter
public class Vinyl {
    private final long id;
    private final String title;
    private final Date releaseDate;
    private final String genre;
    private final Float price;
    private final String condition;
    private final String publicationStatus;
    private final Integer stock;
    private final Date createdOn;

    public Vinyl(long id, String title, Date releaseDate, String genre, Float price,
                 String condition, String publicationStatus, Integer stock, Date createdOn) {
        this.id = id;
        this.title = title;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.price = price;
        this.condition = condition;
        this.publicationStatus = publicationStatus;
        this.stock = stock;
        this.createdOn = createdOn;
    }
}