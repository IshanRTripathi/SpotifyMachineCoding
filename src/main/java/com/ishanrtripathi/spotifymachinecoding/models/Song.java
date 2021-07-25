package com.ishanrtripathi.spotifymachinecoding.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@Data
public class Song {
    @Id
    @GeneratedValue
    long id;
    String songName;
    String genre;
    int playlistId;
}
