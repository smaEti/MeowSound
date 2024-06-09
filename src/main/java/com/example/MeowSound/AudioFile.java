package com.example.MeowSound;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class AudioFile {
    private @Id @GeneratedValue long id;
    @ManyToOne
    private Artist artist;
    private String title;
    private String audioFileURL;
    private String lyrics;
    private int length;
    @ManyToOne
    private Album album;
    private long created_at;

    AudioFile(Artist artist, String title, String audioFileURL, String lyrics, int length, Album album,
            long created_at) {
        this.artist = artist;
        this.title = title;
        this.audioFileURL = audioFileURL;
        this.lyrics = lyrics;
        this.length = length;
        this.album = album;
        this.created_at = created_at;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        AudioFile audio = (AudioFile) o;
        return Objects.equals(this.id, audio.id) &&
                Objects.equals(this.title, audio.title) &&
                Objects.equals(this.audioFileURL, audio.audioFileURL) &&
                Objects.equals(this.lyrics, audio.lyrics) &&
                Objects.equals(this.length, audio.length) &&
                Objects.equals(this.album, audio.album) &&
                Objects.equals(this.artist, audio.artist) &&
                Objects.equals(this.created_at, audio.created_at);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, title, audioFileURL, artist, lyrics, length, album, created_at);
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Artist getArtist() {
        return this.artist;
    }

    // public void setId()

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setAudioFileURL(String audioFileURL) {
        this.audioFileURL = audioFileURL;
    }

    public String getAudioFileURL() {
        return this.audioFileURL;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public String getLyrics() {
        return this.lyrics;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getLength() {
        return this.length;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Album getAlbum() {
        return this.album;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", audioFileURL='" + audioFileURL + '\'' +
                ", created_at='" + created_at + '\'' +
                ", album='" + album.toString() + '\'' +
                ", length='" + length + '\'' +
                ", lyrics='" + lyrics + '\'' +
                ", artist='" + artist.toString() + '\'' +
                '}';
    }
}
