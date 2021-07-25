package com.ishanrtripathi.spotifymachinecoding.controller;


import com.ishanrtripathi.spotifymachinecoding.models.Song;
import com.ishanrtripathi.spotifymachinecoding.models.User;
import com.ishanrtripathi.spotifymachinecoding.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UserController {

    private static final Logger LOGGER= LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<?> getAllUsers(){
        return userService.findAllUsers();
    }

    @RequestMapping(value = "/profile/{userId}", method = RequestMethod.GET)
    public Optional<User> getUserProfile(@PathVariable("userId") String userId){
        return userService.findById(Integer.parseInt(userId));
    }

    @RequestMapping(value = "/allSongs/{userId}", method = RequestMethod.GET)
    public List<Song> getAllSongsOfPlaylistOfAUserByUserId(@PathVariable("userId") long userId){
        return userService.findAllSongsByUserId(userId);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<?> addUser(@RequestBody User user){
        LOGGER.info("called! ");
        return userService.addUser(user);
    }
}
