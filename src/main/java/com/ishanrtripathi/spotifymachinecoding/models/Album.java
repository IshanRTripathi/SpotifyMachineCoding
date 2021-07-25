package com.ishanrtripathi.spotifymachinecoding.models;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@Entity
public class Album {

    @Id
    long id;
    String name;
    String artistName;

    public Album(String name, String artistName){
        this.name= name; this.artistName=artistName;
    }

    public Album() {

    }
}
