package com.example.MeowSound;

import java.util.Objects;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Blog {
    private @Id @GeneratedValue long id;
    private String imageURL;
    private String text;
    private long created_at;
    @ManyToOne
    private Artist artist;

    Blog() {
    }

    Blog(String imageURL, String text, long created_at, Artist artist) {
        this.artist = artist;
        this.created_at = created_at;
        this.text = text;
        this.imageURL = imageURL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Blog blog = (Blog) o;
        return Objects.equals(this.id, blog.id) &&
                Objects.equals(this.text, blog.text) &&
                Objects.equals(this.imageURL, blog.imageURL) &&
                Objects.equals(this.artist, blog.artist) &&
                Objects.equals(this.created_at, blog.created_at);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, imageURL, text, created_at, artist);
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImageURL() {
        return this.imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Artist geArtist() {
        return this.artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", imageURL='" + imageURL + '\'' +
                ", text='" + text + '\'' +
                ", created_at='" + created_at + '\'' +
                ", artist='" + artist.toString() + '\'' +
                '}';
    }
}
