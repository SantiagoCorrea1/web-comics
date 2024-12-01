package com.santiago.web.comics.services;

import com.santiago.web.comics.repositories.ChapterPageRepository;
import com.santiago.web.comics.repositories.ChapterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChapterService {

    final
    ChapterRepository chapterRepository;

    public ChapterService(ChapterRepository chapterRepository) {
        this.chapterRepository = chapterRepository;
    }
}
