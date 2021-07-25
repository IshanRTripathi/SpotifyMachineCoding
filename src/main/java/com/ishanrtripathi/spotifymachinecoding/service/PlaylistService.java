package com.ishanrtripathi.spotifymachinecoding.service;

import com.ishanrtripathi.spotifymachinecoding.models.Playlist;
import com.ishanrtripathi.spotifymachinecoding.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PlaylistService {

    @Autowired
    PlaylistRepository playlistRepository;

    public ResponseEntity<?> addNewPlayList(Playlist playlist){
        playlistRepository.save(playlist);
        return new ResponseEntity<>(playlist, HttpStatus.OK);
    }

    public ResponseEntity<?> getAllPlaylist() {
        return new ResponseEntity<>(playlistRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> getAllPlaylistByUserId(long userId) {
        return new ResponseEntity<>(playlistRepository.findAll().stream().filter(playlist -> playlist.getUserId()==userId), HttpStatus.OK);
    }
}
