package com.ishanrtripathi.spotifymachinecoding.service;

import com.ishanrtripathi.spotifymachinecoding.models.Song;
import com.ishanrtripathi.spotifymachinecoding.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class SongService {

    @Autowired
    private SongRepository songRepository;

    public ResponseEntity<?> addSong(Song song){
        songRepository.save(song);
        return new ResponseEntity<>(song, HttpStatus.OK);
    }

    public ResponseEntity<?> getSongById(int songId) {
        Song song= songRepository.findAll().stream().filter(songEach-> songEach.getId()==songId).collect(Collectors.toList()).get(0);
        return new ResponseEntity<>(song, HttpStatus.OK);
    }

    public ResponseEntity<?> getAllSongs() {
        return new ResponseEntity<>(songRepository.findAll(), HttpStatus.OK);
    }
}
