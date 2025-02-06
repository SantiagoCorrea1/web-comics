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
    private Set<String> authors;
    @NonNull
    private String format;
    @NonNull
    private String type;
    @NonNull
    private String status;
    @NonNull
    private String demographic;
    @NonNull
    private Set<String> genres;


}
