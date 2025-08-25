package ar.edu.itba.paw.webapp;

public class Vinyl {
    private String title;
    private String artist;
    private String imageUrl;
    private Double price;
    private java.util.Date releaseDate;

    public Vinyl(String title, String artist, String imageUrl, Double price, java.util.Date releaseDate) {
        this.title = title; this.artist = artist; this.imageUrl = imageUrl; this.price = price; this.releaseDate = releaseDate;
    }
    public String getTitle() { return title; }
    public String getArtist() { return artist; }
    public String getImageUrl() { return imageUrl; }
    public Double getPrice() { return price; }
    public java.util.Date getReleaseDate() { return releaseDate; }
}
