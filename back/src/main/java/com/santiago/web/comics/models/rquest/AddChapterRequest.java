package com.santiago.web.comics.models.rquest;

import com.santiago.web.comics.models.dtos.ChapterDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class AddChapterRequest {
    private ChapterDto chapter;
    private Set<PageRequest> pageRequests;
}
