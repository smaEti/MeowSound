package com.example.MeowSound;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {
    private final ArtistRepository artistRepository;
    private final MyUserRepository myUserRepository;
    private final BlogRepository blogRepository;

    @Autowired
    public DatabaseLoader(ArtistRepository artistRepository, MyUserRepository myUserRepository,
            BlogRepository blogRepository) {
        this.artistRepository = artistRepository;
        this.myUserRepository = myUserRepository;
        this.blogRepository = blogRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        // MyUser Seed
        MyUser user1 = new MyUser("user1", "1234", "");
        MyUser user2 = new MyUser("user2", "2345", "");
        this.myUserRepository.save(user1);
        this.myUserRepository.save(user2);
        // Artist Seed
        Artist artist1 = new Artist(user1, false, "", "system of a down");
        Artist artist2 = new Artist(user2, true, "", "Nirvana");
        this.artistRepository.save(artist1);
        this.artistRepository.save(artist2);
        // Blog seed
        Blog blog1 = new Blog("1", "this is the blog text!!", new Date().getTime(), artist1);
        Blog blog2 = new Blog("2", "this is the blog text2!!", new Date().getTime(), artist2);
        Blog blog3 = new Blog("4", "this is the blog text4!!", new Date().getTime(), artist2);
        Blog blog4 = new Blog("3", "this is the blog text3!!", new Date().getTime(), artist2);
        Blog blog5 = new Blog("5", "this is the blog text5!!", new Date().getTime(), artist1);

        this.blogRepository.save(blog1);
        this.blogRepository.save(blog2);
        this.blogRepository.save(blog3);
        this.blogRepository.save(blog4);
        this.blogRepository.save(blog5);
        artist1.addBlog(blog5);
        artist1.addBlog(blog1);
        artist2.addBlog(blog2);
        artist2.addBlog(blog3);
        artist2.addBlog(blog4);
        this.artistRepository.save(artist2);
        this.artistRepository.save(artist1);


    }
}
