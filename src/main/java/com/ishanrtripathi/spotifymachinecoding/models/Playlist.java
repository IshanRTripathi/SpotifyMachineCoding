package com.ishanrtripathi.spotifymachinecoding.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Playlist {
    @Id
    long id;
    String playListName;
    int userId;
}
