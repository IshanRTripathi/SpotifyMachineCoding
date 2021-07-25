package com.ishanrtripathi.spotifymachinecoding.service;

import com.ishanrtripathi.spotifymachinecoding.models.Playlist;
import com.ishanrtripathi.spotifymachinecoding.models.Song;
import com.ishanrtripathi.spotifymachinecoding.models.User;
import com.ishanrtripathi.spotifymachinecoding.repository.PlaylistRepository;
import com.ishanrtripathi.spotifymachinecoding.repository.SongRepository;
import com.ishanrtripathi.spotifymachinecoding.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    Logger LOGGER= LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private PlaylistRepository playlistRepository;

    public Optional<User> findById(long id) {
        return Optional.of(userRepository.findAll().stream().filter(user-> user.getId() == id).collect(Collectors.toList()).get(0));
    }

    public List<Song> findAllSongsByUserId(long userId) {
        List<Playlist>playlists= playlistRepository.findAll().stream().filter(playlist -> playlist.getUserId()==userId).collect(Collectors.toList());
//        playlists.forEach(System.out::println);
        List<Song> allSongs= new ArrayList<>();
        for(Playlist playlist: playlists) {
            List<Song> songs = songRepository.findAll().stream().filter(song -> song.getPlaylistId()==playlist.getId()).collect(Collectors.toList());
            allSongs.addAll(songs);
        }
        return allSongs;
    }

    public ResponseEntity<?> findAllUsers() {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> addUser(User user) {
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
