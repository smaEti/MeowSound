package com.example.MeowSound;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Artist {
    private @Id @GeneratedValue long id;
    private boolean isVerified;
    private String thumbnail;
    private String name;
    @OneToOne
    private MyUser user;
    @OneToMany
    private List<Blog> blogs = new ArrayList<Blog>();
    @OneToMany
    private List<Album> albums = new ArrayList<Album>();

    public Artist() {
    }

    public Artist(MyUser user, boolean isVerified, String thumbnail, String name) {
        this.user = user;
        this.isVerified = isVerified;
        this.thumbnail = thumbnail;
        this.name = name;
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
                Objects.equals(name, artist.name) &&
                Objects.equals(thumbnail, artist.thumbnail);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, isVerified, thumbnail);
    }

    // public Long getId() {
    //     return id;
    // }

    // public void setId(Long id) {
    //     this.id = id;
    // }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    public void addBlog(Blog blog) {
        blogs.add(blog);
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyUser getUser() {
        return user;
    }

    public void setUser(MyUser user) {
        this.user = user;
    }

    @Override
    public String toString() {
        String StringBlogs = new String();
        String StringAlbums = new String();
        for (final Blog blog : blogs) {
            StringBlogs += blog.toString() + ',';
        }
        for (final Album album : albums) {
            StringAlbums += album.toString() + ',';
        }
        return "Artist{" +
                "id=" + id +
                ", isVerified='" + isVerified + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", name='" + name + '\'' +
                ", user='" + user.toString() + '\'' +
                ", albums='" + StringAlbums + '\'' +
                ", blogs='" + StringBlogs + '\'' +
                '}';
    }
}
