package com.ishanrtripathi.spotifymachinecoding.controller;

import com.ishanrtripathi.spotifymachinecoding.models.Playlist;
import com.ishanrtripathi.spotifymachinecoding.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/playlists")
public class PlaylistController {

    @Autowired
    PlaylistService playlistService;

    @PostMapping("")
    public ResponseEntity<?> addNewPlaylist(@RequestBody Playlist playlist){
        return playlistService.addNewPlayList(playlist);
    }

    @GetMapping("")
    public ResponseEntity<?> getAllPlaylist(){
        return playlistService.getAllPlaylist();
    }
    @GetMapping("/{userId}")
    public ResponseEntity<?> getAllPlaylistOfUserByUserId(@PathVariable("userId") long userId){
        return playlistService.getAllPlaylistByUserId(userId);
    }
}
