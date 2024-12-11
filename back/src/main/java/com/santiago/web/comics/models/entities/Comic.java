package com.santiago.web.comics.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Comic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (nullable = false)
    private String name;
    private String description;
    private String imgUrl;
    @Column (unique = true)
    private String url;
    @ManyToMany
    @JoinTable(
            name = "comic_author",
            joinColumns = @JoinColumn(name = "comic_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "format_id", referencedColumnName = "id")
    private Format format;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    private Type type;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "demographic_id", referencedColumnName = "id")
    private Demographic demographic;
    @ManyToMany
    @JoinTable(
            name = "comic_genre",
            joinColumns = @JoinColumn(name = "comic_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<Genre> genres;
    @OneToMany (mappedBy = "comic")
    private Set<Chapter> chapters;

    public Comic(Long id, String name, String description, String imgUrl, Set<Author> authors, Format format, Type type, Status status, Demographic demographic, Set<Genre> genres) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imgUrl = imgUrl;
        this.authors = authors;
        this.format = format;
        this.type = type;
        this.status = status;
        this.demographic = demographic;
        this.genres = genres;
    }

    public Comic(Long id, String name, String description, String imgUrl, String url, Set<Author> authors, Format format, Type type, Status status, Demographic demographic, Set<Genre> genres) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imgUrl = imgUrl;
        this.url = url;
        this.authors = authors;
        this.format = format;
        this.type = type;
        this.status = status;
        this.demographic = demographic;
        this.genres = genres;
    }
}
