package com.santiago.web.comics.services;

import com.santiago.web.comics.repositories.ChapterPageRepository;
import org.springframework.stereotype.Service;

@Service
public class ChapterPageService {

    final ChapterPageRepository chapterPageRepository;

    public ChapterPageService(ChapterPageRepository chapterPageRepository) {
        this.chapterPageRepository = chapterPageRepository;
    }
}
