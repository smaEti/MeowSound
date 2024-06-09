package com.example.MeowSound;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Album {
    private @Id @GeneratedValue long id;
    @ManyToOne
    private Artist artist;
    private String title;
    private int audioFileCount;
    private long created_at;
    @OneToMany
    private List<AudioFile> audioFiles = new ArrayList<AudioFile>();

    public Album(){}
    public Album(String title, Artist artist, long created_at, List<AudioFile> audioFiles) {
        this.title = title;
        this.artist = artist;
        this.created_at = created_at;
        this.audioFiles = audioFiles;
        this.audioFileCount = audioFiles.size();
    }

    public Album(String title, Artist artist, long created_at) {
        this.title = title;
        this.artist = artist;
        this.created_at = created_at;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Album album = (Album) o;
        return Objects.equals(id, album.id) &&
                Objects.equals(title, album.title) &&
                Objects.equals(audioFileCount, album.audioFileCount) &&
                Objects.equals(created_at, album.created_at) &&
                Objects.equals(audioFiles, album.audioFiles);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, title, audioFileCount, created_at, audioFiles);
    }

    // public Long getId() {
    //     return id;
    // }

    // public void setId(Long id) {
    //     this.id = id;
    // }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAudioFiles(List<AudioFile> audioFiles) {
        this.audioFiles = audioFiles;
    }

    public List<AudioFile> getAudioFiles() {
        return this.audioFiles;
    }

    public void addAudioFile(AudioFile audioFile) {
        this.audioFiles.add(audioFile);
        this.audioFileCount++;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", audioFileCount='" + audioFileCount + '\'' +
                ", created_at='" + created_at + '\'' +
                // ", audioFiles='" + created_at + '\'' +
                '}';
    }
}
