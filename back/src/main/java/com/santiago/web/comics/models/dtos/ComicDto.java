package com.santiago.web.comics.models.dtos;

import lombok.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class ComicDto {

    private Long id;
    @NonNull
    private String name;
    private String description;
    private String imgUrl;
    private String url;
    @NonNull
    private Set<Long> authors;
    @NonNull
    private Long format;
    @NonNull
    private Long type;
    @NonNull
    private Long status;
    @NonNull
    private Long demographic;
    @NonNull
    private Set<Long> genres;


}
