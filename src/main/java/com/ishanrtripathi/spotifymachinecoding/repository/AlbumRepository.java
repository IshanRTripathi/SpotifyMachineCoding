package com.ishanrtripathi.spotifymachinecoding.repository;

import com.ishanrtripathi.spotifymachinecoding.models.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Integer> {
}
