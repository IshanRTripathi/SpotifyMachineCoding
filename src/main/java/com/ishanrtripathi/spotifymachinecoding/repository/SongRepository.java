package com.ishanrtripathi.spotifymachinecoding.repository;

import com.ishanrtripathi.spotifymachinecoding.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song, Integer> {

}
