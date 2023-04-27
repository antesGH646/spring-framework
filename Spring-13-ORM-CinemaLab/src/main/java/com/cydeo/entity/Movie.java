package com.cydeo.entity;

import com.cydeo.enums.MovieState;
import com.cydeo.enums.MovieType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Movie extends BaseEntity{
    private String name;
    @Column(columnDefinition = "Date")
    private LocalDate releaseDate;
    private Integer duration;
    @Column(columnDefinition = "text")
    private String summary;
    @Enumerated(EnumType.STRING)
    private MovieType type;
    @Enumerated(EnumType.STRING)
    private MovieState state;
    private BigDecimal price;

    @ManyToMany
    @JoinTable(name="movie_genre_rel", //to change the table name
            joinColumns = @JoinColumn(name = "movie_id"),//to change the column name
            inverseJoinColumns = @JoinColumn(name = "genre_id")//to change the column name
    )
    private List<Genre> genreList;

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", releaseDate=" + releaseDate +
                ", duration=" + duration +
                ", summary='" + summary + '\'' +
                ", type=" + type +
                ", state=" + state +
                ", price=" + price +
                '}';
    }
}
