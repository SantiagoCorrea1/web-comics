package com.santiago.web.comics.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class ChapterDto {
    private Long id;
    private String name;
    private int chapter_number;
    private Long comicId;
}
