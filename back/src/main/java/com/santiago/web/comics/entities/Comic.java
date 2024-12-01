package com.santiago.web.comics.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Comic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (nullable = false)
    private String name;
    private String description;
    private String imgUrl;
    @ManyToMany
    @JoinTable(
            name = "comic_author",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "comic_id"))
    private Set<Author> authors;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "format_id", referencedColumnName = "id")
    private Format format;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    private Type type;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "demographic_id", referencedColumnName = "id")
    private Demographic demographic;
    @ManyToMany
    @JoinTable(
            name = "comic_genre",
            joinColumns = @JoinColumn(name = "genre_id"),
            inverseJoinColumns = @JoinColumn(name = "comic_id")
    )
    private Set<Genre> genres;
    @OneToMany (mappedBy = "comic")
    private Set<Chapter> chapters;
}
