package com.example.MeowSound;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.aspectj.weaver.ast.And;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {
    private final ArtistRepository artistRepository;
    private final MyUserRepository myUserRepository;
    private final BlogRepository blogRepository;
    private final AlbumRepository albumRepository;
    private final AudioFileRepository audioFileRepository;

    @Autowired
    public DatabaseLoader(ArtistRepository artistRepository, MyUserRepository myUserRepository,
            BlogRepository blogRepository, AlbumRepository albumRepository, AudioFileRepository audioFileRepository) {
        this.artistRepository = artistRepository;
        this.myUserRepository = myUserRepository;
        this.blogRepository = blogRepository;
        this.albumRepository = albumRepository;
        this.audioFileRepository = audioFileRepository;
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
        Album album1 = new Album("Toxicity", artist1, new Date().getTime());
        Album album2 = new Album("nevermind", artist2, new Date().getTime());
        this.albumRepository.save(album1);
        this.albumRepository.save(album2);
        AudioFile audio1 = new AudioFile(artist1, "Aerials", "",
                "Life is a waterfall \n" +
                        "We're one in the river and one again after the fall\n" +
                        "Swimming through the void, we hear the word\n" +
                        "We lose ourselves, but we find it all\n" +
                        "'Cause we are the ones that wanna play\n" +
                        "Always wanna go, but you never wanna stay\n" +
                        "And we are the ones that wanna choose\n" +
                        "Always wanna play, but you never wanna lose\n" +
                        "Aerials in the sky\n" +
                        "When you lose small mind, you free your life\n" +
                        "Life is a waterfall\n" +
                        "We drink from the river, then we turn around and put up our walls\n" +
                        "Swimming through the void, we hear the word\n" +
                        "We lose ourselves, but we find it all\n" +
                        "'Cause we are the ones that wanna play\n" +
                        "Always wanna go, but you never wanna stay\n" +
                        "And we are the ones that wanna choose\n" +
                        "Always wanna play, but you never wanna lose, oh\n" +
                        "Aerials in the sky\n" +
                        "When you lose small mind, you free your life\n" +
                        "Aerials, so up high\n" +
                        "When you free your eyes, eternal prize\n" +
                        "Aerials in the sky\n" +
                        "When you lose small mind, you free your life\n" +
                        "Aerials, so up high\n" +
                        "When you free your eyes, eternal prize\n",
                244, album1, new Date().getTime());
        AudioFile audio2 = new AudioFile(artist1, "Chop Suey!", "",
                "Wake up (wake up)\n" +
                        "Grab a brush and put a little make-up\n" +
                        "Hide the scars to fade away the shake-up (hide the scars to fade away the-)\n" +
                        "Why'd you leave the keys upon the table?\n" +
                        "Here you go create another fable, you wanted to\n" +
                        "Grab a brush and put a little make-up, you wanted to\n" +
                        "Hide the scars to fade away the shake-up, you wanted to\n" +
                        "Why'd you leave the keys upon the table? You wanted to\n" +
                        "I don't think you trust\n" +
                        "In my self-righteous suicide\n" +
                        "I cry when angels deserve to die\n" +
                        "Wake up (wake up)\n" +
                        "Grab a brush and put a little make-up\n" +
                        "Hide the scars to fade away the (hide the scars to fade away the shake-up)\n" +
                        "Why'd you leave the keys upon the table?\n" +
                        "Here you go create another fable, you wanted to\n" +
                        "Grab a brush and put a little make-up, you wanted to\n" +
                        "Hide the scars to fade away the shake-up, you wanted to\n" +
                        "Why'd you leave the keys upon the table? You wanted to\n" +
                        "I don't think you trust\n" +
                        "In my self-righteous suicide\n" +
                        "I cry when angels deserve to die\n" +
                        "In my self-righteous suicide\n" +
                        "I cry when angels deserve to die\n" +
                        "Father (father)\n" +
                        "Father (father)\n" +
                        "Father (father)\n" +
                        "Father (father)\n" +
                        "Father, into your hands I commend my spirit\n" +
                        "Father, into your hands\n" +
                        "Why have you forsaken me?\n" +
                        "In your eyes forsaken me\n" +
                        "In your thoughts forsaken me\n" +
                        "In your heart forsaken me, oh\n" +
                        "Trust in my self-righteous suicide\n" +
                        "I cry when angels deserve to die\n" +
                        "In my self-righteous suicide\n" +
                        "I cry when angels deserve to die\n",
                210, album1, new Date().getTime());
        AudioFile audio3 = new AudioFile(artist2, "Something in the way", "",
                "Underneath the bridge, tarp has sprung a leak\n" +
                        "And the animals I've trapped have all become my pets\n" +
                        "And I'm living off of grass, and the drippings from my ceiling\n" +
                        "It's OK to eat fish 'cause they don't have any feelings\n" +
                        "Something in the way, hmm-mmm\n" +
                        "Something in the way, yeah, hmm-mmm\n" +
                        "Something in the way, hmm-mmm\n" +
                        "Something in the way, yeah, hmm-mmm\n" +
                        "Something in the way, hmm-mmm\n" +
                        "Something in the way, yeah, hmm-mmm\n" +
                        "Underneath the bridge, tarp has sprung a leak\n" +
                        "And the animals I've trapped have all become my pets\n" +
                        "And I'm living off of grass, and the drippings from my ceiling\n" +
                        "It's OK to eat fish 'cause they don't have any feelings\n" +
                        "Something in the way, hmm-mmm\n" +
                        "Something in the way, yeah, hmm-mmm\n" +
                        "Something in the way, hmm-mmm\n" +
                        "Something in the way, yeah, hmm-mmm\n" +
                        "Something in the way, hmm-mmm\n" +
                        "Something in the way, yeah, hmm-mmm\n" +
                        "Something in the way, hmm-mmm\n" +
                        "Something in the way, yeah, hmm-mmm\n",
                230, album2, new Date().getTime());
        AudioFile audio4 = new AudioFile(artist2, "Smells like teen spirit", "",
                "Load up on guns, bring your friends\n" +
                        "It's fun to lose and to pretend\n" +
                        "She's over bored and self-assured\n" +
                        "Oh, no, I know a dirty word\n" +
                        "Hello, hello, hello, how low?\n" +
                        "Hello, hello, hello, how low?\n" +
                        "Hello, hello, hello, how low?\n" +
                        "Hello, hello, hello\n" +
                        "With the lights out, it's less dangerous\n" +
                        "Here we are now, entertain us\n" +
                        "I feel stupid and contagious\n" +
                        "Here we are now, entertain us\n" +
                        "A mulatto, an albino\n" +
                        "A mosquito, my libido, yeah\n" +
                        "Hey\n" +
                        "Yeah\n" +
                        "I'm worse at what I do best\n" +
                        "And for this gift I feel blessed\n" +
                        "Our little group it's always been\n" +
                        "And always will until the end\n" +
                        "Hello, hello, hello, how low?\n" +
                        "Hello, hello, hello, how low?\n" +
                        "Hello, hello, hello, how low?\n" +
                        "Hello, hello, hello\n" +
                        "With the lights out, it's less dangerous\n" +
                        "Here we are now entertain us\n" +
                        "I feel stupid and contagious\n" +
                        "Here we are now entertain us\n" +
                        "A mulatto, an albino\n" +
                        "A mosquito, my libido, yeah\n" +
                        "Hey\n" +
                        "Yeah\n" +
                        "And I forget, just why I taste\n" +
                        "Oh yeah, I guess it makes me smile\n" +
                        "I found it hard, it's hard to find\n" +
                        "Oh well, whatever, never mind\n" +
                        "Hello, hello, hello, how low?\n" +
                        "Hello, hello, hello, how low?\n" +
                        "Hello, hello, hello, how low?\n" +
                        "Hello, hello, hello\n" +
                        "With the lights out, it's less dangerous\n" +
                        "Here we are now, entertain us\n" +
                        "I feel stupid, and contagious\n" +
                        "Here we are now, entertain us\n" +
                        "A mulatto, an albino\n" +
                        "A mosquito, my libido\n" +
                        "A denial, a denial\n" +
                        "A denial, a denial\n" +
                        "A denial, a denial\n" +
                        "A denial, a denial\n" +
                        "A denial\n",
                301, album2, new Date().getTime());

        this.audioFileRepository.save(audio1);
        this.audioFileRepository.save(audio2);
        this.audioFileRepository.save(audio3);
        this.audioFileRepository.save(audio4);
        List<AudioFile> audios1 = new ArrayList<>();
        audios1.add(audio1);
        audios1.add(audio2);
        List<AudioFile> audios2 = new ArrayList<>();
        audios2.add(audio3);
        audios2.add(audio4);
        album1.setAudioFiles(audios1);
        album2.setAudioFiles(audios2);
        this.albumRepository.save(album1);
        this.albumRepository.save(album2);
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
