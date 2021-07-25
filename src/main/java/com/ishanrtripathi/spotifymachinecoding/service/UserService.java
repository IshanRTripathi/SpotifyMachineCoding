package com.ishanrtripathi.spotifymachinecoding.service;

import com.ishanrtripathi.spotifymachinecoding.models.Song;
import com.ishanrtripathi.spotifymachinecoding.models.User;
import com.ishanrtripathi.spotifymachinecoding.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findById(long id) {
        return userRepository.findById(id);
    }

    public List<Song> findSongById(long userId) {
        return userRepository.findSongById(userId);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public ResponseEntity<?> addUser(User user) {
        userRepository.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
