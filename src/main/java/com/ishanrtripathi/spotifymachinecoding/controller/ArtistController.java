package com.ishanrtripathi.spotifymachinecoding.controller;

import com.ishanrtripathi.spotifymachinecoding.models.Album;
import com.ishanrtripathi.spotifymachinecoding.models.Artist;
import com.ishanrtripathi.spotifymachinecoding.models.Song;
import com.ishanrtripathi.spotifymachinecoding.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.*;

@Controller
@RequestMapping("/artist")
public class ArtistController {

    @Autowired
    ArtistService artistService;

    @RequestMapping(value = "/{artistId}", method = RequestMethod.GET)
    public Optional<Artist> getArtist(@PathVariable("artistId") String artistId){
        return artistService.findById(Long.parseLong(artistId));
    }

    @RequestMapping(value = "/{artistName}", method = RequestMethod.GET)
    public List<Album> getAlbumByArtist(@PathVariable("artistName") String artistName){
        return artistService.findAlbumByArtistName(artistName);
    }

    /*@RequestMapping(value = "/{artistId}", method = RequestMethod.GET)
    public List<Album> addAlbum(@PathVariable("artistId") String artistId, @RequestBody Album album){
        Optional<Artist> artistOptional = artistService.findById(Long.parseLong(artistId));
        Artist artist= new Artist();
        if(artistOptional.isPresent()){
            artist= artistOptional.get();
            artist.getAlbums().add(new Album(album.getName(), album.getArtistName()));
        }
        else {
            artist.setArtistName("New Artist");
            artist.setAlbums(new ArrayList<>() {{
                add(new Album(album.getName(), album.getArtistName()));
            }
            });
            artistService.addArtist(artist);
        }
        return artist.getAlbums();
    }*/

    @RequestMapping(value= "", method = RequestMethod.POST)
    public ResponseEntity<?> addArtist(@RequestBody Artist artist){
        return artistService.addArtist(artist);
    }
}
