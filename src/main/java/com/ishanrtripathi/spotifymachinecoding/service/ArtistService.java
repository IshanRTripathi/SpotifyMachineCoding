package com.ishanrtripathi.spotifymachinecoding.service;

import com.ishanrtripathi.spotifymachinecoding.models.Album;
import com.ishanrtripathi.spotifymachinecoding.models.Artist;
import com.ishanrtripathi.spotifymachinecoding.models.Song;
import com.ishanrtripathi.spotifymachinecoding.repository.AlbumRepository;
import com.ishanrtripathi.spotifymachinecoding.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArtistService {

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private AlbumRepository albumRepository;

    public Optional<Artist> findById(long id) {
        return artistRepository.findById(Integer.parseInt(String.valueOf(id)));
    }

    public List<Album> findAlbumByArtistName(String artistName) {
        return albumRepository.findAll().stream().filter(album -> album.getArtistName().equals(artistName)).collect(Collectors.toList());
    }


    public ResponseEntity<?> addArtist(Artist artist) {
        artistRepository.save(artist);
        return new ResponseEntity<>(artist, HttpStatus.OK);
    }
}
