package com.example.spotify_encore;

public class TrackInfo {
    private String trackName;
    private String artistName;
    private String albumName;
    private String trackUrl;

    public TrackInfo(String trackName, String artistName, String albumName, String trackUrl) {
        this.trackName = trackName;
        this.artistName = artistName;
        this.albumName = albumName;
        this.trackUrl = trackUrl;
    }

    // Getters and setters for TrackInfo attributes
    // You can generate these using your IDE or write them manually

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getTrackUrl() {
        return trackUrl;
    }

    public void setTrackUrl(String trackUrl) {
        this.trackUrl = trackUrl;
    }
}