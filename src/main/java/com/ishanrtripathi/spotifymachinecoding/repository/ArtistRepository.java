package com.ishanrtripathi.spotifymachinecoding.repository;

import com.ishanrtripathi.spotifymachinecoding.models.Album;
import com.ishanrtripathi.spotifymachinecoding.models.Artist;
import com.ishanrtripathi.spotifymachinecoding.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Integer> {
    @Query("from Album a where a.artistName= ?1")
    List<Album> findAlbumByArtistName(String artistName);
}
