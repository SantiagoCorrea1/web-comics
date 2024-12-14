package com.santiago.web.comics.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Chapter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int chapterNumber;
    @ManyToOne
    @JoinColumn(name="comic_id", nullable=false)
    private Comic comic;
    @OneToMany(mappedBy = "chapter", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ChapterPage> chapterPages;

    public Chapter(Long id, String name, int chapter_number, Comic comic) {
        this.id = id;
        this.name = name;
        this.chapterNumber = chapter_number;
        this.comic = comic;
    }




}
