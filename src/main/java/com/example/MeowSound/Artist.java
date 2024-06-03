package com.example.MeowSound;

import java.util.Objects;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Artist {
    private @Id @GeneratedValue long id;
    private boolean isVerified;
    private String thumbnail;
    @OneToOne
    private User user;

    public Artist() {
    }

    public Artist(boolean isVerified, String thumbnail) {
        this.isVerified = isVerified;
        this.thumbnail = thumbnail;
    }

    public Artist(User user, boolean isVerified, String thumbnail) {
        this.user = user;
        this.isVerified = isVerified;
        this.thumbnail = thumbnail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Artist artist = (Artist) o;
        return Objects.equals(id, artist.id) &&
                Objects.equals(isVerified, artist.isVerified) &&
                Objects.equals(thumbnail, artist.thumbnail);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, isVerified, thumbnail);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", isVerified='" + isVerified + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", user='" + user.toString() + '\'' +
                '}';
    }
}
