package com.ishanrtripathi.spotifymachinecoding.controller;

import com.ishanrtripathi.spotifymachinecoding.models.Song;
import com.ishanrtripathi.spotifymachinecoding.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/songs")
public class SongController {

    @Autowired
    private SongService songService;

    @GetMapping("/{songId}")
    public ResponseEntity<?> getSongById(@PathVariable("songId") int songId){
        return songService.getSongById(songId);
    }

    @GetMapping("")
    public ResponseEntity<?> getAllSongs(){
        return songService.getAllSongs();
    }

    @PostMapping("")
    public ResponseEntity<?> addNewSong(@RequestBody Song song){
        return new ResponseEntity<>(songService.addSong(song), HttpStatus.OK);
    }
}
