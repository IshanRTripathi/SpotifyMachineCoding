package com.ishanrtripathi.spotifymachinecoding.controller;


import com.ishanrtripathi.spotifymachinecoding.models.Song;
import com.ishanrtripathi.spotifymachinecoding.models.User;
import com.ishanrtripathi.spotifymachinecoding.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RequestMapping("/users")
public class UserController {

    private static final Logger LOGGER= LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public List<User> getAllUsers(){
        return userService.findAllUsers();
    }

    @RequestMapping(value = "/profile/{userId}", method = RequestMethod.GET)
    public User getUserProfile(@PathVariable("userId") String userId){
        return userService.findById(Integer.parseInt(userId));
    }

    @RequestMapping(value = "/profile/{userId}", method = RequestMethod.GET)
    public List<Song> getRecentlyPlayedSongs(@PathVariable("userId") String userId){
        return userService.findSongById(Long.parseLong(userId));
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String addUser(@RequestBody User user){
        LOGGER.info("called! ");
        userService.addUser(user);
        return "Success !";
    }
}
