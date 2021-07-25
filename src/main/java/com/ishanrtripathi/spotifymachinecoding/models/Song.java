package com.ishanrtripathi.spotifymachinecoding.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Song {
    @Id
    long id;
    String songName;
    String genre;
}
