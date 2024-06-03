package com.example.MeowSound;

import java.util.Objects;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class User {
    private @Id @GeneratedValue long id;
    private String username;
    private String password;
    private String profilePicture;

    public User() {
    }

    public User(String username, String password, String profilePicture) {
        this.username = username;
        this.password = password;
        this.profilePicture = profilePicture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(profilePicture, user.profilePicture);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, username, password, profilePicture);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", profilePicture='" + profilePicture + '\'' +
                '}';
    }
}
