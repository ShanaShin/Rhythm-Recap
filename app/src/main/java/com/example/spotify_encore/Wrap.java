package com.example.spotify_encore;

import java.util.ArrayList;
import java.util.List;

public class Wrap {
    private List<TrackInfo> topTracks;
    private List<String> topArtists;
    private String topAlbum;
    private String topArtist;

    public Wrap() {
        topTracks = new ArrayList<>();
        topArtists = new ArrayList<>();
    }

    public List<TrackInfo> getTopTracks() {
        return topTracks;
    }

    public List<String> getTopArtists() {
        return topArtists;
    }

    public void setTopTracks(List<TrackInfo> topTracks) {
        this.topTracks = topTracks;
    }

    public String getTopAlbum() {
        return topAlbum;
    }

    public void setTopAlbum(String topAlbum) {
        this.topAlbum = topAlbum;
    }

    public String getTopArtist() {
        return topArtist;
    }

    public void setTopArtist(String topArtist) {
        this.topArtist = topArtist;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Top Tracks:\n");
        for (TrackInfo track : topTracks) {
            sb.append("Track Name: ").append(track.getTrackName()).append("\n");
            sb.append("Artist Name: ").append(track.getArtistName()).append("\n");
            sb.append("Album Name: ").append(track.getAlbumName()).append("\n");
            sb.append("Track URL: ").append(track.getTrackUrl()).append("\n");
            sb.append("\n");
        }
        sb.append("Top Album: ").append(topAlbum).append("\n");
        sb.append("Top Artist: ").append(topArtist).append("\n");
        return sb.toString();
    }

}