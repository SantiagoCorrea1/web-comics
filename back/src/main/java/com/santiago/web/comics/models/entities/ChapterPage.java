package com.santiago.web.comics.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ChapterPage {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private int page_number;
    private String img_url;
    @ManyToOne
    @JoinColumn(name = "chapter_id")
    private Chapter chapter;
}
