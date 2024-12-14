package com.santiago.web.comics.models.rquest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PageRequest {
    private Long id;
    private int page_number;
    @NonNull
    private String img_url;
}
