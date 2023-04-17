package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Genre extends BaseEntity{
    private String name;

    @ManyToMany(mappedBy = "genreList")//give the ownership to the other object genreList
    private List<Movie> movieList;
}
