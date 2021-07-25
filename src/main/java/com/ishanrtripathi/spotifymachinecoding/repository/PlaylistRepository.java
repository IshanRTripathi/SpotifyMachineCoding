package com.ishanrtripathi.spotifymachinecoding.repository;

import com.ishanrtripathi.spotifymachinecoding.models.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
}
