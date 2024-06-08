package com.example.MeowSound;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {
    private final ArtistRepository artistRepository;
    private final MyUserRepository myUserRepository;

    @Autowired
    public DatabaseLoader(ArtistRepository artistRepository, MyUserRepository myUserRepository){
        this.artistRepository = artistRepository;
        this.myUserRepository = myUserRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        //MyUser Seed
        MyUser user1 = new MyUser("user1","1234","");
        MyUser user2 = new MyUser("user2","2345","");
        this.myUserRepository.save(user1);
        this.myUserRepository.save(user2);
        //Artist Seed
        this.artistRepository.save(new Artist(user1,false,""));
        this.artistRepository.save(new Artist(user2,true,""));

    }
}
